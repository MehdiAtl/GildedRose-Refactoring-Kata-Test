package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if(!isSulfuras(item)) {

                if (!isAgedBrie(item) && !isBackstagePass(item)) {
                    if (item.quality > 0) {
                        if(isConjuredManaCake(item)) {
                            item.quality = item.quality - 2;
                        }else{
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                        manageBackStageQuality(item);
                    }
                }
                manageExpiration(item);
            }

        }
    }

    private void manageBackStageQuality(Item item) {
        if (isBackstagePass(item)) {

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private void manageExpiration(Item item) {
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (!isAgedBrie(item)) {
                if (!isBackstagePass(item)) {
                    if (item.quality > 0) {
                        if(isConjuredManaCake(item)) {
                            item.quality = item.quality - 2;
                        }else {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = 0;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isConjuredManaCake(Item item) {
        return item.name.equals("Conjured Mana Cake");
    }

}
