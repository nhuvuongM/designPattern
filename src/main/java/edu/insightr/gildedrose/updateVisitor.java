package edu.insightr.gildedrose;

public class UpdateVisitor implements IVisitor {

    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";


    @Override
    public static void visit(Item item) {

        if(item.getName() != AGED_BRIE
                && item.getName() != SULFURAS_HAND_OF_RAGNAROS
                && item.getName() != BACKSTAGE_PASSES_TO_CONCERT
                && item.getName() != CONJURED_MANA_CAKE){

            updateItems(item);
        }

        if(item.getName().equals(AGED_BRIE)){
            updateAgedBrie(item);
        }

        if(item.getName().equals(CONJURED_MANA_CAKE)){
            updateConjured(item);
        }

        if(item.getName().equals(BACKSTAGE_PASSES_TO_CONCERT)){
            updateBackstage(item);
        }

        if(item.getName().equals(SULFURAS_HAND_OF_RAGNAROS)){
            item.setSellIn(item.getSellIn() -1);
        }

    }

    public void updateItems(Item item){

        if(item.getSellIn() >= 0
                && item.getQuality() > 0){

            item.setSellIn(item.getSellIn() - 1);
            item.setQuality((item.getQuality() - 1));
        }

        if(item.getSellIn() < 0){
            if(item.getQuality() > 2){
                item.setSellIn(item.getSellIn() - 1);
                item.setQuality(item.getQuality() -2);
            }

            else{
                item.setSellIn(item.getSellIn() -1);
                item.setQuality(item.getQuality() - item.getQuality());
            }
        }

    }

    public void updateAgedBrie(Item item){

        if( item.getQuality() < 50){

            item.setSellIn(item.getSellIn() -1);
            item.setQuality(item.getQuality() +1);
        }

        else{
            item.setSellIn((item.getSellIn() -1));
        }
    }

    public void updateConjured(Item item){

        item.setSellIn(item.getSellIn() -1);
        item.setQuality(item.getQuality() -2);

    }

    public void updateBackstage(Item item){

        if (item.getSellIn() < 0){
            item.setQuality(item.getQuality() - item.getQuality());
            item.setSellIn((item.getSellIn() -1));
        }

        else{
            if(item.getSellIn() >= 11 && item.getQuality() <= 50){
                item.setSellIn(item.getSellIn() -1);
                item.setQuality(item.getQuality()+1);
            }

            else{
                if(item.getSellIn() < 11 && item.getQuality() <= 50){
                    item.setSellIn(item.getSellIn() -1);
                    item.setQuality(item.getQuality()+2);
                }
                if(item.getSellIn() < 5 && item.getQuality() <= 50) {
                    item.setSellIn(item.getSellIn() - 1);
                    item.setQuality(item.getQuality() + 3);
                }
            }
        }

    }

    public static void main (String[] args){

        Item item;
        item = new Item("Elixir of the Mongoose", 5,7);

        UpdateVisitor.visit(item);

    }

}

