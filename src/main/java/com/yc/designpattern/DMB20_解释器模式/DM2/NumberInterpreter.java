package com.yc.designpattern.DMB20_解释器模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 非终结符表达式，对整数进行解释
 */
public class NumberInterpreter implements Interpreter {
    private int number;

    public NumberInterpreter(int number) {
        this.number = number;
    }

    //*****
    public NumberInterpreter(String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public int interpret() {
        return this.number;
    }
}