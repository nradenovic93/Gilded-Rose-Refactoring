package com.gildedrose.service.handler;

import com.gildedrose.service.domain.Item;

public class LegendaryItemHandler extends ItemHandler {

    public LegendaryItemHandler(Item item) {
        super(item);
    }

    @Override
    void changeSellByDate(Item item) {
        // Nothing changes
    }

    @Override
    void changeQuality(Item item) {
        // Quality should always be 80
        item.quality = 80;
    }
}