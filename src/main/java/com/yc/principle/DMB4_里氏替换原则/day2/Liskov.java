package com.yc.principle.DMB4_里氏替换原则.day2;

/**
 * @program: design-pattern-yc
 * @description: 里氏替换原则
 */
public class Liskov {
    /**
     * 1、示例1我们发现，我们发现原来运行正常的相减功能发生了错误。原因就是类 B 无意中重写了父类的方法，造成原有功能出现错误。
     * 在实际编程中，我们常常会通过重写父类的方法完成新的功能，这样写起来虽然简单，但整个继承体系的复用性会比较差。
     特别是运行多态比较频繁的时候
     * 2、通用的做法是： ****原来的父类和子类都继承一个更通俗的基类，原有的继承关系去掉，采用依赖，聚合，组合等关系代替.
     * ​ 此处基类就是Base类
     * @param args
     */

    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("-----------------------");
        B b = new B();
        //因为B类不再继承A类，因此调用者，不会再func1是求减法
        //调用完成的功能就会很明确
        System.out.println("11+3=" + b.func1(11, 3));//这里本意是求出11+3
        System.out.println("1+8=" + b.func1(1, 8));// 1+8
        System.out.println("11+3+9=" + b.func2(11, 3));

        //使用组合仍然可以使用到A类相关方法
        System.out.println("11-3=" + b.func3(11, 3));// 这里本意是求出11-3
    }

}

/**
 * 创建一个更加基础的基类
 */
class Base {
    //把更加基础的方法和成员写到Base类
}

/**
 * A类
 */
class A extends Base {
    // 返回两个数的差
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * B类继承了基类Base
 */
class B extends Base {
    //如果B需要使用A类的方法,使用组合关系
    private A a = new A();
    // 返回两个数的和
    public int func1(int a, int b) {
        return a + b;
    }
    //其它运算
    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    //我们仍然想使用A(this.a)的方法
    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}

