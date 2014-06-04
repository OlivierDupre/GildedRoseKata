package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test public void 
    updateQualityOfaCommonItemShouldDecreaseQuality() {
    	Item[] items = new Item[] { new Item("Wood Sword", 3, 5) };
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals(4, app.items[0].quality);
    }

    @Test public void
    updateQualityOfAgedBrieShouldIncreaseQuality() {
    	Item[] items = new Item[] { new Item("Aged Brie", 3, 5) };
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertEquals(6, app.items[0].quality);
    }

    @Test public void
    updateQualityOfBackstageShouldIncreaseQuality() {
    	int quality = 5;
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, quality) };
    	GildedRose app = new GildedRose(items);
    	app.updateQuality();
    	assertTrue(app.items[0].quality > quality);
    }
    
    @Test public void
    updateQualityOfCommonItemNegativeSellInShouldDecrementQualityTwice() {
    	Item[] items = new Item[] { new Item("Wood Sword", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    	
    }
    
    @Test public void
    updateQualityOfBackstageItemNegativeSellInShouldResetQuality() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    	
    }
    
    @Test public void
    updateQualityOfAgedBrieItemNegativeSellInShouldIncreaseQualityTwice() {
    	Item[] items = new Item[] { new Item("Aged Brie", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(7, app.items[0].quality);
    	
    }
    
    @Test public void
    updateQualityOfAgedBrieItemNegativeSellInShouldDoNothing() {
    	Item[] items = new Item[] { new Item("Aged Brie", -1, 51) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(51, app.items[0].quality);
    	
    }
    
    @Test public void
    updateQualityOfCommonItemNegativeSellInShouldDoNothing() {
    	Item[] items = new Item[] { new Item("Wood Sword", -1, -1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].quality);
    	
    }
    
    @Test public void
    updateQualityOfSulfurasItemNegativeSellInShouldDecreaseTwice() {
    	Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(5, app.items[0].quality);
    	
    }
    
    @Test public void
    updateQualityOfBackstageItemSellInSuperiorTo11AndSuperiorQualityTo50ShouldIncreaseQuality() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    	
    }
    
    @Test public void
    updateQualityOfBackstageItemSellInInferiorOf5AndSuperiorQualityTo50ShouldIncreaseQuality() {
    	Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    	
    }
}
