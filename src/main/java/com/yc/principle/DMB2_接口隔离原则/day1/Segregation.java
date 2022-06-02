package com.yc.principle.DMB2_接口隔离原则.day1;

/**
 * @program: design-pattern-yc
 * @description: 接口隔离原则
 *
 * 基本介绍
 * 1、客户端不应该依赖它不需要的接口，即一个类对另一个类的依赖应该建立在最小的接口上
 * 2、图示 类图1.png
 * 3、 类 A 通过接口 Interface1 依赖类 B，类 C 通过接口 Interface1 依赖类 D，
 如果接口 Interface1 对于类 A 和类 C来说不是最小接口，
       那么类 B 和类 D 必须去实现他们不需要的方法。
 * 4、按隔离原则应当这样处理：
 *      将接口 Interface1拆分为独立的几个接口 (这里我们拆分成 3 个接口)，类 A 和类 C 分别与他们需要的接口建立依赖关系。
 *      也就是采用接口隔离原则
 */
public class Segregation {

    /**
     * 1、类 A 通过接口 Interface1 依赖类 B，类 C 通过接口 Interface1 依赖类 D
     * 2、可以看到，如果接口过于臃肿，只要接口中出现的方法，不管对依赖于它的类有没有用处，实现类中都必须去实现这些方法，这显然不是好的设计。
     * 如果将这个设计修改为符合接口隔离原则，就必须对接口I进行拆分。
     */
    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }
}


/**
 * 接口
 */
interface Interface1 {

    void operation1();

    void operation2();

    void operation3();

    void operation4();

    void operation5();
}

/**
 * 下列各实现类
 */
class B implements Interface1 {
    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }
    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }
    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }
    @Override
    public void operation4() {
        System.out.println("B 实现了 operation4");
    }
    @Override
    public void operation5() {
        System.out.println("B 实现了 operation5");
    }
}

class D implements Interface1 {
    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }
    @Override
    public void operation2() {
        System.out.println("D 实现了 operation2");
    }
    @Override
    public void operation3() {
        System.out.println("D 实现了 operation3");
    }
    @Override
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }
    @Override
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}

/**
 * A 类通过接口Interface1 依赖(使用) B类，但是只会用到1,2,3方法
 */
class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }
    public void depend2(Interface1 i) {
        i.operation2();
    }
    public void depend3(Interface1 i) {
        i.operation3();
    }
}

/**
 * C 类通过接口Interface1 依赖(使用) D类，但是只会用到1,4,5方法
 */
class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }
    public void depend4(Interface1 i) {
        i.operation4();
    }
    public void depend5(Interface1 i) {
        i.operation5();
    }
}