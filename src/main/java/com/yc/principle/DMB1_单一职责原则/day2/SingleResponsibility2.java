package com.yc.principle.DMB1_单一职责原则.day2;

/**
 * @program: design-pattern-yc
 * @description:单一职责原则
 */
public class SingleResponsibility2 {

    /*
     * 1. 遵守单一职责原则
     * 2. 但是这样做的改动很大，即根据不同情况，将类vehicle分解，创建出了各种vehicle，同时修改了客户端(main)
     * 3. 改进：直接修改Vehicle类，改动的代码会比较少 ===> 示例3
     */

    public static void main(String[] args) {
        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");
        roadVehicle.run("汽车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");
    }
}

class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "公路运行");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "天空运行");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "水中运行");
    }
}