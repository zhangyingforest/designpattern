package com.yc.principle.DMB3_依赖倒置原则.day2;

/**
 * @program: design-pattern-yc
 * @description: 依赖倒转原则
 */
public class DependecyInversion {

    /**
     * 改进示例1
     * 1、用到了依赖倒转原则
     * 2、让Email和Weixin继承接口IReceiver，并实现其中的方法规范，这样客户端Person可以接受来自不同类型的消息，Person并不会增加相应的方法(如示例1)
     * 3、Email, WeiXin 等等属于接收的消息范围，他们各自实现IReceiver 接口就ok, 这样我们就符合依赖倒转原则
     */

    public static void main(String[] args) {
        //客户端无需改变
        Person person = new Person();

        person.receive(new Email());
        person.receive(new WeiXin());
    }
}

/**
 * 定义接口
 */
interface IReceiver {
    public String getInfo();
}

/**
 * 实现类
 */
class Email implements IReceiver {
    @Override
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}

//增加微信
class WeiXin implements IReceiver {
    @Override
    public String getInfo() {
        return "微信信息: hello,ok";
    }
}



/**
 * 客户端
 */
class Person {
    /**
     * 这里我们是对接口的依赖
     * @param receiver
     */
    public void receive(IReceiver receiver ) {
        System.out.println(receiver.getInfo());
    }
}

