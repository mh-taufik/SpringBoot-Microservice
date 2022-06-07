package com.microservice.os.api.service;

import com.microservice.os.api.common.*;
import com.microservice.os.api.entity.Order;
import com.microservice.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Autowired
    private RestTemplate template;

    public TransactionResponse saveOrder(TransactionRequest request){
        String message;
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getId());
            //rest call
        CatalogByIdResponse responseCatalog = template.getForObject("http://CATALOG-SERVICE/catalog/"+order.getCatalogId(),CatalogByIdResponse.class);
        payment.setAmount(responseCatalog.getCatalog().getPrice()*order.getQty());
        Payment response = template.postForObject("http://PAYMENT-SERVICE/payment/doPayment", payment, Payment.class);
        message = response.getPaymentStatus().equals("success") ? "payment processing successful and order placed" : "there is an eror occured, order placed in cart";
        repository.save(order);

        return new TransactionResponse(responseCatalog.getCatalog().getName(),order, response.getAmount(), response.getTransactionId(), message);
    }

    public String testOrder(){
        System.out.println("============================================");
        CatalogByIdResponse responseCatalog = template.getForObject("http://CATALOG-SERVICE/catalog/"+"1",CatalogByIdResponse.class);

        return "test"+responseCatalog.getCatalog().getName();
    }
}
