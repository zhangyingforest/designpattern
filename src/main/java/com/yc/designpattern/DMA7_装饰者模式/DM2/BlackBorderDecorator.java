package com.yc.designpattern.DMA7_装饰者模式.DM2;

/**
 * @project: design-patterns
 * @description: 黑色边框装饰类, 充当具体装饰类,实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
public class BlackBorderDecorator extends ComponentDecorator {

    public BlackBorderDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    private void setBlackBorder() {
        System.out.println("为构件添加黑色边框 !");
    }
}
