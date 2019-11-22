package com.pinc.msc_weather_report_server.service;


import com.pinc.msc_weather_report_server.vo.Weather;

public interface WeatherReportService {


	Weather getDataByCityId(String cityId);
}
