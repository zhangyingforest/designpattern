package com.yc.designpattern.DMA3_单例模式.singleton.register5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//Spring中的做法，就是用这种注册式单例
public class ContainerSingleton2 {

    private ContainerSingleton2(){}

    private static Map<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    public static Object getInstance(String className){
        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className, obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            } else {
                return ioc.get(className);
            }
        }
    }
}
