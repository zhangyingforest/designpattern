package com.yc.designpattern.DMA1_工厂方法.doc;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-04-18 09:43
 */
public class Test_other {
    public static void main(String[] args) {
        Calendar c=Calendar.getInstance();


        ILoggerFactory lf= LoggerFactory.getILoggerFactory();
        //简单工厂
        Logger logger=lf.getLogger( Test_other.class.getName() );
        logger.info("hello");
    }
}
