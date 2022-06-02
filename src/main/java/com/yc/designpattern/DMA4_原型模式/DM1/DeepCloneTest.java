package com.yc.designpattern.DMA4_原型模式.DM1;


public class DeepCloneTest {

    public static void main(String[] args) {

        QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

        try {
            QiTianDaSheng clone = (QiTianDaSheng)qiTianDaSheng.clone();
            System.out.println(   "克隆:"+   clone);
            System.out.println(     qiTianDaSheng );
            //原型模式下对象创建了两次,但值 一样.
            System.out.println(   "hashcode:  " +  clone.hashCode()+"\t"+ qiTianDaSheng.hashCode() );
            //jingubang是一个引用型， 对于浅克隆.
            System.out.println(  "jingubang的hashcode: "+ clone.jinGuBang.hashCode() +"\t"+   qiTianDaSheng.jinGuBang.hashCode() );


          //  System.out.println("判断克隆结果,如两个jinGuBang对象相同，则为浅克隆，如不同，则为深克隆：" + (qiTianDaSheng.jinGuBang == clone.jinGuBang));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        QiTianDaSheng q = new QiTianDaSheng();
//        QiTianDaSheng n = q.shallowClone(q);
//        System.out.println("浅克隆：" + (q.jinGuBang == n.jinGuBang));


    }
}
