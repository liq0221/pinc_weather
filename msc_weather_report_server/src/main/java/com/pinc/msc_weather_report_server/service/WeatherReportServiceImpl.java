package com.pinc.msc_weather_report_server.service;

import java.util.ArrayList;
import java.util.List;

import com.pinc.msc_weather_report_server.client.DataClient;
import com.pinc.msc_weather_report_server.vo.Weather;
import com.pinc.msc_weather_report_server.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private DataClient dataClient;

	@Override
	public Weather getDataByCityId(String cityId) {
		WeatherResponse resp = dataClient.getDataByCityId(cityId);
		return resp.getData();
	}


}
