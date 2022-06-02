package com.yc.principle.DMB5_开闭原则.day1;

/**
 * @program: design-pattern-yc
 * @description: 开闭原则
 * 基本介绍
 * 1、开闭原则（Open Closed Principle）是编程中最基础、最重要的设计原则
 * 2、一个软件实体如类，模块和函数应该对扩展开放(对提供方)，对修改关闭(对使用方)。用抽象构建框架，用实现扩展细节。
 * 3、当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码来实现变化。
 * 4、编程中遵循其它原则，以及使用设计模式的目的就是遵循开闭原则。
 */
public class Ocp {

    /**
     * 在GraphicEditor类中，drawShape方法绘制图形时，会根据传来的图形中的m_type进行判断为何图形，
     * 才进行调用指定的drawXXX()方法进行绘制
     *
     * 新需求 比如我们添加新的类Triangle“三角形”
     * 则要绘制时，必须在GraphicEditor类中的drawShape中加上一条判断语句，并且还要新添具体drawTriangle()方法才能绘制三角形
     * 可以看出要修改的地方很多，不仅仅要在调用者处添加判断else if (s.m_type == 3)，还要新添具体的绘制方法drawTriangle()
     *
     * 优缺点
     * 1、优点是比较好理解，简单易操作。
     * 2、 缺点是违反了设计模式的 ocp 原则，即对扩展开放(提供方)，对修改关闭(使用方)。
     *      即当我们给类GraphicEditor增加新功能的时候，尽量不修改代码，或者尽可能少修改代码。
     * 3、 比如我们这时要新增加一个图形种类三角形，我们需要做如下修改（示例2），修改的地方较多。
     */

    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
    }
}

/**
 * 这是一个用于绘图的类 [使用方]
 */
class GraphicEditor {
    /**
     * 接收Shape对象，然后根据type，来绘制不同的图形
     */
    public void drawShape(Shape s) {
        if (s.m_type == 1){
            drawRectangle(s);
        }else if (s.m_type == 2){
            drawCircle(s);
        }/*else if (s.m_type == 3){
            //此处根据新添的图形，所新添的判断语句
            drawTriangle(s);
        }*/
    }

    //绘制矩形
    public void drawRectangle(Shape r) {
        System.out.println(" 绘制矩形 ");
    }

    //绘制圆形
    public void drawCircle(Shape r) {
        System.out.println(" 绘制圆形 ");
    }
}

/**
 * Shape类，基类
 */
class Shape {
    int m_type;
}

/**
 * 具体的图形类
 */
class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
}

/**
 * 新增画三角形
 */
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
}
