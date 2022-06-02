package com.yc.designpattern.DMB13_策略模式.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付策略管理类
 */
public class PayStrategy {
    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JdPay";
    public static final String UNION_PAY = "UnionPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> payStrategy = new HashMap<String,Payment>();
    static {
        payStrategy.put(ALI_PAY,new AliPay());
        payStrategy.put(WECHAT_PAY,new WechatPay());
        payStrategy.put(UNION_PAY,new UnionPay());
        payStrategy.put(JD_PAY,new JDPay());

        //TODO: 1. 利用配置来配置.
        //      2. SPI     jar中有 META-INF/xxx接口文件

    }
    //以上的加载是写死的代码。不灵活.
    //解决方案:  1. 采用配置文件来配置 支付类的全路径， 再使用反射方法来完成支付的加载
    //          2. 采用spi机制将各种支持打成 jar包，将配置放到 /meta-inf/xxxx

    public static Payment get(String payKey){
        if(!payStrategy.containsKey(payKey)){
            return payStrategy.get(DEFAULT_PAY);
        }
        return payStrategy.get(payKey);
    }
}
