package com.scut.springcloud.controller;

import com.scut.springcloud.service.PaymentService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Reference
    private PaymentService paymentService;

    @RequestMapping("/info")
    public String info() {
        return paymentService.getPayment();
    }
}
