package com.yc.designpattern.DMA6_适配器模式.DM2;

/**
 * 播放适配器: 在这里完成根据文件格式适配不同播放器的功能
 */
public class MediaAdapter implements MediaPlayer {
   //真实的目标类
   AdvancedMediaPlayer advancedMusicPlayer;

   //在这里完成根据不同的格式，转换不同的播放器的功能
   public MediaAdapter(String audioType){
      if(audioType.equalsIgnoreCase("vlc") ){
         advancedMusicPlayer = new VlcPlayer();       
      } else if (audioType.equalsIgnoreCase("mp4")){
         advancedMusicPlayer = new Mp4Player();
      }  
   }

   //不同的音乐格式调用不同的播放方法.
   @Override
   public void play(String audioType, String fileName) {
      if(audioType.equalsIgnoreCase("vlc")){
         advancedMusicPlayer.playVlc(fileName);
      }else if(audioType.equalsIgnoreCase("mp4")){
         advancedMusicPlayer.playMp4(fileName);
      }
   }
}