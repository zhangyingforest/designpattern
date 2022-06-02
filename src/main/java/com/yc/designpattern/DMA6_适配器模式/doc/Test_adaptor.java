package com.yc.designpattern.DMA6_适配器模式.doc;

import org.springframework.aop.framework.adapter.AdvisorAdapter;

import java.io.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-04-25 09:34
 */
public class Test_adaptor {
    public static void main(String[] args) throws FileNotFoundException {
        //java核心库中的适配器
        List l1=java.util.Arrays.asList(   new int[]{1,2,4}   );

       // java.util.Collections#enumeration()
        Enumeration enu=Collections.enumeration(   l1 );

        // java.util.Collections.list(l1);
        List l2= Collections.list(  enu  );

       // java.io.InputStreamReader(InputStream) （返回 Reader对象）
        Reader iis=new InputStreamReader( new FileInputStream(  new File("d:\\a.txt")));

        //java.io.OutputStreamWriter(OutputStream) （返回 Writer对象）
        Writer writer=new OutputStreamWriter(    new FileOutputStream(new File("d:\\a.txt")));

        //spring中AOP的适配器类: 请看文档:  适配器在spring源码中的使用.docx
        AdvisorAdapter aa;
        //MethodBeforeAdviceAdapter mbaa;

        //springMVC中的适配器: 请看文档:  适配器在spring源码中的使用.docx

    }
}
