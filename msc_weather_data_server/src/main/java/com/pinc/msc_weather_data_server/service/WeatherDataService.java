package com.pinc.msc_weather_data_server.service;


import com.pinc.msc_weather_data_server.vo.WeatherResponse;


public interface WeatherDataService {

	WeatherResponse getDataByCityId(String cityId);


	WeatherResponse getDataByCityName(String cityName);
	
}
