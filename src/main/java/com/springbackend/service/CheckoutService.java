package com.springbackend.service;

import com.springbackend.dto.Purchase;
import com.springbackend.dto.PurchaseResponse;

public interface CheckoutService {
    
    //pass in purchase dta and send back the purchase response
    PurchaseResponse placeOrder(Purchase purchase);
}
