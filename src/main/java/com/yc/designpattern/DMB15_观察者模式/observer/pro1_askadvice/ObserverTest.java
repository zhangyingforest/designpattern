package com.yc.designpattern.DMB15_观察者模式.observer.pro1_askadvice;


public class ObserverTest {
    public static void main(String[] args) {

        Community course = new Community("java生态圈");
        Teacher tom = new Teacher("john");
        Teacher mic = new Teacher("Mic");
        //注册观察者到被 观察对象
        course.addObserver(tom);
        course.addObserver(mic);

        //业务逻辑代码
        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者模式适用于哪些场景？");

        course.publishQuestion(course,question);

    }
}
