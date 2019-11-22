package com.pinc.msc_weather_report_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.pinc.msc_weather_report_server.client"})
public class MscWeatherReportServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscWeatherReportServerApplication.class, args);
    }

}
