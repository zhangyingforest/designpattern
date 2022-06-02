package com.yc.designpattern.DMA1_工厂方法.factory.simplefactory1;


import com.yc.designpattern.DMA1_工厂方法.factory.ICourse;

public class CourseFactory {
      //简单工厂 实现方案一:   通过  if...else判断完成
//    public ICourse create(String name){
//        if("java".equals(name)){
//            return new JavaCourse();
//        }else if("python".equals(name)){
//            return new PythonCourse();
//        }else {
//            return null;
//        }
//    }

      // //简单工厂 实现方案二:   通过 反射 判断对象创建
    public ICourse create(String className){
        try {
            if (!(null == className || "".equals(className))) {
                return (ICourse) Class.forName(className).newInstance();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    //简单工厂 实现方案三:   通过 class对象完成对象创建.
    public ICourse create(Class<? extends ICourse> clazz){
        try {
            if (null != clazz) {
                return clazz.newInstance();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
