package com.scut.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "----------------PaymentFallbackService,   paymentInfo_OK,  服务宕机";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "----------------PaymentFallbackService,   paymentInfo_TimeOut,  服务宕机";
    }
}
