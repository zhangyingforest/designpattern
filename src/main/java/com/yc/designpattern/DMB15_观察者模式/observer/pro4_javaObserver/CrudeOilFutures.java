package com.yc.designpattern.DMB15_观察者模式.observer.pro4_javaObserver;

import java.util.Observer;
import java.util.Observable;

/**
 * 原油期货:   多方:   上涨
 *            空方:   下降.
 *
 *            量化金融中自动化交易.
 */
public class CrudeOilFutures {

    public static void main(String[] args) {
        //被观察方: 具体目标类：原油期货
        OilFutures oil = new OilFutures();
        //观察者
        Observer bull = new Bull(); //多方
        Observer bear = new Bear(); //空方
        //添加观察者
        oil.addObserver(bull);
        oil.addObserver(bear);

        oil.setPrice(10);


        oil.setPrice(-8);
    }
}
//具体目标类：原油期货
// 主题类:  被观察者
//   Observable   相当于   Subject
//         中的内容有:   1. 观察者列表   obs
//                     2. 通知观察状态变化 的方法
class OilFutures extends Observable {
    private float price;
    public float getPrice() {
        return this.price;
    }
    //状态变化
    public void setPrice(float price) {
        //通过网络访问期货市的价格
        super.setChanged();  //设置内部标志位，注明数据发生变化
        super.notifyObservers(price);    //通知观察者    价格改变了
        this.price = price;
    }
}


//具体观察者类：多方
//Observer类是jdk提供的.
class Bull implements Observer {
    /**
     *   主题中的状态发生变化时，回调的方法
     *   Observable:被 观察 （订阅)的对象
     *   arg:   变化的状态 价格
     */
    @Override
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
        if (price > 0) {
            //TODO: 交易策略.
            System.out.println("油价上涨" + price + "元，多方高兴了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，多方伤心了！");
        }
    }
}
//具体观察者类：空方／空头　　　
class Bear implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Float price = ((Float) arg).floatValue();
        if (price > 0) {
            System.out.println("油价上涨" + price + "元，空方伤心了！");
        } else {
            System.out.println("油价下跌" + (-price) + "元，空方高兴了！");
        }
    }
}