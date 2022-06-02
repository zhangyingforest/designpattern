package com.yc.designpattern.DMB11_组合模式.DM1;

/**
 * 测试类
 */
public class CompositePatternDemo {
   public static void main(String[] args) {
      Employee CEO = new Employee("John","CEO", 30000);
 
      Employee headSales = new Employee("Robert","Head Sales", 20000);
      Employee headMarketing = new Employee("Michel","Head Marketing", 20000);
 
      Employee clerk1 = new Employee("Laura","Marketing", 10000);
      Employee clerk2 = new Employee("Bob","Marketing", 10000);
 
      Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
      Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

      //CEO的下一级
      CEO.add(headSales);
      CEO.add(headMarketing);
      // 销售主管的下一级
      headSales.add(salesExecutive1);
      headSales.add(salesExecutive2);
      //市场主管的下一级
      headMarketing.add(clerk1);
      headMarketing.add(clerk2);
 
      //打印该组织的所有员工
      System.out.println(CEO); 
      for (Employee headEmployee : CEO.getSubordinates()) {
         System.out.println("\t"+headEmployee);
         for (Employee employee : headEmployee.getSubordinates()) {
            System.out.println("\t\t"+employee);
         }
      }        
   }
}