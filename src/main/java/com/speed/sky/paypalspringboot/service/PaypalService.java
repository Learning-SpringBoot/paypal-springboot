package com.speed.sky.paypalspringboot.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import com.speed.sky.paypalspringboot.config.PaypalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaypalService {

    @Autowired
    PaypalConfig paypalConfig;

    @Autowired
    AppPayment appPayment;

    public Payment createPayment(){
        Payment payment = appPayment.getPayment();
        APIContext apiContext = null;
        Payment createdPayment = null;
        try {
            apiContext = new APIContext(paypalConfig.getClientId(), paypalConfig.getClientSecret(), "sandbox");
            createdPayment = payment.create(apiContext);
            System.out.println("created payment");
            System.out.println(createdPayment.toString());
        } catch (PayPalRESTException e) {
            // Handle errors
            System.out.println("Exception in payaplrestException");
            System.out.println(e);

        } catch (Exception ex) {
            System.out.println("Exception in Exception");
            System.out.println(ex);
        }
        return createdPayment;
    }
}
