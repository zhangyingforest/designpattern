package com.yc.designpattern.DMB17_责任链.DM2;


import com.yc.designpattern.DMB17_责任链.DM2.chain.*;

/**
 * 责任链模式测试代码
 */
public class TestForChain {

    /**
     * 模拟请假系统
     * @param args
     */
    public static void main(String[] args) {
        Leader devManager = new DevManager("开发经理");
        Leader departmentManager = new DepartmentManager("部门经理");
        Leader generalManager = new GeneralManager("总经理");

        devManager.setSuperior(departmentManager);
        departmentManager.setSuperior(generalManager);

        //员工向开发经理请假5天,注意查看审批流程
       // devManager.handlerRequest(5);
//        //员工向开发经理请假30天,注意查看审批流程
//        devManager.handlerRequest(30);
//
//        System.out.println("=====================================");
//
//        //再增加一个具体处理者(老板)
        Leader boss = new Boss("老板");
        generalManager.setSuperior(boss);
//
//        //请假5天
//        devManager.handlerRequest(5);
//        //请假30天
//        devManager.handlerRequest(30);
//        //请假129天
        devManager.handlerRequest(128);
    }
}
