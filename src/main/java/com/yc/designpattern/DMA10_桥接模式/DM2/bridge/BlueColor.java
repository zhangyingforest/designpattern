package com.yc.designpattern.DMA10_桥接模式.DM2.bridge;

/**
 * 具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现
 */
public class BlueColor implements Color {

    @Override
    public String useColor() {
        return "蓝色";
    }

}
