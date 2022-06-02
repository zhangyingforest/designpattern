package com.yc.designpattern.DMB20_解释器模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 乘法
 */
public class MultiInterpreter implements Interpreter {
    private Interpreter firstExpression, secondExpression;

    public MultiInterpreter(Interpreter firstExpression, Interpreter secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }
    @Override
    public int interpret() {
        return this.firstExpression.interpret() * this.secondExpression.interpret();
    }
    @Override
    public String toString() {
        return "*";
    }
}
