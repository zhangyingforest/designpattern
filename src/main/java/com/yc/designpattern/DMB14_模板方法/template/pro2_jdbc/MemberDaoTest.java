package com.yc.designpattern.DMB14_模板方法.template.pro2_jdbc;

import com.yc.designpattern.DMB14_模板方法.template.pro2_jdbc.dao.MemberDao;

import java.util.List;


public class MemberDaoTest {

    public static void main(String[] args) {

        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
