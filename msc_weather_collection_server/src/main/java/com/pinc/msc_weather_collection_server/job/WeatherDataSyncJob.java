package com.pinc.msc_weather_collection_server.job;


import com.pinc.msc_weather_collection_server.Client.CityClient;
import com.pinc.msc_weather_collection_server.service.WeatherCollectionService;
import com.pinc.msc_weather_collection_server.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSyncJob extends QuartzJobBean {

  protected static final Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);


  @Autowired
  private WeatherCollectionService weatherCollectionService;
  @Autowired
  private CityClient cityClient;
  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    logger.info("syn data start");
    List<City> cityList = null;
    try {
      cityList=cityClient.cityList();
    } catch (Exception e) {
      logger.error("error",e);
    }
    for (City city : cityList) {
      logger.info("cityId:"+city.getCityId());
      weatherCollectionService.syncDataByCityId(city.getCityId());
    }
   logger.info("syn data end");
  }
}
