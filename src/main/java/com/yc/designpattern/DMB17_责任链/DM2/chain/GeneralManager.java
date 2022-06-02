package com.yc.designpattern.DMB17_责任链.DM2.chain;

/**
 * 具体处理者角色，总经理   14的权限
 */
public class GeneralManager extends Leader {

    public GeneralManager(String name) {
        super(name);
    }


    @Override
    public void handlerRequest(int days) {
        if (days <= 14) {
            System.out.println("总经理已审批你的请假条，休假天数：" + days + "天");
        } else {
            if(superior != null){
                superior.handlerRequest(days);
            }else{
                System.out.println("请假天数太大，已拒绝审批");
            }
        }
    }
}
