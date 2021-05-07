package com.gildedrose.service.handler;

import com.gildedrose.service.domain.Item;

public abstract class ItemHandler {

    private Item item;

    ItemHandler(Item item) {
        this.item = item;
    }

    public void handle() {
        changeSellByDate(item);
        changeQuality(item);
    }

    abstract void changeSellByDate(Item item);

    abstract void changeQuality(Item item);
}
