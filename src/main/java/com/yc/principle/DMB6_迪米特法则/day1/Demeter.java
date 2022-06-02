package com.yc.principle.DMB6_迪米特法则.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: design-pattern-yc
 * @description: 迪米特法则
 * 基本介绍
 * 1、一个对象应该对其他对象保持最少的了解。
 * 2、类与类关系越密切，耦合度越大。
 * 3、迪米特法则(Demeter Principle)又叫最少知道原则，即一个类对自己依赖的类知道的越少越好 。
 也就是说，对于被依赖的类不管多么复杂，都尽量将逻辑封装在类的内部。对外除了提供的 public 方法，不对外泄露任何信息。
 * 4、迪米特法则还有个更简单的定义：只与直接的朋友通信。
 * 5、直接的朋友：每个对象都会与其他对象有耦合关系，只要两个对象之间有耦合关系，我们就说这两个对象之间是朋友关系。
               耦合的方式很多，依赖，关联，组合，聚合等。
              其中，我们称出现成员变量，方法参数，方法返回值中的类为直接的朋友，而出现在局部变量中的类不是直接的朋友。
            也就是说，陌生的类最好不要以局部变量的形式出现在类的内部。
 */
public class Demeter {
    /**
     * 有一个学校，下属有各个学院CollegeManager和总部SchoolManager，
     现要求打印出学校总部员工 Employee的ID 和学院员工CollegeEmployee的 id，

     *
     * 在SchoolManager的打印方法printAllEmployee()中，
     * CollegeEmployee以局部变量(不是直接朋友)的形式出现在了SchoolManager类的内部，违反了迪米特法则
     */

    public static void main(String[] args) {
        //创建了一个 SchoolManager 对象
        SchoolManager schoolManager = new SchoolManager();
        //输出学院的员工id 和 学校总部的员工信息
        schoolManager.printAllEmployee(new CollegeManager());
    }
}

/**
 * 学校总部员工类
 */
class Employee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
/**
 * 学院的员工类
 */
class CollegeEmployee {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
/**
 * 管理学院员工的管理类
 */
class CollegeManager {
    //返回学院的所有员工
    public List<CollegeEmployee> getAllEmployee() {
        List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
        for (int i = 0; i < 10; i++) { //这里我们增加了10个员工到 list
            CollegeEmployee emp = new CollegeEmployee();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }


}
/**
 * 学校管理类
 * 分析 SchoolManager 类的直接朋友类有Employee(方法返回值)、
 *
 * 而CollegeManager 是   方法参数
 * CollegeEmployee 是  局部变量 不是直接朋友 而是一个陌生类，这样违背了迪米特法则
 */
class SchoolManager {
    //返回学校总部的员工
    public List<Employee> getAllEmployee() {
        List<Employee> list = new ArrayList<Employee>();

        for (int i = 0; i < 5; i++) { //这里我们增加了5个员工到 list
            Employee emp = new Employee();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    /**
     * 该方法完成输出学校总部和学院员工信息(id)
     */
    void printAllEmployee(CollegeManager sub) {
        /**
         * 分析问题
         * 1. 这里的 CollegeEmployee(局部变量) 不是 SchoolManager的直接朋友
         * 2. CollegeEmployee 是以局部变量方式出现在 SchoolManager
         * 3. 违反了迪米特法则
         */
        //获取到学院员工
        List<CollegeEmployee> list1 = sub.getAllEmployee();
        System.out.println("------------学院员工------------");
        for (CollegeEmployee e : list1) {
            System.out.println(e.getId());
        }
        //获取到学校总部员工
        List<Employee> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee e : list2) {
            System.out.println(e.getId());
        }
    }
}

