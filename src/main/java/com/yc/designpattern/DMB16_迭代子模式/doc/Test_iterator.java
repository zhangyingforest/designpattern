package com.yc.designpattern.DMB16_迭代子模式.doc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @program: design-pattern-yc
 * @description: iterator的应用
 * @author: zy
 * @create: 2022-05-16 09:40
 */
public class Test_iterator {
    public static void main(String[] args) {
        List list=new ArrayList();
        Iterator ite= list.iterator();

        new HashSet();

       // DefaultCursor dc=new DefaultCursor();

    }
}
/*
                                  Collection接口
             List                                                    Set
   ArrayList  LinkedList,  Vector                       HashSet  TreeSet
   数组,按下标
              链表:
                 循环链表
                             数组,按下标


   Collection接口: 集合;  Iterator<E> iterator()





 */
