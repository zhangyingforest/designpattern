package com.yc.principle.DMB2_接口隔离原则.day2;

/**
 * @program: design-pattern-yc
 * @description: 接口隔离原则
 */
public class Segregation {

    /**
     * 改进示例1后
     *
     * 1、 类 A 通过接口 Interface1 依赖类 B，类 C 通过接口 Interface1 依赖类 D，如果接口 Interface1 对于类 A 和类 C来说不是最小接口，
     * 那么类 B 和类 D 必须去实现他们不需要的方法
     * 2、将接口 Interface1 拆分为独立的几个接口，类 A 和类 C 分别与他们需要的接口建立依赖关系。也就是采用接口隔离原则
     * 3、 接口 Interface1 中出现的方法，根据实际情况拆分为三个接口
     * 4、图示：类图2.png
     * A要通过B用到Interface1接口中的1()、2()、3()方法
     * C要通过D用到Interface1接口中的1()、4()、5()方法
     */

    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B()); // A类通过接口去依赖B类
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D()); // C类通过接口去依赖(使用)D类
        c.depend4(new D());
        c.depend5(new D());
    }
}


// 接口1
interface Interface1 {
    void operation1();
}

// 接口2
interface Interface2 {
    void operation2();

    void operation3();
}

// 接口3
interface Interface3 {
    void operation4();

    void operation5();
}

class B implements Interface1, Interface2 {
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

}

class D implements Interface1, Interface3 {
    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
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
 * A 类通过接口Interface1,Interface2 依赖(使用) B类，但是只会用到1,2,3方法
 */
class A {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend2(Interface2 i) {
        i.operation2();
    }

    public void depend3(Interface2 i) {
        i.operation3();
    }
}

/**
 * C 类通过接口Interface1,Interface3 依赖(使用) D类，但是只会用到1,4,5方法
 */
class C {
    public void depend1(Interface1 i) {
        i.operation1();
    }

    public void depend4(Interface3 i) {
        i.operation4();
    }

    public void depend5(Interface3 i) {
        i.operation5();
    }
}

