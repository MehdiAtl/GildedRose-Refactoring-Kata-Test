package com.gildedrose;

import com.gildedrose.updater.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater itemUpdater = updaterFor(item);
            itemUpdater.update(item);
        }
    }

    private ItemUpdater updaterFor(Item item) {
        if ("Aged Brie".equals(item.name)) {
            return new AgedBrieUpdater();
        }
        if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
            return new BackstagePassUpdater();
        }
        if ("Conjured Mana Cake".equals(item.name)) {
            return new ConjuredManaCakeUpdater();
        }
        if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
            return new SulfurasUpdater();
        }
        return new DefaultItemUpdater();
    }
}
