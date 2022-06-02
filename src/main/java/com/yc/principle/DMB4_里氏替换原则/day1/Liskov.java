package com.yc.principle.DMB4_里氏替换原则.day1;

/**
 * @program: design-pattern-yc
 * @description: 里氏替换原则
 * 基本介绍
 * 1、里氏替换原则(Liskov Substitution Principle)在 1988 年，由麻省理工学院的以为姓里的女士提出的。
 * 2、如果对每个类型为 T1 的对象 o1，都有类型为 T2 的对象 o2，使得以 T1 定义的所有程序 P 在所有的对象 o1 都代换成 o2 时，
 *      程序 P 的行为没有发生变化，那么类型 T2 是类型 T1 的子类型。
 *      换句话说，所有引用基类的地方必须能透明地使用其子类的对象。
 * 3、在使用继承时，遵循里氏替换原则，在子类中尽量不要重写父类的方法
 * 4、里氏替换原则告诉我们，继承实际上让两个类耦合性增强了，在适当的情况下，可以通过聚合，组合，依赖 来解决问题。
 */
public class Liskov {

    /**
     * A类中的func1()方法是求两数之差，B类继承了A类之后，不小心重写了A类中的func1()，
     * 使其改为了求两数之和，所以在main()方法测试时，得到的结果，在预料之外
     */
    public static void main(String[] args) {
        A a = new A();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));

        System.out.println("-----------------------");
        B b = new B();
        //这里本意是求出11-3，但求的是11+3，因为B类重写了父类A中的func1()
        System.out.println("11-3=" + b.func1(11, 3));
        //本意是1-8 但求的是1+8，因为B类重写了父类A中的func1()
        System.out.println("1-8=" + b.func1(1, 8));
        //求的是(11+3)+9
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}

/**
 * A类
 */
class A {
    /**
     * 返回两个数的差
     */
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * B类继承了A
 * 增加了一个新功能：完成两个数相加,然后和9求和
 */
class B extends A {
    /**
     * 这里，重写了A类的方法, 可能是无意识
     */
    @Override
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}

