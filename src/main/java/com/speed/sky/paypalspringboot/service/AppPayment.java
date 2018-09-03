package com.speed.sky.paypalspringboot.service;

import com.paypal.api.payments.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;


@Service
public class AppPayment {
    public Payment getPayment(){
        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal("1.00");

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(transaction);

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setEmail("sam@gmail.com");

        Address address = new Address();
        address.setLine1("100 bell st");
        address.setCity("Chicago");
        address.setState("Illinoise");
        address.setPostalCode("60020");
        address.setPhone("8479879878");
        address.setCountryCode("US");
        payerInfo.setBillingAddress(address);


        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");
        payer.setPayerInfo(payerInfo);


        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("https://facebook.com");
        redirectUrls.setReturnUrl("https://google.com");

        Payment payment = new Payment();
        payment.setIntent("sale");
        payment.setPayer(payer);
        payment.setTransactions(transactions);
        payment.setRedirectUrls(redirectUrls);

        return payment;
    }
}
