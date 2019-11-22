package com.pinc.msc_weather_collection_server.config;

import com.pinc.msc_weather_collection_server.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {

  private static final int TIME=1800;

  @Bean
  public JobDetail weatherDataSyncJobDetail(){
    return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataJobSync!").storeDurably().build();
  }
  @Bean
  public Trigger weatherDataSyncTrigger(){
    SimpleScheduleBuilder scheduler = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(TIME).repeatForever();
    return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail()).withIdentity("weatherDataTriggerSync!").withSchedule(scheduler).build();
  }
}
