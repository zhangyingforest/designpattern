package com.yc.designpattern.DMA6_适配器模式.DM2;

/**
 * 真实的播放设备。 它默认可以播放mpe, 但它包括一个适配器,以支持其它音乐格式的播放.
 */
public class AudioPlayer implements MediaPlayer {
   MediaAdapter mediaAdapter; 
 
   @Override
   public void play(String audioType, String fileName) {
      //内置支持播放 mp3 音乐文件的
      if(audioType.equalsIgnoreCase("mp3")){
         System.out.println("开始播放mp3: "+ fileName);
      } else if(audioType.equalsIgnoreCase("vlc")
         || audioType.equalsIgnoreCase("mp4")){
         //mediaAdapter 提供了播放其他文件格式的支持
         mediaAdapter = new MediaAdapter(audioType);
         mediaAdapter.play(audioType, fileName);
      }
      else{
         System.out.println("Invalid media. "+
            audioType + " format not supported");
      }
   }   
}