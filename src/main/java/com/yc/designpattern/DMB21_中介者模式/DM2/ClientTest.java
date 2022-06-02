package com.yc.designpattern.DMB21_中介者模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 测试客户端
 */
public class ClientTest {


    /*
   规则 说明: 有三种数据库 Mysql、Redis、Elasticsearch，
    其中的 Mysql 作为主数据库，当增加一条数据时需要同步到另外两个数据库中；
    Redis 作为缓存数据库， 当增加一条数据时不需要同步到另外另个数据库；
    而 Elasticsearch 作为大数据查询数据库，有一个统计功能，当增加一条数据时只需要同步到 Mysql
     */

    public static void main(String[] args) {

        MysqlDatabase mysqlDatabase = new MysqlDatabase();
        RedisDatabase redisDatabase = new RedisDatabase();
        EsDatabase esDatabase = new EsDatabase();
        // Mysql 作为主数据库，当增加一条数据时需要同步到另外两个数据库中；
        mysqlDatabase.setRedisDatabase(redisDatabase);
        mysqlDatabase.setEsDatabase(esDatabase);
        //elasticsearch 作为大数据查询数据库，有一个统计功能count()，当增加一条数据时只需要同步到 Mysql
        esDatabase.setMysqlDatabase(mysqlDatabase);

        System.out.println("\n---------mysql 添加数据 1，将同步到Redis和ES中-----------");
        mysqlDatabase.add("1");
        //测试  mysql添加数据后，对其它两个库的影响
        mysqlDatabase.select();
        redisDatabase.cache();
        esDatabase.count();

        System.out.println("\n---------Redis添加数据 2，将不同步到其它数据库-----------");
        redisDatabase.add("2");
        //测试 redis 添加数据后，对其它两个库的影响

        redisDatabase.cache();
        mysqlDatabase.select();
        esDatabase.count();


        System.out.println("\n---------ES 添加数据 3，只同步到 Mysql-----------");
        esDatabase.add("3");

        esDatabase.count();
        mysqlDatabase.select();
        redisDatabase.cache();

    }

}
