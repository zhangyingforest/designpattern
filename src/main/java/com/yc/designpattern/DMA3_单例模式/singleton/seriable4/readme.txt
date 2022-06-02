一个对象创建好了后，有时需要将对象序列化后存到磁盘，下次再反序列化出来，转为内存对象，  此时，反序列化后的对象会重新分配内存，
但如果反序列化后的对象为单例对象，就违反了单例初衷.



解决方案加入  readResolve()   的源码分析:
1. ObjectInputStream类  -> readObject ()  在这里调用了重写的  readObject0()方法
2. 在readObject0()中
       case TC_OBJECT:
               if (type == String.class) {
                         throw new ClassCastException("Cannot cast an object to java.lang.String");
               }
               return checkResolve(readOrdinaryObject(unshared));
3. readOrdinaryObject()方法中
        Object obj;
            try {
                //只要有无参构造方法，就调用.
                obj = desc.isInstantiable() ? desc.newInstance() : null;
            } catch (Exception ex) {
                throw (IOException) new InvalidClassException(
                    desc.forClass().getName(),
                    "unable to create instance").initCause(ex);
            }
         //上面这一段代码已经完成了对象的创建

          if (obj != null &&
                     handles.lookupException(passHandle) == null &&
                     desc.hasReadResolveMethod())
                 {
                     Object rep = desc.invokeReadResolve(obj);
           但在这里，它判断 了一下  是否有   readResolve() 方法，如果有，则调用.
4. 那么问题来了， 这个   desc.hasReadResolveMethod() 方法用来判断    readResolve()是否存在又是在哪里创建的呢？
   它是在  ObjectStreamClass的构造方法中在初始化阶段就创建好了:
       readResolveMethod = getInheritableMethod( cl, "readResolve", null, Object.class);



最后，虽然通过   增加   readResolve()方法返回实例以解决单例模式被破坏的问题，但实际上底层此对象是被实例化过两次.
如创建对象的动作请求数加快，则意味着内存分配的开销加大， 如何解决呢？

  容器注册式单例模式.