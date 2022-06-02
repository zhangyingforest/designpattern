package com.yc.designpattern.DMA1_工厂方法.factory.simplefactory1;


import com.yc.designpattern.DMA1_工厂方法.factory.JavaCourse;

/**
 * 小作坊式的工厂模型
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {

        CourseFactory cf=new CourseFactory();
        JavaCourse jc= (JavaCourse) cf.create(JavaCourse.class);
        System.out.println( jc );

    }
}
