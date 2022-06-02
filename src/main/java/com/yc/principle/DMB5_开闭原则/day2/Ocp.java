package com.yc.principle.DMB5_开闭原则.day2;

/**
 * @program: design-pattern-yc
 * @description: 开闭原则
 */
public class Ocp {

    /**
     * 1、根据示例1，我们进行下列改进，并且利用开闭原则。
     * 2、把创建 Shape 类做成抽象类，并提供一个抽象的 draw 方法，让子类去实现即可，这样我们有新的图形种类时，只需要让新的图形类继承 Shape，
     * 并实现 draw 方法即可，使用方的代码就不需要修 一>满足了开闭原则。
     * 3、在GraphicEditor类中进行drawShape绘制时，也不用 if else语句进行判断（如示例1），直接调用图形的draw()方法即可。具体实现看下面代码。
     */
    public static void main(String[] args) {
        //使用看看存在的问题
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }
}


/**
 * 这是一个用于绘图的类 [使用方]
 */
class GraphicEditor {
    //接收Shape对象，调用draw方法
    public void drawShape(Shape s) {
        s.draw();
    }
}

/**
 * Shape类，基类
 */
abstract class Shape {
    int m_type;
    public abstract void draw();//抽象方法
}

class Rectangle extends Shape {
    Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制矩形 ");
    }
}

class Circle extends Shape {
    Circle() {
        super.m_type = 2;
    }
    @Override
    public void draw() {
        System.out.println(" 绘制圆形 ");
    }
}

/**
 * 新增画三角形
 */
class Triangle extends Shape {
    Triangle() {
        super.m_type = 3;
    }
    @Override
    public void draw() {
        System.out.println(" 绘制三角形 ");
    }
}

/**
 * 新增一个图形
 */
class OtherGraphic extends Shape {
    OtherGraphic() {
        super.m_type = 4;
    }

    @Override
    public void draw() {
        System.out.println(" 绘制其它图形 ");
    }
}

