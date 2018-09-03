package com.speed.sky.paypalspringboot.controller;

import com.paypal.api.payments.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speed.sky.paypalspringboot.service.PaypalService;

@RestController("api")
public class PaypalRestController {

    @Autowired
    PaypalService paypalService;

    @GetMapping
    public String getTest() {
        return "Hello, Sambit!";
    }

    @GetMapping("/paypal/create")
    public String createPayment(){
        Payment pay = paypalService.createPayment();
        return pay.toString();
    }
}
