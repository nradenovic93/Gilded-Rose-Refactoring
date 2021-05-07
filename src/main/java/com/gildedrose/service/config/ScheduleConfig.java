package com.gildedrose.service.config;

import com.gildedrose.service.GildedRose;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Scheduled(cron = "0 0 0 ? * *")
    public void scheduleFixedDelayTask() {
        GildedRose.updateQuality();
    }
}