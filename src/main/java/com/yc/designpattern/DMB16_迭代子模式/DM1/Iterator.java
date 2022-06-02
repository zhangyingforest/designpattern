package com.yc.designpattern.DMB16_迭代子模式.DM1;

/**
 * 迭代器接口
 */
public interface Iterator<T> {
   /**
    * 是否有下一个元素
    * @return
    */
   public boolean hasNext();

   /**
    * 提取下一个元素
    * @return
    */
   public T next();

}