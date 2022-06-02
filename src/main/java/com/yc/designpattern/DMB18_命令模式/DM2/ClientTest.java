package com.yc.designpattern.DMB18_命令模式.DM2;

/**
 * @project: design-patterns
 * @description: 客户端测试类
 */
public class ClientTest {

    /*
    某系统提供了一系列功能键,用户可以自定义功能键( FunctionButton )的功能,

    例如登录键( LoginInCommand )用于登录系统,退出键( LoginOutCommand )用于注销系统 · · ·
     */

    public static void main(String[] args) {
        FunctionButton functionButton = new FunctionButton();
        Command login_key = new LoginInCommand();
        functionButton.setCommand(login_key);
        functionButton.click();

        System.out.println("--------------------");

        Command exit_key = new LoginOutCommand();
        functionButton.setCommand(exit_key);
        functionButton.click();
    }
}
