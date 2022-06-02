package com.yc.designpattern.DMB19_备忘录模式.DM1;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理者（Caretaker）角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 */
public class CareTaker {
   //TODO:也可以是一个栈来保存.
   private List<Memento> mementoList = new ArrayList<Memento>();
 
   public void add(Memento state){
      mementoList.add(state);
   }

   /**
    * 获取第几步的状态信息
    * @param index
    * @return
    */
   public Memento get(int index){
      return mementoList.get(index);
   }

   /**
    * 出栈操作
    * @return
    */
   public Memento pop(){
      Memento last=mementoList.get(      mementoList.size()-1 );
      if( last!=null ) {
         mementoList.remove(last);
      }
      return last;
   }
}