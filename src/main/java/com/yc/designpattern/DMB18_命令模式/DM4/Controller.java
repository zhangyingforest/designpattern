package com.yc.designpattern.DMB18_命令模式.DM4;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-yc
 * @description: 遥控器
 * @author: zy
 * @create: 2022-05-17 12:27
 */
public class Controller {
    private List<Command> Commands = new ArrayList<>();

    public void addCommand(Command Command) {
        Commands.add(Command);
    }

    public void execute(Command Command) {
        Command.execute();
    }

    public void executes() {
        for (Command Command: Commands) {
            Command.execute();
        }
        Commands.clear();
    }
}

