package com.scut.springcloud.service;

import com.scut.springcloud.domain.Order;

public interface  OrderService {
    /**
     * 创建订单
     */
    void create(Order order);

}
