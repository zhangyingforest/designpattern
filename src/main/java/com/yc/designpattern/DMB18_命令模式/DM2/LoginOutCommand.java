package com.yc.designpattern.DMB18_命令模式.DM2;

/**
 * @project: design-patterns
 * @description: 退出命令类, 充当具体命令类
 */
public class LoginOutCommand extends Command {

    private LoginOutSystem exitSystem;

    public LoginOutCommand() {
        this.exitSystem = new LoginOutSystem();
    }

    //命令执行方法,将调用请求接受者的业务方法
    @Override
    public void execute() {
        exitSystem.exit();
    }
}
