package com.yc.designpattern.DMA6_适配器模式.DM2;

/**
 * 播放接口:　
 */
public interface AdvancedMediaPlayer {
   /**
    * 播放vlc
    * @param fileName
    */
   public void playVlc(String fileName);

   /**
    * 播放mp4
    * @param fileName
    */
   public void playMp4(String fileName);
}