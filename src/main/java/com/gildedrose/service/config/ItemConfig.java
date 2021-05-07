package com.gildedrose.service.config;

import com.gildedrose.service.GildedRose;
import com.gildedrose.service.util.ItemParser;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ItemConfig {

    private static String resourceName = "items.csv";

    @PostConstruct
    public void init() {
        GildedRose.items = ItemParser.parseFromFile(resourceName);
    }
}