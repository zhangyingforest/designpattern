package com.yc.designpattern.DMA5_建造者模式.DM2_complex;

public abstract class ColdDrink implements Item {
 
    @Override
    public Packing packing() {
       return new Bottle();
    }
 
    @Override
    public abstract float price();
}