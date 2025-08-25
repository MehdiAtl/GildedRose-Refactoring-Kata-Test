package com.gildedrose.updater;

import com.gildedrose.Item;
import com.gildedrose.helper.ItemHelper;

public class DefaultItemUpdater implements ItemUpdater{

    @Override
    public void update(Item item) {
        ItemHelper.decreaseSellIn(item);
        if(item.sellIn < 0) ItemHelper.decreaseQuality(item, 1);
        ItemHelper.decreaseQuality(item, 1);
    }
}
