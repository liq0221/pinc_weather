package com.pinc.msc_weather_city_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscWeatherCityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscWeatherCityServerApplication.class, args);
    }

}
