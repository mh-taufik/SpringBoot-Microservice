package com.microservice.os.api.controller;

import com.microservice.os.api.common.Payment;
import com.microservice.os.api.common.TransactionRequest;
import com.microservice.os.api.common.TransactionResponse;
import com.microservice.os.api.entity.Order;
import com.microservice.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){
        return service.saveOrder(request);
    }

    @GetMapping("/test")
    public String testOrder(){
        return service.testOrder();
    }
}
