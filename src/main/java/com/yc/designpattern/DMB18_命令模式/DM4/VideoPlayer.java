package com.yc.designpattern.DMB18_命令模式.DM4;

/**
 * @program: design-pattern-yc
 * @description: 创建播放器内核类
 * @author: zy
 * @create: 2022-05-17 12:24
 */

public class VideoPlayer {

    public void play() {
        System.out.println("正常播放");
    }

    public void speed() {
        System.out.println("拖动进度条");
    }

    public void stop() {
        System.out.println("停止播放");
    }

    public void pause() {
        System.out.println("暂停播放");
    }
}
