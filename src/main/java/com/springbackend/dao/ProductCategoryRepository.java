package com.springbackend.dao;


import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springbackend.entity.Product;
import com.springbackend.entity.ProductCategory;

@CrossOrigin("http://localhost:4200") // server that the angular app is running on
//adds specifications to accessing resources on your API when using Spring Data REST
@RepositoryRestResource(collectionResourceRel = "productCategory", path ="product-category")
public interface ProductCategoryRepository extends JpaRepository <ProductCategory , Long> {

   
    
}