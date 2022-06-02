原型模式

原型模式（Prototype Pattern）是用于创建重复的对象，同时又能保证性能。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。
这种模式是实现了一个原型接口，该接口用于创建当前对象的克隆。当直接创建对象的代价比较大时，则采用这种模式。例如，一个对象需要在一个高代价的数据库操作之后被创建。
    我们可以缓存该对象，在下一个请求时返回它的克隆，在需要的时候更新数据库，以此来减少数据库调用。

介绍

意图：用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
主要解决：在运行期建立和删除原型。

何时使用：
    1、类初始化消耗资源较多
    2. 使用new生成一个对象需要非常烦琐的过程
    3. 构造函数比较复杂
    4. 在循环体中产生大量对象

如何解决：利用已有的一个原型对象，快速地生成和原型对象一样的实例。

关键代码：
    1、实现克隆操作，在 JAVA 继承 Cloneable，重写 clone()，在 .NET 中可以使用 Object 类的 MemberwiseClone() 方法来实现对象的浅拷贝或通过序列化的方式来实现深拷贝。
    2、原型模式同样用于隔离类对象的使用者和具体类型（易变类）之间的耦合关系，它同样要求这些"易变类"拥有稳定的接口。

应用实例：
    1、JAVA 中的 Object clone() 方法。

优点：
    1、性能提高。
    2、逃避构造函数的约束。

缺点：
    1、配备克隆方法需要对类的功能进行通盘考虑，这对于全新的类不是很难，但对于已有的类不一定很容易，
             特别当一个类引用不支持串行化的间接对象，或者引用含有循环结构的时候。
    2、必须实现 Cloneable 接口。

    深复制把要复制的对象所引用的对象都复制了一遍。
    拷贝需要实现Cloneable, Serializable两个接口，重写clone方法



***Java 默认的 clone 方法是浅拷贝，那如何实现深拷贝呢？
      1. 实现 Cloneable 接口，递归 clone 引用对象或 new 新对象(类的属性字段未实现 Cloneable 接口)
      2. 借助序列化完成深拷贝，如实现 JDK java.io.Serializable 接口、json格式序列化、xml格式序列化等


在我们平时开发中，也会使用 Spring 中 org.springframework.beans.BeanUtils 的 copyProperties 方法复制一个对象的属性到另一个对象
public static void copyProperties(Object source, Object target) throws BeansException {
    copyProperties(source, target, null, (String[]) null);
}

apache commons-beanutils 包中 org.apache.commons.beanutils.BeanUtils 工具类中有 cloneBean 方法无需实现 Cloneable 接口的浅拷贝，也有 copyProperties 和 copyPropertie 方法复制对象属性和指定属性进行复制。




注意事项：与通过对一个类进行实例化来构造新对象不同的是，原型模式是通过拷贝一个现有对象生成新对象的。
       浅拷贝实现 Cloneable，重写，深拷贝是通过实现 Serializable 读取二进制流。