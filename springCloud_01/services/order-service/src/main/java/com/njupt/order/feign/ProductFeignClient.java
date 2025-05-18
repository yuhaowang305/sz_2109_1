package com.njupt.order.feign;


import com.njupt.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductFeignClient {
    //根据商品id查询商品信息，远程调用
    //可以发送http请求，调用远程服务器的接口，获取数据
    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable("productId") Integer id);
}
