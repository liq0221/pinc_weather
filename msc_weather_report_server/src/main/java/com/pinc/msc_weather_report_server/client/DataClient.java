package com.pinc.msc_weather_report_server.client;

import com.pinc.msc_weather_report_server.vo.City;
import com.pinc.msc_weather_report_server.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("msc-weather-zuul-gateway")
public interface DataClient {
    @GetMapping("/city/cities")
    List<City> cityList();

    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId")String cityId);
}
