package com.yc.designpattern.DMB18_命令模式.DM4;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-05-17 12:26
 */
public class PauseCommand implements Command{
    private VideoPlayer videoPlayer;

    public PauseCommand(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void execute() {
        videoPlayer.pause();  //暂停指令
    }
}

