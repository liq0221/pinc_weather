package com.pinc.msc_weather_city_server.service;

import com.pinc.msc_weather_city_server.vo.City;

import java.util.List;



public interface CityDataService {

	List<City> listCity() throws Exception;
}
