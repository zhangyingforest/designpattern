package com.yc.designpattern.DMB20_解释器模式.DM1;

/**
 * 终结符
 */
public class TerminalExpression implements Expression {

   //表达式的要求:
   private String data;
 
   public TerminalExpression(String data){
      this.data = data; 
   }

   /**
    * 判断 文本context是否满足   data的要求.
    * @param context
    * @return
    */
   @Override
   public boolean interpret(String context) {
      if(context.contains(data)){
         return true;
      }
      return false;
   }
}