package com.yc.designpattern.DMA4_原型模式.DM1;


import java.io.*;
import java.util.Date;


public class QiTianDaSheng extends Monkey implements Cloneable,Serializable {

    public JinGuBang jinGuBang;

    Object obj;

    public  QiTianDaSheng(){
        //只是初始化
        this.birthday = new Date();
        this.jinGuBang = new JinGuBang();
    }

    //将原来的浅克隆改为深克隆.
    @Override
    protected Object clone() throws CloneNotSupportedException {
      //  return super.clone();
      // return this.shallowClone(this);   //浅克隆
        return this.deepClone();   //深克隆
    }

    //利用对象流完成深克隆,       还有一种麻烦的实现: 递 归.
    /*
        深复制把要复制的对象所引用的对象都复制了一遍。
        拷贝需要实现Cloneable, Serializable两个接口，重写clone方法
     */
    public Object deepClone(){
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            oos.flush();

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            QiTianDaSheng copy = (QiTianDaSheng)ois.readObject();
            copy.birthday = new Date();
            return copy;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    //浅克隆
    public QiTianDaSheng shallowClone(QiTianDaSheng target){
        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();
        qiTianDaSheng.height = target.height;
        qiTianDaSheng.weight = target.weight;
        //浅克隆对对象类型的数据只克隆了地址，没有复制值
        qiTianDaSheng.jinGuBang = target.jinGuBang;    //对于引用型的数据，只克隆了地址.
        qiTianDaSheng.birthday = new Date();
        return  qiTianDaSheng;
    }

    @Override
    public String toString() {
        return "QiTianDaSheng{" +
                "jinGuBang=" + jinGuBang +
                ", height=" + height +
                ", weight=" + weight +
                ", birthday=" + birthday +
                '}';
    }
}