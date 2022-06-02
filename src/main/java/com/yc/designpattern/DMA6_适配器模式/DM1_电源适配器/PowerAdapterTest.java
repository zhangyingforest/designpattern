package com.yc.designpattern.DMA6_适配器模式.DM1_电源适配器;


public class PowerAdapterTest {

    /**
     * 电源适配器
     * @param args
     */
    public static void main(String[] args) {
        //创建适配器对象，用于将目标类进行转换
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outoupDC5V();
    }
}
