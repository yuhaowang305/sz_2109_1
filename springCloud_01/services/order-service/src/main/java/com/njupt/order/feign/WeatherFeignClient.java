package com.njupt.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather-service",url = "http://aliv18.data.moji.com")
public interface WeatherFeignClient {
    @PostMapping("/whapi/json/alicityweather/condition")
    public String aliCityWeather(@RequestParam("cityId") String cityId,
                                 @RequestParam("token") String token,
                                 @RequestHeader("Authorization") String auth);
}
