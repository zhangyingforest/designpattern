package com.yc.designpattern.DMA6_适配器模式.DM2;

/**
 * 此处，不同的播放类实现接口中的不同功能
 */
public class VlcPlayer implements AdvancedMediaPlayer{
   @Override
   public void playVlc(String fileName) {
      System.out.println("Playing vlc file. Name: "+ fileName);      
   }
 
   @Override
   public void playMp4(String fileName) {
      //什么也不做
   }
}