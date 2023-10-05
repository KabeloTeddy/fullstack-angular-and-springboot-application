package com.springbackend.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbackend.dao.CustomerRepository;
import com.springbackend.dto.Purchase;
import com.springbackend.dto.PurchaseResponse;
import com.springbackend.entity.Customer;
import com.springbackend.entity.Order;
import com.springbackend.entity.OrderItem;

import jakarta.transaction.Transactional;


@Service
public class CheckoutServiceImple implements CheckoutService {

    private CustomerRepository customerRepository;

    
    public CheckoutServiceImple (CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }; //inject on constructor

    @Override
    @Transactional //jpa stuff
    public PurchaseResponse placeOrder(Purchase purchase) {

       //retrieve the order info from dto

       Order order = purchase.getOrder();

       //generate tracking number
       String orderTrackingNumber = generateOrderTrackingNumber();
       order.setOrderTrackingNumber(orderTrackingNumber);
        
       //populate order with orderItems
       Set<OrderItem> orderItems = purchase.getOrderItems(); //get items from purchase dta
       
       orderItems.forEach(item -> order.add(item)); //loop each one of the orderItems and add then to order


       //populate order with billingAddress and zshippingAddress

       order.setBillingAddress(purchase.getBillingAddress());
       order.setShippingAddress(purchase.getShippingAddress());

       //populate customer with the order
       Customer customer = purchase.getCustomer();
       customer.add(order);

       //save to the database using jps repository  for customer repository
        customerRepository.save(customer);


       //return a response

       return new PurchaseResponse(orderTrackingNumber);
    }
    

    private String generateOrderTrackingNumber() {
        //create a unique id(hard to guess )

        //generate a random uuid number (UUID version-4)
        //wikipedia uiid 
        return UUID.randomUUID().toString();
    }
    
}
