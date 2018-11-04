package edu.insightr.gildedrose;

public class DexterityVest extends Item {

    public DexterityVest(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
    
        if(getSellIn() >= 0  && getQuality() > 0){
            setSellIn(getSellIn() - 1);
            setQuality((getQuality() - 1));
        }

        if(getSellIn() < 0){
            if(getQuality() > 2){
                setSellIn(getSellIn() - 1);
                setQuality(getQuality() -2);
            } else {
                setSellIn(getSellIn() -1);
                setQuality(0);
            }
        }
    }
}
