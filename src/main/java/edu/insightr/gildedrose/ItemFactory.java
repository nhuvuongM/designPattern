package edu.insightr.gildedrose;

public class ItemFactory {

    public DexterityVest createDexterityVest (){
        return new DexterityVest("+5 Dexterity Vest", 10, 20);
    }

    public AgedBrie createAgedBrie(){
    return new AgedBrie("Aged Brie", 2, 0);
    }

    public Elixir createElixir(){
        return new Elixir("Elixir of the Mongoose", 5, 7);
    }

    public Sulfuras createSulfuras(){
        return new Sulfuras("Sulfuras, Hand of Ragnaros", 0, 80);
    }

    public Backstage createBackstage(){
        return new Backstage("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    }

    public Conjured createConjured(){
        return new Conjured("Conjured Mana Cake", 3, 6);
    }
}
