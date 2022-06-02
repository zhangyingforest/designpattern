package com.yc.designpattern.DMB17_责任链.DM2.chain;

/**
 * 具体处理者角色，部门经理  7天的权限
 */
public class DepartmentManager extends Leader {

    public DepartmentManager(String name) {
        super(name);
    }


    @Override
    public void handlerRequest(int days) {
        if (days <= 7) {
            System.out.println("部门经理已审批你的请假条，休假天数：" + days + "天");
        } else {
            if(superior != null){
                superior.handlerRequest(days);
            }else{
                System.out.println("请假天数太大，已拒绝审批");
            }
        }
    }
}
