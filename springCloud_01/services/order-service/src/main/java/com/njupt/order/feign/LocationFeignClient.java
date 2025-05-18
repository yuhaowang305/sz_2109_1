package com.njupt.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "location-service",
url = "https://qryip.market.alicloudapi.com")
public interface LocationFeignClient {
    @GetMapping("/lundear/qryip")
    public String getLocation(@RequestParam("ip") String ip,
                              @RequestHeader("Authorization") String auth);

}
