package com.yc.designpattern.DMA6_适配器模式.DM2;

/**
 * 播放设备接口.
 */
public interface MediaPlayer {
   /**
    * 根据不同的音频格式进行播放
    * @param audioType
    * @param fileName
    */
   public void play(String audioType, String fileName);
}