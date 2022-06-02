package com.yc.designpattern.DMA1_工厂方法.factory.factorymethod2;


import com.yc.designpattern.DMA1_工厂方法.factory.ICourse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//工厂方法模式
public class FactoryMethodTest {

    public static void main(String[] args) {

        ICourseFactory factory = new PythonCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new JavaCourseFactory();
        course = factory.create();
        course.record();


        List l=new ArrayList();
        List ll=new LinkedList();
        ll.iterator();

    }

}
