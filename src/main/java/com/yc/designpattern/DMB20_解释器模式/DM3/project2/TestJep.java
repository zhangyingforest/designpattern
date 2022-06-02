package com.yc.designpattern.DMB20_解释器模式.DM3.project2;


import org.nfunk.jep.JEP;

/**
 * @program: design-pattern-yc
 * @description: Jep表达式分析器
 * @author: zy
 * @create: 2022-05-18 11:09
 */
public class TestJep {
    public static void main(String[] args) {

        JEP jep = new JEP();
        //定义要计算的数据表达式
        String 存款利息 = "本金*利率*时间";
        //给相关变量赋值
        jep.addVariable("本金", 10000);
        jep.addVariable("利率", 0.038);
        jep.addVariable("时间", 2);

        jep.parseExpression(  存款利息  );

        Object accrual = jep.getValue();   //计算
        System.out.println("存款利息：" + accrual);
    }
}
