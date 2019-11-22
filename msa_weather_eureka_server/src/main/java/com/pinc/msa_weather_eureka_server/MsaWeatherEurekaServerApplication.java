package com.pinc.msa_weather_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsaWeatherEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsaWeatherEurekaServerApplication.class, args);
    }

}
