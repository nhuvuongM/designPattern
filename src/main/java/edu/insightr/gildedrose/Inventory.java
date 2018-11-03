package edu.insightr.gildedrose;

public class Inventory {

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
                new Item("+5 Dexterity Vest", 10, 20),
                new Item("Aged Brie", 2, 0),
                new Item("Elixir of the Mongoose", 5, 7),
                new Item("Sulfuras, Hand of Ragnaros", 0, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Conjured Mana Cake", 3, 6)
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

            if(items[i].getName() != "Aged Brie"
                    && items[i].getName() != "Sulfuras, Hand of Ragnaros"
                    && items[i].getName() != "Backstage passes to a TAFKAL80ETC concert"
                    && items[i].getName() != "Conjured Mana Cake"){

                updateItems(i);
            }

            if(items[i].getName().equals("Aged Brie")){
                updateAgedBrie(i);
            }

            if(items[i].getName().equals("Conjured Mana Cake")){
                updateConjured(i);
            }

            if(items[i].getName().equals("Backstage passes to a TAFKAL80ETC concert")){
                updateBackstage(i);
            }

            if(items[i].getName().equals("Sulfuras, Hand of Ragnaros")){
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