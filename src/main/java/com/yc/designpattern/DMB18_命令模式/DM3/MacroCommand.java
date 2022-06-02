package com.yc.designpattern.DMB18_命令模式.DM3;

import java.util.Stack;

/**
 * @project: design-patterns
 * @description: 表示"由多条命令整合成的命令"的类,充当具体的命令
 */
public class MacroCommand implements Command {

    //命令的集合
    private Stack commands = new Stack();

    //执行命令
    @Override
    public void execute() {
        for (Object command : commands) {
            if(   command instanceof Command ) {
                ((Command) command).execute();
            }
        }
    }

    //添加命令
    public void append(Command command) {
        if (command != this) {
            commands.push(command);
        }
    }

    //清除命令
    public void clear() {
        commands.clear();
    }

}
