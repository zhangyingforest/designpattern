package com.yc.designpattern.DMA5_建造者模式.doc;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * @program: design-pattern-yc
 * @description: 构造器模式源码分析
 * @author: zy
 * @create: 2022-04-22 12:25
 */
public class Test1_builder {
    public static void main(String[] args) {
        //JDK 的 StringBuilder 类中提供了 append() 方法，这就是一种链式创建对象的方法，开放构造步骤，
        // 最后调用 toString() 方法就可以获得一个完整的对象

       StringBuilder sb=new StringBuilder();

       sb.append("abc").append("efg").append("hij").append("lmn");
       sb.toString();
        /**
         public final class StringBuilder extends AbstractStringBuilder implements java.io.Serializable, CharSequence {
         ...
             public StringBuilder append(Object obj) {
                return append(String.valueOf(obj));
             }
             ...
             public String toString() {
                // Create a copy, don't share the array
                return new String(value, 0, count);
             }
         ...
         }
         */

        /*
        MyBatis 中 SqlSessionFactoryBuiler 类用到了建造者模式。
        且在 MyBatis 中 SqlSessionFactory是由 SqlSessionFactoryBuilder 产生的
         */
        SqlSessionFactoryBuilder sfb;

        useDateFormatter();

        /*
        public SqlSessionFactory build(InputStream inputStream, String environment, Properties properties) {
    try {
      XMLConfigBuilder parser = new XMLConfigBuilder(inputStream, environment, properties);


      return build(parser.parse());  //请查看这里 XMLConfigBuilder中的 parse()方法 是如何完成构造器模式的.

    } catch (Exception e) {
      throw ExceptionFactory.wrapException("Error building SqlSession.", e);
    } finally {
      ErrorContext.instance().reset();
      try {
        inputStream.close();
      } catch (IOException e) {
        // Intentionally ignore. Prefer previous error.
      }
    }
  }
        在上面这个方法中创建  DefaultSqlSessionFactory这个对象时，这个对象有很多属性要设置，所以用构造器模式来完成的.
         */

        /*
        还有以前用过的   mybatisplus中的条件组装器
         */



    }

    //日期格式化类, 也采用了构造器模式
    private static void useDateFormatter() {
        DateFormat df;
        LocalDate date = LocalDate.of(2022, 4, 24);
        // 生成线程安全的日期格式化对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.FRANCE);

        System.out.println(    date.format(    DateTimeFormatter.ISO_LOCAL_DATE   )    ); // 默认格式化
        System.out.println(    date.format(formatter)    );
        System.out.println(    date.format(italianFormatter)    );
        // 自定义一个更复杂的 DateTimeFormatter对象
        // 设计模式： 构建器
        DateTimeFormatter complexFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.CHINESE);

        System.out.println(date.format(complexFormatter));



    }

}
