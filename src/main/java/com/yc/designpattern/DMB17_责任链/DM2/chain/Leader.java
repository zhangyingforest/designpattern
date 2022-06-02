package com.yc.designpattern.DMB17_责任链.DM2.chain;

/**
 * 抽象处理者角色，领导
 */
public abstract class Leader {

    /**
     * 领导职称
     */
    protected String name;
    /**
     *  **** 上级领导
     */
    protected Leader superior;

    public Leader(String name){
        this.name = name;
    }


    /**
     * 设置上级领导
     * @param superior
     */
    public void setSuperior(Leader superior){
        this.superior = superior;
    }


    /**
     * 领导审批请假条，由子类重写该方法实现具体的审批逻辑
     * @param days 请假天数
     */
    public abstract void handlerRequest(int days);

}
