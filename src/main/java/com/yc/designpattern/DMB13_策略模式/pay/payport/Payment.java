package com.yc.designpattern.DMB13_策略模式.pay.payport;


import com.yc.designpattern.DMB13_策略模式.pay.MsgResult;

/**
 * 支付渠道
 */
public abstract class Payment {

    //支付类型
    public abstract String getName();

    //查询余额:  由子类实现.
    protected abstract double queryBalance(String uid);


    //模板方法模式.
    //扣款支付
    public MsgResult pay(String uid, double amount) {
        if(queryBalance(uid) < amount){
            return new MsgResult(500,"支付失败","余额不足");
        }
        //TODO 在这里可以加入每种不同的支付方式不同的业务处理的抽象调用》

        return new MsgResult(200,"支付成功","支付金额：" + amount);
    }


}
