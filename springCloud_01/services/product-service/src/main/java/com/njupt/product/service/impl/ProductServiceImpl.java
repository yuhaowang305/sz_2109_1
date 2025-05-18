package com.njupt.product.service.impl;


import com.njupt.entity.Product;
import com.njupt.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


    @Override
    public Product getProductById(Integer id) {
        //构建一个商品Product对象
        Product product = new Product();
        product.setId(id);
        product.setProductName("iphone14");
        product.setPrice(12000.0);
        product.setNum(1000);
        return product;
    }

}
