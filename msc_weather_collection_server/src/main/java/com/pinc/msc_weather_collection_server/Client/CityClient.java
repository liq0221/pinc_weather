package com.pinc.msc_weather_collection_server.Client;

import com.pinc.msc_weather_collection_server.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("msc-weather-city-server")
public interface CityClient {

    @GetMapping("/cities")
    List<City> cityList() throws Exception;
}
