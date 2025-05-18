package com.njupt.product.controller;


import com.njupt.entity.Product;
import com.njupt.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable("productId") Integer id){
        System.out.println("hello");
        return productService.getProductById(id);
    }

}
