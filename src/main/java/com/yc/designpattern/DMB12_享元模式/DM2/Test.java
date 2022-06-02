package com.yc.designpattern.DMB12_享元模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 测试类
 * @author: 作者 huchaojie
 * @create: 2022-03-29 20:50
 */
public class Test {

    public static void main(String[] args) {
        PanServer panServer = PanServer.getInstance();

        String fileContent = "这是一个pdf文件《设计模式：从入门到放弃》";
        LocalFile localFile1 = new LocalFile("小明的设计模式.pdf", fileContent);
        String fikeKey1 = panServer.upload("小明", localFile1);

        LocalFile localFile2 = new LocalFile("大明的设计模式.pdf", fileContent);
        String fikeKey2 = panServer.upload("大明", localFile2);

        panServer.download(fikeKey1);
        panServer.download(fikeKey2);
    }

}
