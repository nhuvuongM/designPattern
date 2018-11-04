package edu.insightr.gildedrose;

public class Inventory {

    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    private Item[] items;

    public Item[] getItems(){
        return items;
    }


    public Inventory (Item[] items) {
        super();
        this.items = items;
    }

    public Inventory() {
        super();
        items = new Item[]{
                new Item(DEXTERITY_VEST, 10, 20),
                new Item(AGED_BRIE, 2, 0),
                new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7),
                new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80),
                new Item(BACKSTAGE_PASSES_TO_CONCERT, 15, 20),
                new Item(CONJURED_MANA_CAKE, 3, 6)
        };
    }

    public void printInventory() {
        System.out.println("***************");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("***************");
        System.out.println("\n");
    }

    public void updateItems(int i){

        if(items[i].getSellIn() >= 0
        && items[i].getQuality() > 0){

            items[i].setSellIn(items[i].getSellIn() - 1);
            items[i].setQuality((items[i].getQuality() - 1));
        }

        if(items[i].getSellIn() < 0){
            if(items[i].getQuality() > 2){
                items[i].setSellIn(items[i].getSellIn() - 1);
                items[i].setQuality(items[i].getQuality() -2);
            }

            else{
                items[i].setSellIn(items[i].getSellIn() -1);
                items[i].setQuality(items[i].getQuality() - items[i].getQuality());
            }
        }

    }

    public void updateAgedBrie(int i){

        if( items[i].getQuality() < 50){

            items[i].setSellIn(items[i].getSellIn() -1);
            items[i].setQuality(items[i].getQuality() +1);
        }

        else{
            items[i].setSellIn((items[i].getSellIn() -1));
        }
    }

    public void updateConjured(int i){

        items[i].setSellIn(items[i].getSellIn() -1);
        items[i].setQuality(items[i].getQuality() -2);

    }

    public void updateBackstage(int i){

        if (items[i].getSellIn() < 0){
            items[i].setQuality(items[i].getQuality() - items[i].getQuality());
            items[i].setSellIn((items[i].getSellIn() -1));
        }

        else{
            if(items[i].getSellIn() >= 11 && items[i].getQuality() <= 50){
                items[i].setSellIn(items[i].getSellIn() -1);
                items[i].setQuality(items[i].getQuality()+1);
            }

            else{
                if(items[i].getSellIn() < 11 && items[i].getQuality() <= 50){
                    items[i].setSellIn(items[i].getSellIn() -1);
                    items[i].setQuality(items[i].getQuality()+2);
                }
                if(items[i].getSellIn() < 5 && items[i].getQuality() <= 50) {
                    items[i].setSellIn(items[i].getSellIn() - 1);
                    items[i].setQuality(items[i].getQuality() + 3);
                }
            }
        }

    }

    public void updateQuality(){

        for (int i = 0; i < items.length ; i ++){

            if(items[i].getName() != AGED_BRIE
                    && items[i].getName() != SULFURAS_HAND_OF_RAGNAROS
                    && items[i].getName() != BACKSTAGE_PASSES_TO_CONCERT
                    && items[i].getName() != CONJURED_MANA_CAKE){

                updateItems(i);
            }

            if(items[i].getName().equals(AGED_BRIE)){
                updateAgedBrie(i);
            }

            if(items[i].getName().equals(CONJURED_MANA_CAKE)){
                updateConjured(i);
            }

            if(items[i].getName().equals(BACKSTAGE_PASSES_TO_CONCERT)){
                updateBackstage(i);
            }

            if(items[i].getName().equals(SULFURAS_HAND_OF_RAGNAROS)){
                items[i].setSellIn(items[i].getSellIn() -1);
            }
        }
    }

    public static void main(String[] args){
        Inventory inventory = new Inventory();
        for(int i = 0; i < 20 ; i ++){
            inventory.updateQuality();
            inventory.printInventory();
        }
    }

}