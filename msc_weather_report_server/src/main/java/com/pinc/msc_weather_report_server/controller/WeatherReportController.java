package com.pinc.msc_weather_report_server.controller;

import java.util.ArrayList;
import java.util.List;

import com.pinc.msc_weather_report_server.client.DataClient;
import com.pinc.msc_weather_report_server.service.WeatherReportService;
import com.pinc.msc_weather_report_server.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/report")
public class WeatherReportController {
	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);  

	@Autowired
	private DataClient dataClient;
	@Autowired
	private WeatherReportService weatherReportService;

	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// 获取城市ID列表
		List<City> cityList = null;

		try {

			cityList =dataClient.cityList();


		} catch (Exception e) {
			logger.error("Exception!", e);
		}
		
		model.addAttribute("title", "频传天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
