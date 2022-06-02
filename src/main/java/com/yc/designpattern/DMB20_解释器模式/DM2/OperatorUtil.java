package com.yc.designpattern.DMB20_解释器模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 工具类
 */
public class OperatorUtil {

    public static boolean isOperator(String symbol) {
        return (symbol.equals("+") || symbol.equals("*"));
    }

    public static Interpreter getExpressionInterpretor(
            String symbol,
            Interpreter firstInterpreter,
            Interpreter secondInterpreter) {

        Interpreter interpreter = null;
        if (symbol.equals("+")) {
            interpreter = new AddInterpreter(firstInterpreter, secondInterpreter);
        } else if (symbol.equals("*")) {
            interpreter = new MultiInterpreter(firstInterpreter, secondInterpreter);
        }
        return interpreter;
    }
}
