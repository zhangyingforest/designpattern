package com.yc.designpattern.DMB22_状态模式.DM1;

/**
 * 抽象状态（State）角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为，可以有一个或多个行为。
 */
public interface State {

   //行为动作...
   public void doAction(Context context);

}