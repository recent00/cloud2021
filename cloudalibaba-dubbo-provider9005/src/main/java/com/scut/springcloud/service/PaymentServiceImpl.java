package com.scut.springcloud.service;

import org.apache.dubbo.config.annotation.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    public String getPayment() {
        return "Payment9005";
    }
}
