package com.gildedrose.service.handler;

import com.gildedrose.service.domain.Item;

public class EventItemHandler extends GeneralItemHandler {

    public EventItemHandler(Item item) {
        super(item);
    }

    @Override
    void changeQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality = Integer.min(50, item.quality + 3);
        } else if (item.sellIn <= 10) {
            item.quality = Integer.min(50, item.quality + 2);
        } else {
            item.quality = Integer.min(50, item.quality + 1);
        }
    }
}