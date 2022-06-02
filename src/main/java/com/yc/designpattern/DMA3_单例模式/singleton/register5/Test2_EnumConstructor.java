package com.yc.designpattern.DMA3_单例模式.singleton.register5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: design-pattern-yc
 * @description: 测试反射无法破坏枚举式单例
 * @author: zy
 * @create: 2022-04-22 09:53
 */
public class Test2_EnumConstructor {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cl= EnumSingleton1.class;
        Constructor c= cl.getDeclaredConstructor( );
        c.newInstance();

        //以上代码异常: NoSuchMethodException: com.yc.designpattern.DMA3_单例模式.singleton.register5.EnumSingleton1.<init>()
        //Enum类中没有这个无参构造方法,只一个protected修饰的带两个参数的构造方法
        Enum e;
        /*
            protected Enum(String name, int ordinal) {
                this.name = name;
                this.ordinal = ordinal;
            }
         */
    }
}
