package com.yc.designpattern.DMA1_工厂方法.factory.factorymethod2;


import com.yc.designpattern.DMA1_工厂方法.factory.ICourse;
import com.yc.designpattern.DMA1_工厂方法.factory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {

    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
