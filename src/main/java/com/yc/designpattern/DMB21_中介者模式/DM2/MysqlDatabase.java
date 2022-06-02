package com.yc.designpattern.DMB21_中介者模式.DM2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-yc
 * @description: Mysql 数据库   中介者
 */
public class MysqlDatabase implements AbstractDatabase {

    //TODO:将来是数据库..
    private List<String> dataset = new ArrayList<String>();

    //待同步的库:   同事的角色
    private RedisDatabase redisDatabase;
    private EsDatabase esDatabase;

    //TODO:向自身添加数据，  因为当前类是ｍｙｓｑｌ，所以将来是数据库操作．
    @Override
    public void addData(String data) {
        System.out.println("Mysql 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
        this.redisDatabase.addData(data);   // 维护同步到Redis的同步作业
        this.esDatabase.addData(data);  // 维护同步到Elasticsearch的同步作业
    }

    //查询方法
    public void select() {
        System.out.println("- Mysql 查询，数据：" + this.dataset.toString());
    }


    public void setRedisDatabase(RedisDatabase redisDatabase) {
        this.redisDatabase = redisDatabase;
    }

    public void setEsDatabase(EsDatabase esDatabase) {
        this.esDatabase = esDatabase;
    }
}

