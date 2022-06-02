package com.yc.designpattern.DMA6_适配器模式.DM1_电源适配器;


//适配器类,用于将  220V的AC转为     DC5的安全电压
public class PowerAdapter implements DC5 {

    //在这里执有目标类的引用.
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    //在这个方法中完成将220v转为5v安全电压的功能
    @Override
    public int outoupDC5V() {
        int adapterInput = ac220.outputAC220V();
        int adapterOutput = adapterInput / 44;
        System.out.println("使用PowerAdapter输入AC:" + adapterInput + "V,输出DC：" + adapterOutput + "V");
        return adapterOutput;
    }
}
