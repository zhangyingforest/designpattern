package com.yc.designpattern.DMB17_责任链.DM2.chain;

/**
 * 具体处理者角色，开发经理 3天的权限
 */
public class DevManager extends Leader {

    public DevManager(String name) {
        super(name);
    }


    @Override
    public void handlerRequest(int days) {
        if (days <= 3) {
            System.out.println("开发经理已审批你的请假条，休假天数：" + days + "天");
        } else {
            if(superior != null){
                superior.handlerRequest(days);   //职责链的调用.
            }else{
                System.out.println("请假天数太大，已拒绝审批");
            }
        }
    }
}
