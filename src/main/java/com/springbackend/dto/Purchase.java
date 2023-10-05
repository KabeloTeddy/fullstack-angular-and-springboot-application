package com.springbackend.dto;

import java.util.Set;

import com.springbackend.entity.Address;
import com.springbackend.entity.Customer;
import com.springbackend.entity.Order;
import com.springbackend.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
    
}
