package com.yc.designpattern.DMB21_中介者模式.DM2;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: design-pattern-yc
 * @description: Redis 数据库
 */
public class RedisDatabase implements AbstractDatabase {
    private List<String> dataset = new LinkedList<String>();

    @Override
    public void addData(String data) {
        System.out.println("Redis 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data); // 不同步到其它数据库
    }

    //缓存方法
    public void cache() {
        System.out.println("- Redis 缓存的数据：" + this.dataset.toString());
    }
}
