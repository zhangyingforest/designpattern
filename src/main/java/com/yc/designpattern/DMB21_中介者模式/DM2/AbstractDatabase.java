package com.yc.designpattern.DMB21_中介者模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 抽象数据库接口
 * 抽象中介者
 */
public abstract interface AbstractDatabase {

    /**
     * 添加数据的方法
     * 此方法对外提供调用
     * @param data
     */
    public abstract void add(String data);

    /**
     * 向本身库添加数据库的方法
     * @param data
     */
     abstract void addData(String data);

}
