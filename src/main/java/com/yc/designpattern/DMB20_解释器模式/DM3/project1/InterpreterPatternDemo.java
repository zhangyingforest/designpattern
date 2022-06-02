package com.yc.designpattern.DMB20_解释器模式.DM3.project1;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-05-18 10:53
 */

import java.util.*;

/*文法规则
  <expression> ::= <city>的<person>
  <city> ::= 韶关|广州
  <person> ::= 老人|妇女|儿童
*/
public class InterpreterPatternDemo {
    public static void main(String[] args) {
        Context bus = new Context();   // 条件表达式
        //解析读卡器的内容
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }
}

//抽象表达式类
interface Expression {
    public boolean interpret(String info);
}

//终结符表达式类
class TerminalExpression implements Expression {
    /**
     * 用集合（Set）类来保存满足条件的城市或人，
     */
    private Set<String> set = new HashSet<String>();

    /**
     * 用集合（Set）类来保存满足条件的城市或人
     * @param data
     */
    public TerminalExpression(String[] data) {
        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
    }

    /**
     * 判断被分析的字符串是否是集合中的终结符
     * @param info ： 待判断的字符串
     * @return
     */
    @Override
    public boolean interpret(String info) {
        if (set.contains(info)) {
            return true;
        }
        return false;
    }
}

/**
  非终结符表达式类
 */
class AndExpression implements Expression {
    private Expression city = null;
    private Expression person = null;

    public AndExpression(Expression city, Expression person) {
        this.city = city;
        this.person = person;
    }

    /**
     * 判断被分析的字符串是否是满足条件的城市中的满足条件的人员
     * @param info： 待判断的信息   “广州的老人"
     * @return
     */
    @Override
    public boolean interpret(String info) {
        String s[] = info.split("的");
        return city.interpret(s[0]) && person.interpret(s[1]);
    }
}



/**
环境类
 * 包含解释器需要的数据，完成对终结符表达式的初始
 */
class Context {
    private String[] citys = {"韶关", "广州"};
    private String[] persons = {"老人", "妇女", "儿童"};

    private Expression cityPerson;   //非终结的表达式，对外公开

    public Context() {
        Expression city = new TerminalExpression(citys);
        Expression person = new TerminalExpression(persons);
        cityPerson = new AndExpression(city, person);
    }

    /**
     * 调用表达式对象的解释方法来对被分析的字符串进行解释
     * @param info:    "长沙的中年人"
     */
    public void freeRide(String info) {
        boolean ok = cityPerson.interpret(info);
        if (ok) {
            System.out.println("您是" + info + "，您本次乘车免费！");
        } else {
            System.out.println(info + "，您不是免费人员，本次乘车扣费2元！");
        }
    }
}
