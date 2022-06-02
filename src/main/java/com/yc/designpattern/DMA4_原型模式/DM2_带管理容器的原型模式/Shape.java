package com.yc.designpattern.DMA4_原型模式.DM2_带管理容器的原型模式;

import java.util.List;

public abstract class Shape implements Cloneable {
   
   private String id;
   protected String type;

   public List values;

   //注意关键是在 这里，应该重写一个clone()方法,提供对象克隆功能。默认是一个浅克隆.
   @Override
   public Object clone() {
      Object clone = null;
      try {
         clone = super.clone();    ///
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
      return clone;
   }
   
   abstract void draw();

   public void setValues(List values) {
      this.values = values;
   }

   public List getValues() {
      return values;
   }

   public String getType(){
      return type;
   }
   
   public String getId() {
      return id;
   }
   
   public void setId(String id) {
      this.id = id;
   }



}