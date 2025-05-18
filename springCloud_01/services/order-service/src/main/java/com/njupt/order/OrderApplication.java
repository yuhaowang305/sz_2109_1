package com.njupt.order;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    //监听配置文件的变化
    @Bean
    ApplicationRunner getApplicationRunner(NacosConfigManager nacosConfigManager){
        return args -> {
            nacosConfigManager.getConfigService().addListener("order-server.properties", "DEFAULT_GROUP",
                    new Listener() {
                        @Override
                        public Executor getExecutor() {
                            return Executors.newFixedThreadPool(1);
                        }

                        @Override
                        public void receiveConfigInfo(String s) {
                            System.out.println("order-service配置文件发生变化");
                        }
                    });
        };
    }
}
