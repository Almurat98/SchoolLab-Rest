package com.cydeo.client;

import lombok.Getter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "http://api.weatherstack.com",name = "WEATHER-CLIENT")
public interface WeatherClient {

    @GetMapping("/current")
    Object getCurrentWeather(@RequestParam(value = "access_key")String accessKey,
                             @RequestParam(value = "query") String city);
}
