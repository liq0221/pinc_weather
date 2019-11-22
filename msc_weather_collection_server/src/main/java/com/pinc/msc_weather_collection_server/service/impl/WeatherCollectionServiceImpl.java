package com.pinc.msc_weather_collection_server.service.impl;

import com.pinc.msc_weather_collection_server.service.WeatherCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Service
public class WeatherCollectionServiceImpl implements WeatherCollectionService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private static long TIME_OUT=1800L;

    private String WEATHER_URI="http://wthrcdn.etouch.cn/weather_mini?";
    @Override
    public void syncDataByCityId(String cityId) {
        String uri = WEATHER_URI+"citykey="+cityId;
        this.saveData(uri);
    }

    private void saveData(String uri) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        String body =null;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if(responseEntity.getStatusCodeValue()==200){
            body = responseEntity.getBody();
        }
        ops.set(uri,body,TIME_OUT,TimeUnit.SECONDS);
    }

}
