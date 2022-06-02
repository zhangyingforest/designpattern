package com.yc.designpattern.DMB18_命令模式.DM4;

/**
 * @program: design-pattern-yc
 * @description: 进度条拖动
 * @author: zy
 * @create: 2022-05-17 12:26
 */
public class SpeedCommand implements Command{
    private VideoPlayer videoPlayer;

    public SpeedCommand(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void execute() {
        videoPlayer.speed();  //拖动进度条指令
    }
}

