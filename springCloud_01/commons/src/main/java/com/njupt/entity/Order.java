package com.njupt.entity;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Integer id;
    private Double totalMount;
    private Integer userId;
    private String nickName;
    private String address;
    private List<Product> productList;
}
