package com.yc.designpattern.DMB21_中介者模式.doc;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: design-pattern-yc
 * @description: 中介者中jdk源码中的实现
 * @author: zy
 * @create: 2022-05-23 09:23
 */
public class Test {
    public static void main(String[] args) {
        //中介者
        Timer t=new Timer();
        // TimerTask任务 （同事角色）  ->  任务队列Ｑｕｅｕｅ
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }, 2000);



        /*
         追踪源码  schedule()可以看到 queue.add(task);
        不论是什么样的任务都将加⼊到队列中，我们都把这个队列中的对象称为“同事”。
        查看 sched() ⽅法的源码可以看出，所有的任务(task)都放到了 Timer 类维护的 task 队列中，
        同事之间的通信都是通过 Timer 来协调完成的，所以，Timer 承担了中介者的⾓⾊，⽽ task 队列内
的任务就是具体同事对象。

         */
    }
}
