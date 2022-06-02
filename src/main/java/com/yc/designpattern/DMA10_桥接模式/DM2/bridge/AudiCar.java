package com.yc.designpattern.DMA10_桥接模式.DM2.bridge;

/**
 * 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法
 * 奥迪汽车实现类
 */
public class AudiCar extends Car {


    public AudiCar(Color color){
        super.setColor(color);
    }

    @Override
    public void run() {
        String c = color.useColor();
        System.out.println("生产"+c+"奥迪汽车");
    }
}
