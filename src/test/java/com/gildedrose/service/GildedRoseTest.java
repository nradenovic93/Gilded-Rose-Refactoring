package com.gildedrose.service;

import com.gildedrose.service.domain.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void testRegularItems() {
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Elixir of the Mongoose", 0, 7),
                new Item("Dragonborn's sweetroll", 3, 0)
        };
        GildedRose.items = items;
        GildedRose.updateQuality();

        // Goods are constantly degrading in quality as they approach their sell by date
        assertEquals(9, items[0].sellIn);
        assertEquals(19, items[0].quality);

        // Once the sell by date has passed, Quality degrades twice as fast
        assertEquals(-1, items[1].sellIn);
        assertEquals(5, items[1].quality);

        // The Quality of an item is never negative
        assertEquals(2, items[2].sellIn);
        assertEquals(0, items[2].quality);
    }

    @Test
    void testAgedItems() {
        Item[] items = new Item[]{
                new Item("Aged Brie", 2, 0),
                new Item("Aged Brie", 0, 30),
                new Item("Aged Brie", 0, 49)
        };
        GildedRose.items = items;
        GildedRose.updateQuality();

        // "Aged Brie" actually increases in Quality the older it gets
        assertEquals(1, items[0].sellIn);
        assertEquals(1, items[0].quality);

        // Once the sell by date has passed, Quality increases twice as fast
        assertEquals(-1, items[1].sellIn);
        assertEquals(32, items[1].quality);

        // The Quality of an item is never more than 50
        assertEquals(-1, items[2].sellIn);
        assertEquals(50, items[2].quality);
    }

    @Test
    void testConjuredItems() {
        Item[] items = new Item[]{
                new Item("Conjured Mana Cake", 3, 6),
                new Item("Conjured Mana Cake", 0, 6),
                new Item("Conjured Mana Cake", 0, 0)
        };
        GildedRose.items = items;
        GildedRose.updateQuality();

        // "Conjured" items degrade in Quality twice as fast as normal items
        assertEquals(2, items[0].sellIn);
        assertEquals(4, items[0].quality);

        // Once the sell by date has passed, Quality degrades twice as fast
        assertEquals(-1, items[1].sellIn);
        assertEquals(2, items[1].quality);

        // The Quality of an item is never negative
        assertEquals(-1, items[2].sellIn);
        assertEquals(0, items[2].quality);
    }

    @Test
    void testEventItems() {
        Item[] items = new Item[]{
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 11, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 6, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49)
        };
        GildedRose.items = items;
        GildedRose.updateQuality();

        // "Backstage passes" increases in Quality as its SellIn value approaches
        assertEquals(14, items[0].sellIn);
        assertEquals(21, items[0].quality);

        // Quality increases by 2 when there are 10 days or less
        assertEquals(10, items[1].sellIn);
        assertEquals(22, items[1].quality);

        // Quality increases by 3 when there are 5 days or less
        assertEquals(5, items[2].sellIn);
        assertEquals(23, items[2].quality);

        // The Quality of an item is never more than 50
        assertEquals(5, items[3].sellIn);
        assertEquals(50, items[3].quality);

        // Quality drops to 0 after the concert
        assertEquals(-1, items[4].sellIn);
        assertEquals(0, items[4].quality);
    }

    @Test
    void testLegendaryItems() {
        Item[] items = new Item[]{
                new Item("Sulfuras, Hand of Ragnaros", 5, 80),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
        };
        GildedRose.items = items;
        GildedRose.updateQuality();

        // "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
        assertEquals(5, items[0].sellIn);
        assertEquals(80, items[0].quality);

        assertEquals(0, items[1].sellIn);
        assertEquals(80, items[1].quality);
    }
}