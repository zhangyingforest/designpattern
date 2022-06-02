package com.yc.designpattern.DMB20_解释器模式.DM2;

import java.util.Stack;

/**
 * @program: design-pattern-yc
 * @description: 语法解析器
 */
public class ExpressionParser {

    /**
     * 存放解释器的栈
     *      栈的特点是先进后出
     */
    private Stack<Interpreter> stack = new Stack<>();

    /**
     * 解析字符串语法
     * @param str:   10 + 1
     */
    public void parse(String str) {
        // 通过空格分割字符串
        String[] strArray = str.split(" ");

        // 遍历栈中的字符串
        for (String symbol : strArray) {
            if (!OperatorUtil.isOperator(symbol)) {
                // 如果不是操作符 , 说明是数字 , 则直接入栈
                Interpreter interpreter = new NumberInterpreter(symbol);
                stack.push(interpreter);
                System.out.println(symbol + " 入栈");
            } else {
                // 如果是操作符 , 则数据出栈 , 处理是操作符运算的情况

                // 取出两个需要计算的元素
                Interpreter firstInterpreter = stack.pop();
                System.out.println(firstInterpreter + " 出栈");
                Interpreter secondInterpreter = stack.pop();
                System.out.println(secondInterpreter + " 出栈");

                // 获取 运算符号 对应的解释器
                Interpreter operator = OperatorUtil.getExpressionInterpretor(
                                symbol,
                                firstInterpreter,
                                secondInterpreter);
                System.out.println("运算符 " + operator + " 出栈");

                // 计算 运算符 运算结果
                int result = operator.interpret();

                // 将计算结果你年入栈
                NumberInterpreter numberInterpreter = new NumberInterpreter(result);
                stack.push(numberInterpreter);
                System.out.println("计算结果 " + result + " 入栈");
            }
        }

        // 取出最终计算结果 , 计算完毕后 , 整个栈必然只剩下一个元素
        int result = stack.pop().interpret();
        System.out.println("最终计算结果 : " + result);
    }

}
