package com.yc.designpattern.DMB16_迭代子模式.DM1;

/**
 * 姓名容器，存很多用户的名字，能迭代（循环）
 */
public class NameRepository implements Container {

   public String names[] = {"Robert" , "John" ,"Julie" , "Lora"};


   /**
    * 能获取到迭代器
    * @return
    */
   @Override
   public Iterator<String> iterator() {
      return new NameIterator();
   }


   /**
    * 利用内部类做一个迭代器的实现，以完成对　　　数组的循环．.
    */
   private class NameIterator implements Iterator<String> {
      //index代表当前循环第几个下标的元素了.
      int index;  //因为当前容器的底层为一个数组， 可以通过索引下标进行迭代

      @Override
      public boolean hasNext() {
         if(  names==null||names.length<=0){
            return false;
         }
         if(index < names.length){
            return true;
         }
         return false;
      }
 
      @Override
      public String next() {
         if(this.hasNext()){
            return names[index++];
         }
         return null;
      }     
   }
}