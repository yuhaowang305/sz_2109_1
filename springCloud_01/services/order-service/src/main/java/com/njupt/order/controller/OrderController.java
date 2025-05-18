package com.njupt.order.controller;

import com.njupt.entity.Order;
import com.njupt.order.service.OrderService;
import com.njupt.order.properties.OrderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderProperties orderProperties;

    @GetMapping("/createOrder")
    public Order createOrder(@RequestParam("productId") Integer productId,
                             @RequestParam("userId") Integer userId) {
        return orderService.generateOrder(productId, userId);
    }
    @GetMapping("/getNacosConfig")
    public String getNacosConfig(){
        return orderProperties.toString();
    }
}
