package com.gildedrose.helper;

import com.gildedrose.Item;

public class ItemHelper {

    public static void increaseQuality(Item item, int incQuality) {
        item.quality = Math.min(50, item.quality + incQuality);
    }
    public static void decreaseQuality(Item item, int decQuality) {
        item.quality = Math.max(0, item.quality - decQuality);
    }
    public static void decreaseSellIn(Item item) {
        item.sellIn -= 1;
    }
}
