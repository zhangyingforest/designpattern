package com.yc.designpattern.DMB18_命令模式.DM2;

/**
 * @project: design-patterns
 * @description: 功能键类, 充当请求调用者(请求发送者)
 */
public class FunctionButton {

    private Command command;

    //为功能键注入命令
    public void setCommand(Command command) {
        this.command = command;
    }

    //发送请求的方法
    public void click() {
        command.execute();
    }

}
