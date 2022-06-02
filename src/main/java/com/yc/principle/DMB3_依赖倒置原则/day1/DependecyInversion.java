package com.yc.principle.DMB3_依赖倒置原则.day1;

/**
 * @program: design-pattern-yc
 * @description: 依赖倒转原则
 * 基本介绍
 * 1、高层模块不应该依赖低层模块，二者都应该依赖其抽象
 * 2、抽象不应该依赖细节，细节应该依赖抽象
 * 3、依赖倒转(倒置)的中心思想是面向接口编程
 * 4、依赖倒转原则是基于这样的设计理念：相对于细节的多变性，抽象的东西要稳定的多。以抽象为基础搭建的架构比以细节为基础的架构要稳定的多。
 *      在 java 中，抽象指的是接口或抽象类，细节就是具体的实现类
 * 5、使用接口或抽象类的目的是制定好规范，而不涉及任何具体的操作，把展现细节的任务交给他们的实现类去完成
 */
public class DependecyInversion {

    /*
        Person接收消息的功能
        1、简单，比较容易想到
        2、如果我们获取的对象是 微信，短信等等，则新增类，同时Perons也要增加相应的接收方法
        3、解决思路：引入一个抽象的接口IReceiver, 表示接收者, 这样Person类与接口IReceiver发生依赖
        4、因为Email, WeiXin 等等属于接收的范围，他们各自实现IReceiver 接口就ok, 这样我们就符合依赖倒转原则
     */

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息: hello,world";
    }
}



/**
 * 完成Person接收消息的功能
 */
class Person {
    public void receive(Email email ) {
        System.out.println(email.getInfo());
    }


}
