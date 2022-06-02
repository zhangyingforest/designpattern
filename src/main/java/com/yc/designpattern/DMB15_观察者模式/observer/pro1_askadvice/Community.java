package com.yc.designpattern.DMB15_观察者模式.observer.pro1_askadvice;

import java.util.Observable;

//被 观察的类.
public class Community extends Observable{
    private String name;

    public Community(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Community community, Question question){
        System.out.println(question.getUserName()+"在“" + community.name + "”上提交了一个问题。");
        super.setChanged();   //修改状态
        super.notifyObservers(question);  //通知观察者
    }

}
