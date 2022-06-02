package com.yc.principle.DMB1_单一职责原则.day3;

/**
 * @program: design-pattern-yc
 * @description: 单一职责原则
 */
public class SingleResponsibility3 {

    /**
     * 1、这种修改方法没有对原来的类做大的修改，只是增加方法
     * 2、 这里虽然没有在类这个级别上遵守单一职责原则，
     *    *****但是在方法级别上，仍然是遵守单一职责，即在交通工具类vehicle规范上，根据各种交通工具的运行方式不同，增加不同的方法
     *
     */

    public static void main(String[] args) {
        Vehicle2 vehicle2  = new Vehicle2();
        vehicle2.run("汽车");
        vehicle2.runWater("轮船");
        vehicle2.runAir("飞机");
    }

}


class Vehicle2 {

    public void run(String vehicle) {
        //各种处理
        System.out.println(vehicle + " 在公路上运行....");
        //各种处理
    }

    public void runAir(String vehicle) {
        //各种处理
        System.out.println(vehicle + " 在天空上运行....");
        //各种处理
    }

    public void runWater(String vehicle) {
        //各种处理
        System.out.println(vehicle + " 在水中行....");
        //各种处理
    }
}
