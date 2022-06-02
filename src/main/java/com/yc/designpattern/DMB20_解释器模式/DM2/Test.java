package com.yc.designpattern.DMB20_解释器模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 测试类
 */
public class Test {

    public static void main(String[] args) {
        //   (2+3)*10 =>  解析器
        //    10 2 3 + *
        //     10   5  *
        // 将字符串使用空格切割成数组
        // 遇到数字直接入栈
        // 遇到运算符 , 从栈中取出两个数据 , 进行计算 , 将计算结果再放入栈中
        // 遍历完毕后 , 最终的栈内数据就是最终结果
        String inputStr = "10 2 3 + *";
        ExpressionParser expressionParser = new ExpressionParser();
        expressionParser.parse(inputStr);

    }

}
