package com.yc.designpattern.DMA3_单例模式.singleton.register5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @program: design-pattern-yc
 * @description: Enum有参构造方法访问不到
 * @author: zy
 * @create: 2022-04-22 10:28
 */
public class Test3_EnumConstructor2 {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Class clz=EnumSingleton1.class;
        Constructor c=clz.getDeclaredConstructor(   String.class,  int.class);
        c.setAccessible(true);
        EnumSingleton1 es1= (EnumSingleton1) c.newInstance("tom",666);

        /*
        IllegalArgumentException: Cannot reflectively create enum objects  不能用反射的方式来创建对象
        为什么呢？  查看一下   反射中   Constructor中的 newInstance()方法.

         if ((clazz.getModifiers() & Modifier.ENUM) != 0)
            throw new IllegalArgumentException("Cannot reflectively create enum objects");
         它在newInstance()中做了强制性判断 ， 如果修饰符为  Enum,则抛出异常.

         这种枚举型单例是effective java中推荐的实现写法。
         小结:   jdk橘生淮南的语法特殊性及反射为枚举式单例保驾。
         */
    }
}
