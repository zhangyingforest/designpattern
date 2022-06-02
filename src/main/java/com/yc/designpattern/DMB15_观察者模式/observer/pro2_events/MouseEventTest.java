package com.yc.designpattern.DMB15_观察者模式.observer.pro2_events;


import com.yc.designpattern.DMB15_观察者模式.observer.pro2_events.mouseevent.Mouse;
import com.yc.designpattern.DMB15_观察者模式.observer.pro2_events.mouseevent.MouseEventType;

public class MouseEventTest {
    public static void main(String[] args) {

        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();

        //绑定事件与回调处理方法
        mouse.addLisenter(MouseEventType.ON_CLICK,callback);
        mouse.addLisenter(MouseEventType.ON_FOCUS,callback);

        mouse.click();

        mouse.focus();


    }
}
