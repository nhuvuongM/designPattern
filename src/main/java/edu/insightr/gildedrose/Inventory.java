package edu.insightr.gildedrose;

public class Inventory {


    private Item[] items;
    private ItemFactory itemFactory;

    public Item[] getItems(){
        return items;
    }


    public Inventory (Item[] items) {
        super();

        this.items = items;
    }

    public Inventory() {
        super();

        itemFactory = new ItemFactory();

        items = new Item[]{
                itemFactory.createDexterityVest(),
                itemFactory.createAgedBrie(),
                itemFactory.createElixir(),
                itemFactory.createSulfuras(),
                itemFactory.createBackstage(),
                itemFactory.createConjured()
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

    public static void main(String[] args){

        Inventory inventory = new Inventory();

        for(int i = 1; i < 5; i++ ) {
            System.out.println("*** DAY "+i+" ******");
            for (Item item : inventory.items) {
                item.updateQuality();
            }
            inventory.printInventory();
        }
    }

}