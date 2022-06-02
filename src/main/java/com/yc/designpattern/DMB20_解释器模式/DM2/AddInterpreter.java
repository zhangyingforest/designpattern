package com.yc.designpattern.DMB20_解释器模式.DM2;

/**
 * @program: design-pattern-yc
 * @description:  加法  非终结
 */
public class AddInterpreter implements Interpreter {
    private Interpreter firstExpression, secondExpression;

    public AddInterpreter(Interpreter firstExpression, Interpreter secondExpression) {
        this.firstExpression = firstExpression;
        this.secondExpression = secondExpression;
    }

    @Override
    public int interpret() {
        return this.firstExpression.interpret() + this.secondExpression.interpret();
    }

    @Override
    public String toString() {
        return "+";
    }
}

