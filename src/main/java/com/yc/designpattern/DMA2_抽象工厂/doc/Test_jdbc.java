package com.yc.designpattern.DMA2_抽象工厂.doc;

import java.sql.Connection;
import java.sql.Driver;

/**
 * @program: design-pattern-yc
 * @description: jdbc中的抽象工厂的实现
 * @author: zy
 * @create: 2022-04-21 08:37
 */
public class Test_jdbc {
    public static void main(String[] args) {
        Driver d;
        Connection con;

        //Class.forName("");
      //Connection就是那个超级工厂，在它里面负责产生  子工厂:Statement, PreparedStatement, CallableStatement工厂．
     //  Connection con= DriverManager.getConnection("");



        //DriverManager.registerDriver(new Driver());
    }
}
