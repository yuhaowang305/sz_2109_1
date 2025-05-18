package com.njupt.order.service;

import com.njupt.entity.Order;

public interface OrderService {


    public Order generateOrder(Integer productId, Integer userId);
}
