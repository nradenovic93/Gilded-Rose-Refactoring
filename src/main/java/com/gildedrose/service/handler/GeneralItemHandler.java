package com.gildedrose.service.handler;

import com.gildedrose.service.domain.Item;

public class GeneralItemHandler extends ItemHandler {

    public GeneralItemHandler(Item item) {
        super(item);
    }

    @Override
    void changeSellByDate(Item item) {
        item.sellIn--;
    }

    @Override
    void changeQuality(Item item) {
        int decrease = 1;
        if (item.sellIn < 0) {
            decrease = 2;
        }
        item.quality = Integer.max(0, item.quality - decrease);
    }
}
