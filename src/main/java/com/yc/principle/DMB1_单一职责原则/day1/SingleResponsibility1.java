package com.yc.principle.DMB1_单一职责原则.day1;

/**
 * @program: design-pattern-yc
 * @description: 单一职责原则
 */
public class SingleResponsibility1 {

    /*
     *以下示例 没有遵守  单一职责原则
     *对类来说的，即一个类应该只负责一项职责。如类A负责两个不同职责:职责1，职责2。
     *当职责1需求变更而改变A时，可能造成职责2执行错误，所以需要将类A的粒度分解为Al, A2
     *
     * 在Vehicle类的run方法中，违反了单一职责原则，没有解决不同交通工具运行的方式不一样的问题，都实现为了“在公路上运行…”
     *
     * 解决的方案 : 非常的简单，根据交通工具运行方法不同，分解成不同类即可 ===> 示例2
     */

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("摩托车");
        vehicle.run("汽车");
        vehicle.run("飞机");
    }

}

/**
 * 交通工具类
 */
class Vehicle {
    public void run(String vehicle) {

        System.out.println(vehicle + " 在公路上运行....");
    }
}
