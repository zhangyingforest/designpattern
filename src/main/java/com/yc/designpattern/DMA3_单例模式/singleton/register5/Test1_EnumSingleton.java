package com.yc.designpattern.DMA3_单例模式.singleton.register5;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @program: design-pattern-yc
 * @description: 枚举式单例
 * @author: zy
 * @create: 2022-04-21 09:33
 */
public class Test1_EnumSingleton {
    public static void main(String[] args) {
        EnumSingleton1 s1=null;
        EnumSingleton1 s2=EnumSingleton1.getInstance();
        try(FileOutputStream fos=new FileOutputStream(   "EnumSingleton1.obj"  );
            ObjectOutputStream oos=new ObjectOutputStream(   fos ) ){
            oos.writeObject(   s2 );
            oos.flush();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("序列化完成");
        try(
                FileInputStream fis=new FileInputStream(   "EnumSingleton1.obj");
                ObjectInputStream ois=new ObjectInputStream( fis );
        ){
            s1=(EnumSingleton1)ois.readObject();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(   s1+"\t"+s2);
        System.out.println(   s1==s2);
    }
}
