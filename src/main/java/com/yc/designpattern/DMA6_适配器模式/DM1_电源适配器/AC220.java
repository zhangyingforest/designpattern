package com.yc.designpattern.DMA6_适配器模式.DM1_电源适配器;


public class AC220 {

    public int outputAC220V(){
        int output = 220;
        System.out.println("输出电流" + output + "V");
        return output;
    }
}
