package com.yc.designpattern.DMB20_解释器模式.DM3;

/**
 * 以下是解释器模式的一个代码模式.
 * @program: design-pattern-yc
 * @description: 解释器模式实现的关键是定义文法规则、设计终结符类与非终结符类、画出结构图，必要时构建语法树
 * @author: zy
 * @create: 2022-05-18 10:46
 */
public class Context {
    //非终结符
    private AbstractExpression exp;

    public Context() {
        //数据初始化
    }

    public void operation(String info) {
        //调用相关表达式类的解释方法
    }
}

//抽象表达式类
interface AbstractExpression {
    public Object interpret(String info);    //解释方法
}

//终结符表达式类
class TerminalExpression implements AbstractExpression {

    /**
     *
     * @param info: 要处理的信息
     * @return : 处理的结果
     */
    @Override
    public Object interpret(String info) {  //  "55"
        //对终结符表达式的处理
        return null;
    }
}

//非终结符表达式类:组合多个表达式     5+4
//                              (1+2) +  (3+4)
class NonterminalExpression implements AbstractExpression {
    private AbstractExpression exp1;
    private AbstractExpression exp2;

    public NonterminalExpression(AbstractExpression exp1, AbstractExpression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    @Override
    public Object interpret(String info) {
        //非对终结符表达式的处理
        //组合两个表达式.运算结果
        return null;
    }
}


