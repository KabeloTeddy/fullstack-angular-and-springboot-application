package com.springbackend.dto;

import lombok.Data;

@Data
public class PurchaseResponse {
    //use this class to send back a java object as JSON

    //@NonNull
    //private  String orderTrackingNumber;
    
    private final  String orderTrackingNumber;
    
}
