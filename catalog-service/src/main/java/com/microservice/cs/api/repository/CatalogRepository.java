package com.microservice.cs.api.repository;

import com.microservice.cs.api.entity.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<Catalog,Integer> {
}
