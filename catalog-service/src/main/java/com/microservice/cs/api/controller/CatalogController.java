package com.microservice.cs.api.controller;

import com.microservice.cs.api.common.AddCatalogRequest;
import com.microservice.cs.api.common.AddCatalogResponse;
import com.microservice.cs.api.common.GetIdCatalogResponse;
import com.microservice.cs.api.entity.Catalog;
import com.microservice.cs.api.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService service;

    @PostMapping("/addCatalog")
    private AddCatalogResponse addCatalog(@RequestBody AddCatalogRequest request){return service.addCatalog(request);}

    @GetMapping("/{catalogId}")
    private GetIdCatalogResponse findCatalogById(@PathVariable int catalogId){return service.getIdCatalogResponse(catalogId);}


}
