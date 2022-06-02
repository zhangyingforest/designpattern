package com.yc.designpattern.DMB16_迭代子模式.DM1;

/**
 * 容器接口
 */
public interface Container<T> {

   /**
    * 每个容器中有一个迭代器
    * @return
    */
   public Iterator iterator();

//   public void add( T t);
//
//   public void remove( T t);
//
//   public int size();

}