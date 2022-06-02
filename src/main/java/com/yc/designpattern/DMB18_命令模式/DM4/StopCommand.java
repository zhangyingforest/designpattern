package com.yc.designpattern.DMB18_命令模式.DM4;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-05-17 12:26
 */
public class StopCommand implements Command{
    private VideoPlayer videoPlayer;

    public StopCommand(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void execute() {
        videoPlayer.stop(); //停止播放
    }
}

