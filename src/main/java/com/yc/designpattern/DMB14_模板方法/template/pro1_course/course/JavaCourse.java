package com.yc.designpattern.DMB14_模板方法.template.pro1_course.course;


public class JavaCourse extends NetworkCourse {
    @Override
    void checkHomework() {
        System.out.println("检查Java的架构课件");
    }
}
