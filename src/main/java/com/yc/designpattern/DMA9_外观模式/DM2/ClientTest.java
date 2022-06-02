package com.yc.designpattern.DMA9_外观模式.DM2;

/**
 * @project: design-patterns
 * @description: 客户端测试类
 */
public class ClientTest {

    /**
     * 下面是一个使用外观设计模式的简单示例程序 : 写一个用于文件加密的模块,该模块的功能为对指定文件中的数据进行加密并将加密之后的数据保存到新的文件中.
     * 具体流程包括三个部分 : 读取源文件中的数据, 数据加密, 将加密后的数据写入到新文件
     */

    private static final String FROM_PATH = "Picture\\from.txt";
    private static final String TO_PATH = "Picture\\to.txt";

    public static void main(String[] args) {
        //只要调用门面类的方法就能完成文件内容读取， 加密的操作了，调用比一个方法一个方法的调用要简单。
        EncryptFacade encryptFacade = new EncryptFacade();
        encryptFacade.fileEncrypt(FROM_PATH, TO_PATH);
    }
}
