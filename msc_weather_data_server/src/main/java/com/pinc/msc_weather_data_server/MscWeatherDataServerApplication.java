package com.pinc.msc_weather_data_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MscWeatherDataServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscWeatherDataServerApplication.class, args);
    }

}
