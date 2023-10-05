package com.springbackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbackend.dto.Purchase;
import com.springbackend.dto.PurchaseResponse;
import com.springbackend.service.CheckoutService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    //@autowired optional but not neccesary as there is only one meyhod
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService=checkoutService;
    }
    
    @PostMapping("/purchase")
    //return purchase response
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){

        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase); //delegate to service

        return purchaseResponse; //return via rest api
    }
}
