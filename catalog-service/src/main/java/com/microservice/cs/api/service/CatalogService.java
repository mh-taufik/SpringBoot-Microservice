package com.microservice.cs.api.service;

import com.microservice.cs.api.common.AddCatalogRequest;
import com.microservice.cs.api.common.AddCatalogResponse;
import com.microservice.cs.api.common.GetIdCatalogResponse;
import com.microservice.cs.api.entity.Catalog;
import com.microservice.cs.api.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogService {
    @Autowired
    private CatalogRepository repository;

    public AddCatalogResponse addCatalog(AddCatalogRequest request){
        Catalog catalog = request.getCatalog();
        repository.save(catalog);

        return new AddCatalogResponse(catalog);
    }

    public GetIdCatalogResponse getIdCatalogResponse(Integer catalogId){
        Optional<Catalog> oCatalog = repository.findById(catalogId);
        Catalog catalogTemp = new Catalog();
        if(!oCatalog.isEmpty()){
            Catalog catalog = oCatalog.get();
            return new GetIdCatalogResponse(catalog,"sudah ketemu");
        }else{
            return new GetIdCatalogResponse(catalogTemp,"tidak ketemu");
        }
    }
}
