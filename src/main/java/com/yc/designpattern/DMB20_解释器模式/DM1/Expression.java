package com.yc.designpattern.DMB20_解释器模式.DM1;

/**
 * 抽象表达式（Abstract Expression）角色：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
 */
public interface Expression {
   /**
    * 解析context内容是否满足要求
    * @param context
    * @return
    */
   public boolean interpret(String context);
}