package com.yc.designpattern.DMB18_命令模式.DM2;

/**
 * @project: design-patterns
 * @description: 登录命令类, 充当具体命令类
 */
public class LoginInCommand extends Command {

    private LoginInSystem enterSystem;

    public LoginInCommand() {
        this.enterSystem = new LoginInSystem();
    }

    //命令执行方法,将调用请求接收者的业务方法
    @Override
    public void execute() {
        enterSystem.login();
    }
}
