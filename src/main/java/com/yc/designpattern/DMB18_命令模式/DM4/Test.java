package com.yc.designpattern.DMB18_命令模式.DM4;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-05-17 12:27
 */

public class Test {
    public static void main(String[] args) {
        // 控制条可以执行单挑命令也可以批量执行多条命令
        VideoPlayer player = new VideoPlayer();

        Controller controller = new Controller();
        controller.execute(new PlayCommand(player));

        System.out.println("======一次性执行批处理=====");
        controller.addCommand(new PauseCommand(player));
        controller.addCommand(new PlayCommand(player));
        controller.addCommand(new StopCommand(player));
        controller.addCommand(new SpeedCommand(player));

        controller.executes();


    }
}
