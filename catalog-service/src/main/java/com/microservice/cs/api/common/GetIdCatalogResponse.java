package com.microservice.cs.api.common;

import com.microservice.cs.api.entity.Catalog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetIdCatalogResponse {
    private Catalog catalog;
    private String msg;
}
