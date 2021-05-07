package com.gildedrose.service.handler;

import com.gildedrose.service.domain.Item;

public class AgedItemHandler extends GeneralItemHandler {

    public AgedItemHandler(Item item) {
        super(item);
    }

    @Override
    void changeQuality(Item item) {
        int increase = 1;
        if (item.sellIn < 0) {
            increase = 2;
        }
        item.quality = Integer.min(50, item.quality + increase);
    }
}
