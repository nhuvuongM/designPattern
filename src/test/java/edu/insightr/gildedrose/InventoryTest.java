package edu.insightr.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {

    ItemFactory itemFactory = new ItemFactory();

    @Test
    public void updateItemsTest() {

        // Create an new item
        Item itemTest[] = new Item[]{  itemFactory.createElixir() };
        Inventory inventoryTest = new Inventory(itemTest);

        //After "5 days", its quality should be at 0 and stay at 0
        for (int day = 0; day < 6 ; day++){
            inventoryTest.updateQuality();
        }

        Assert.assertEquals(0, itemTest[0].getQuality());
    }

    @Test
    public void updateAgedBrieTest(){
        Item itemTest[] = new Item[]{  itemFactory.createAgedBrie()};
        Inventory inventoryTest = new Inventory(itemTest);

        for (int day = 0; day < 5; day ++){
            inventoryTest.updateQuality();
        }

        Assert.assertEquals(5, itemTest[0].getQuality());

    }

    @Test
    public void QualityUnder50Test(){
        Item itemTest[] = new Item[]{ itemFactory.createAgedBrie() };
        Inventory inventoryTest = new Inventory(itemTest);

        for (int day = 0; day < 60 ; day ++){
            inventoryTest.updateQuality();
        }

        Assert.assertEquals(50, itemTest[0].getQuality());
    }
}