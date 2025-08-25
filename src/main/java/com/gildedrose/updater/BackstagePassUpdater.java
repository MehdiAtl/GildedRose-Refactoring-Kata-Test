package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.helper.ItemHelper;

public class BackstagePassUpdater implements ItemUpdater{
    @Override
    public void update(Item item) {
        ItemHelper.increaseQuality(item, 1);

        if (item.sellIn < 11) {
            ItemHelper.increaseQuality(item, 1);
        }

        if (item.sellIn < 6) {
            ItemHelper.increaseQuality(item, 1);
        }

        ItemHelper.decreaseSellIn(item);

        if(item.sellIn < 0 ){
            item.quality = 0;
        }
    }
}
