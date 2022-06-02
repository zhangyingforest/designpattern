package com.yc.designpattern.DMA10_桥接模式.DM2.bridge;

/**
 * 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用( Color 这就是要扩展的功能)
 * 汽车抽象类
 */
public abstract class Car {

    /**
     * 持有颜色对象引用，通过组合的方式来桥接颜色，使品牌和颜色两个维度可以相对独立地变化
     */
    protected Color color;  //组合关系

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * 生产汽车，比如：生产A1品牌B1颜色汽车、生产A2品牌B1颜色汽车，等等
     */
    abstract public void run();

}
