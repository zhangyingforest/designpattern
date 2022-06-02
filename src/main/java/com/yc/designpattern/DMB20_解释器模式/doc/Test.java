package com.yc.designpattern.DMB20_解释器模式.doc;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.regex.Pattern;

/**
 * @program: design-pattern-yc
 * @description: jdk和spring中应用的解释器模式
 * @author: zy
 * @create: 2022-05-18 11:15
 */
public class Test {
    //1. jdk中的正则表达式的解析器
    final Pattern p=Pattern.compile("\\w{0,5}", Pattern.MULTILINE);

    public static void main(String[] args) {


        //2. 在 Spring 中，ExpressionParser 接口内部采用的也是解释器模式，
        // 它封装了字符串表达式的语法，源码如下
        ExpressionParser ep;

        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("100*2+400*1+66");
        int result = (Integer) expression.getValue();
        System.out.println("计算结果是：" + result);

    }
}
