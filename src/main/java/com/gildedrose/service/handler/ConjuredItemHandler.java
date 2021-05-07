package com.gildedrose.service.handler;

import com.gildedrose.service.domain.Item;

public class ConjuredItemHandler extends GeneralItemHandler {

    public ConjuredItemHandler(Item item) {
        super(item);
    }

    @Override
    void changeQuality(Item item) {
        // Quality degrades twice as fast as general items
        super.changeQuality(item);
        super.changeQuality(item);
    }
}
