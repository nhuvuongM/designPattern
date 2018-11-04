package edu.insightr.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class InventoryTest {


    @Test
    public void updateItemsTest() {

        // Create an new item
        Item itemTest[] = new Item[]{  new Item("Elixir of the Mongoose", 5, 7) };
        Inventory inventoryTest = new Inventory(itemTest);


        //After "5 days", its quality should be at 0 and stay at 0
        boolean resp = false;

        for (int day = 0; day < 6 ; day++){
            inventoryTest.updateQuality();
        }

        int finalQuality = itemTest[0].getQuality();

        if (finalQuality == 0){
            resp = true;
        }

        Assert.assertTrue(resp);
    }

    @Test
    public void updateAgedBrieTest(){
        Item itemTest[] = new Item[]{  new Item("Aged Brie", 4, 1) };
        Inventory inventoryTest = new Inventory(itemTest);

        for (int day = 0; day < 5; day ++){
            inventoryTest.updateQuality();
        }

        boolean resp = false;

        int finalQuality = itemTest[0].getQuality();

        if(finalQuality == 6){
            resp = true;
        }

        Assert.assertTrue(resp);

    }

    @Test
    public void QualityUnder50Test(){
        Item itemTest[] = new Item[]{  new Item("Aged Brie", 4, 0) };
        Inventory inventoryTest = new Inventory(itemTest);

        for (int day = 0; day < 60 ; day ++){
            inventoryTest.updateQuality();
        }

        boolean resp = false;
        int finalQuality = itemTest[0].getQuality();

        if (finalQuality <= 50){
            resp = true;
        }

        Assert.assertTrue(resp);
    }
}