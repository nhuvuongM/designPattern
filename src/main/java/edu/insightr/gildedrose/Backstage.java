package edu.insightr.gildedrose;

public class Backstage extends Item {

    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (getSellIn() < 0){
            setQuality(getQuality() - getQuality());
            setSellIn((getSellIn() -1));
        }

        else{
            if(getSellIn() >= 11 && getQuality() <= 50){
                setSellIn(getSellIn() -1);
                setQuality(getQuality()+1);
            }

            else{
                if(getSellIn() < 11 && getQuality() <= 50){
                    setSellIn(getSellIn() -1);
                    setQuality(getQuality()+2);
                }
                if(getSellIn() < 5 && getQuality() <= 50) {
                    setSellIn(getSellIn() - 1);
                    setQuality(getQuality() + 3);
                }
            }
        }
    }
}
