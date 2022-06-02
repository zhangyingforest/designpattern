package com.yc.designpattern.DMA3_单例模式.singleton.register5;

//常量中去使用，常量不就是用来大家都能够共用吗？
//通常在通用API中使用
public enum EnumSingleton1 {
    INSTANCE;
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton1 getInstance(){
        return INSTANCE;
    }


}

//利用   jad工具反向编译   EnumSingleton1的 字节码.
/*
public final class EnumSingleton1 extends Enum
{

    ......

    public static final EnumSingleton1 INSTANCE;
    private Object data;
    private static final EnumSingleton1 $VALUES[];

    static     //通过  static  创建了实例，实际上是一个饿汉式单例
    {
        INSTANCE = new EnumSingleton1("INSTANCE", 0);
        $VALUES = (new EnumSingleton1[] {
            INSTANCE
        });
    }
}


那么序列化能否破坏枚举式单例模式呢?
我们来分析一下  ObjectInputStream的 readObject() 方法:
    case TC_ENUM:
                    if (type == String.class) {
                        throw new ClassCastException("Cannot cast an enum to java.lang.String");
                    }
                    return checkResolve(readEnum(unshared));

readEnum() 方法：
     Enum<?> en = Enum.valueOf((Class)cl, name);
     通过类名和类对象找到唯一一个枚举对象．因此反射是无法破坏枚举式单例的．　
　　　cl指的是   EnumSingleton1 反射实例
     name指的是:   INSTANCE

 */
