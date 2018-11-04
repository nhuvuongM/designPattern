package edu.insightr.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }


    @Override
    public void updateQuality() {
        if( getQuality() < 50){

            setSellIn(getSellIn() -1);
            setQuality(getQuality() +1);
        }

        else{
            setSellIn((getSellIn() -1));
        }
    }
}
