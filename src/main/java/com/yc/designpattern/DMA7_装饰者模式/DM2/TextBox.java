package com.yc.designpattern.DMA7_装饰者模式.DM2;

/**
 * @project: design-patterns
 * @description: 文本框类, 充当具体构件类,实现抽象构件，通过装饰角色为其添加一些职责。
 */
public class TextBox extends Component {

    @Override
    public void display() {
        System.out.println("显示文本框 !");
    }
}
