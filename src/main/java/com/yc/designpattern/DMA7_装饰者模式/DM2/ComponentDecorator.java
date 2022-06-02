package com.yc.designpattern.DMA7_装饰者模式.DM2;

/**
 * @project: design-patterns
 * @description: 构件装饰类, 充当抽象装饰类,并包含具体构件的实例，可以通过其子类扩展具体构件的功能。
 */
public class ComponentDecorator extends Component {

    //维持对抽象构件类型对象的引用
    private Component component;

    //注入抽象构件类型的对象
    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}
