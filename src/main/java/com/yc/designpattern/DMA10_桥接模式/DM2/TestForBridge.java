package com.yc.designpattern.DMA10_桥接模式.DM2;


import com.yc.designpattern.DMA10_桥接模式.DM2.bridge.*;

/**
 * 桥接模式测试代码
 */
public class TestForBridge {

    public static void main(String[] args) {

        //品牌维度：奔驰、宝马、奥迪
        //颜色维度：蓝色、黑色、白色

        //可以随意组合

        //黑色奔驰汽车
        BenzCar blackBenzPhone = new BenzCar(new BlackColor());
        blackBenzPhone.run();

        System.out.println("=========================");

        //蓝色奔驰汽车
        BenzCar blueBenzCar = new BenzCar(new BlueColor());
        blueBenzCar.run();

        System.out.println("=========================");

        //白色宝马汽车
        BmwCar whiteBmwCar = new BmwCar(new WhiteColor());
        whiteBmwCar.run();

        System.out.println("=========================");

        //蓝色奥迪汽车
        AudiCar blueAudiCar = new AudiCar(new BlueColor());
        blueAudiCar.run();

        //两个维度可以随意搭配、也可以在这两个维度中随意扩展任意品牌和颜色

    }
}
