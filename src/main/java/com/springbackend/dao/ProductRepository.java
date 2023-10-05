package com.springbackend.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.springbackend.entity.Product;

@CrossOrigin("http://localhost:4200") // server that the angular app is running on
                                                        //entity type   //primary key
public interface ProductRepository extends JpaRepository<Product, Long>{
    
     //adding query methods for categoty id mapping 
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    //http://localhost:8080/api/products/search/findByNameContaining?name=Python
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);// SELECT * From Product p WHERE p.name LIKE CONCAT ('%', :name, '%')

}
