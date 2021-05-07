package com.gildedrose.service;

import com.gildedrose.service.domain.Item;
import com.gildedrose.service.handler.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GildedRose {

    public static Item[] items;

    private static List<String> agedItems = new ArrayList<>(List.of("Aged Brie"));
    private static List<String> eventItems = new ArrayList<>(List.of("Backstage passes to a TAFKAL80ETC concert"));
    private static List<String> legendaryItems = new ArrayList<>(List.of("Sulfuras, Hand of Ragnaros"));
    private static List<String> conjuredItems = new ArrayList<>(List.of("Conjured Mana Cake"));

    public static void updateQuality() {
        Arrays.stream(items)
                .forEach(GildedRose::updateItem);
    }

    private static void updateItem(Item item) {
        if (isAged(item)) {
            new AgedItemHandler(item).handle();
        } else if (isEvent(item)) {
            new EventItemHandler(item).handle();
        } else if (isLegendary(item)) {
            new LegendaryItemHandler(item).handle();
        } else if (isConjured(item)) {
            new ConjuredItemHandler(item).handle();
        } else {
            new GeneralItemHandler(item).handle();
        }
    }

    private static boolean isAged(Item item) {
        return agedItems.stream()
                .anyMatch(name -> name.equals(item.name));
    }

    private static boolean isEvent(Item item) {
        return eventItems.stream()
                .anyMatch(name -> name.equals(item.name));
    }

    private static boolean isLegendary(Item item) {
        return legendaryItems.stream()
                .anyMatch(name -> name.equals(item.name));
    }

    private static boolean isConjured(Item item) {
        return conjuredItems.stream()
                .anyMatch(name -> name.equals(item.name));
    }
}