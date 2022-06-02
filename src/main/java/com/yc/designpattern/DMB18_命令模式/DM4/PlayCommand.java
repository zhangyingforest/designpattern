package com.yc.designpattern.DMB18_命令模式.DM4;

/**
 * @program: design-pattern-yc
 * @description: 创建操作播放器可以接收的指令
 * @author: zy
 * @create: 2022-05-17 12:25
 */
public class PlayCommand implements Command{
    private  VideoPlayer videoPlayer;

    public PlayCommand(VideoPlayer videoPlayer) {
        this.videoPlayer = videoPlayer;
    }

    @Override
    public void execute() {
        videoPlayer.play(); //播放指令
    }
}

