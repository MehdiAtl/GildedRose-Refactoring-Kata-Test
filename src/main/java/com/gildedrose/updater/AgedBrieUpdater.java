package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.helper.ItemHelper;

public class AgedBrieUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        ItemHelper.decreaseSellIn(item);
        if(item.sellIn < 0 ) ItemHelper.increaseQuality(item, 1);
        ItemHelper.increaseQuality(item, 1);
    }
}
