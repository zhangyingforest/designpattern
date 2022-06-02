package com.yc.designpattern.DMA7_装饰者模式.DM2;

/**
 * @project: design-patterns
 * @description: 客户端测试类
 */
public class ClientTest {

    /**
     * 下面是一个使用了装饰设计模式的简单示例程序,其示例说明为 :
     * 使用面向对象技术开发了一套图形界面构件库,该构件库提供了大量的基本结构,如窗体,文本框,列表框等,由于在使用时用户经常要求定制一些特殊的显示效果,
     * 如带滚动条的窗体,或带黑色边框的文本框等. 因此经常需要对该构件库进行扩展以增强其功能,既而可以使用装饰设计模式来设计该界面构件库哟~
     */

    public static void main(String[] args) {
        Component component = new Window();
        component.display();   //原始窗体

        System.out.println("------------------");
        //添加装饰功能后的
        Component component2 = new ScrollBarDecorator(component);
        component2.display();
    }
}
