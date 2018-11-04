package edu.insightr.gildedrose;

public class Conjured extends Item {

    public Conjured(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if(getQuality() > 2){
            setSellIn(getSellIn() -1);
            setQuality(getQuality() -2);
        }else{
            setSellIn(getSellIn() -1);
            setQuality(getQuality() - getQuality());
        }

    }
}
