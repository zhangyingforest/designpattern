package com.yc.designpattern.DMA3_单例模式.singleton.seriable4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @program: design-pattern-yc
 * @description: 序例化破坏单例
 * @author: zy
 * @create: 2022-04-21 11:31
 */
public class Test1_serialize_error {
    public static void main(String[] args) {
        SeriableSingleton s1=null;

        SeriableSingleton s2=SeriableSingleton.getInstance();

        try(FileOutputStream fos=new FileOutputStream(   "seriableSingleton.obj"  );
            ObjectOutputStream oos=new ObjectOutputStream(   fos ) ){
            oos.writeObject(   s2 );
            oos.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("序列化完成");


        try(
                FileInputStream fis=new FileInputStream(   "seriableSingleton.obj");
                ObjectInputStream ois=new ObjectInputStream( fis );
                ){
            s1=(SeriableSingleton)ois.readObject();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(   s1+"\t"+s2);
    }
}
