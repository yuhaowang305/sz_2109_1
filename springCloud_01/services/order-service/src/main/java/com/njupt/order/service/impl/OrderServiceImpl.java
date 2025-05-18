package com.njupt.order.service.impl;

import com.njupt.entity.Order;
import com.njupt.entity.Product;
import com.njupt.order.feign.ProductFeignClient;
import com.njupt.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private LoadBalancerClient loaderBalancerClient;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Override
    public Order generateOrder(Integer productId, Integer userId) {
        //Product product = getProductByLoadBalanceAnnotation(productId);
        Product product= productFeignClient.getProductById(productId);
        Order order = new Order();
        order.setId(1001);
        order.setUserId(userId);
        order.setTotalMount(product.getPrice()*product.getNum());
        order.setNickName("张三");
        order.setAddress("北京");
        order.setProductList(Arrays.asList(product));
        return order;
    }
    public Product getProductById(Integer id) {
        String serviceName = "product-service";
        List<ServiceInstance> instances=
                discoveryClient.getInstances(serviceName);
        String ip=instances.get(0).getHost();
        String port=instances.get(0).getPort()+"";
        String url="http://"+ip+":"+port+"/product/"+id;
        //使用RestTemplate调用
        Product product=restTemplate.getForObject(url,Product.class);
        return product;
    }


    public Product getProductByLoadBanancer(Integer productId){
        String serviceName="product-service";
        ServiceInstance instance=loaderBalancerClient.choose(serviceName);
        String url="http://"+instance.getHost()+":"+instance.getPort()+"/product/"+productId;
        log.info("url:"+url);
        Product product=restTemplate.getForObject(url,Product.class);
        return product;

    }
    public Product getProductByLoadBalanceAnnotation(Integer productId){
        String serviceName="product-service";
        String url="http://"+serviceName+"/product/"+productId;
        log.info("url:"+url);
        Product product=restTemplate.getForObject(url,Product.class);
        return product;
    }
}
