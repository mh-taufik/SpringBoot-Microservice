package com.microservice.cs.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOG_ID")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Catalog {
    @Id
    private int catalogId;
    private String name;
    private double price;
//    private int stock;
}
