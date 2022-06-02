package com.yc.designpattern.DMA7_装饰者模式.DM2;

/**
 * @project: design-patterns
 * @description: 滚动条装饰类, 充当具体装饰类,实现抽象装饰的相关方法，并给具体构件对象添加附加的责任。
 */
public class ScrollBarDecorator extends ComponentDecorator {

    public ScrollBarDecorator(Component component) {
        super(component);
    }

    @Override
    public void display() {
        this.setScrollBar();
        super.display();
    }

    private void setScrollBar() {
        System.out.println("为构件添加滚动条 !");
    }
}
