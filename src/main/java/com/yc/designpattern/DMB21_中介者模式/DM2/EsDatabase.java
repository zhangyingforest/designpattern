package com.yc.designpattern.DMB21_中介者模式.DM2;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: design-pattern-yc
 * @description: Elasticsearch ，只需要同步到Mysql
 * 具体中介者
 */
public class EsDatabase implements AbstractDatabase {

    private List<String> dataset = new CopyOnWriteArrayList<String>();

    //具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互
    private MysqlDatabase mysqlDatabase;
    @Override
    public void addData(String data) {
        System.out.println("ES 添加数据：" + data);
        this.dataset.add(data);
    }

    @Override
    public void add(String data) {
        addData(data);
        this.mysqlDatabase.addData(data);   // 维护同步到MySQL的同步作业
    }

    //统计方法
    public void count() {
        int count = this.dataset.size();
        System.out.println("- Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
    }


    public void setMysqlDatabase(MysqlDatabase mysqlDatabase) {
        this.mysqlDatabase = mysqlDatabase;
    }
}
