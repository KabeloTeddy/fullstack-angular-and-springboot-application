package com.springbackend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbackend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{ //Customer will have a collection of orders.
    //will grab the customer when a purcahse comes accross, assemble it accordingl=nly and save the acyuall customer
    
}
