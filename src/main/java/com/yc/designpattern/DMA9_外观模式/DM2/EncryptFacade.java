package com.yc.designpattern.DMA9_外观模式.DM2;

/**
 * @project: design-patterns
 * @description: 加密外观类, 充当外观类
 */
public class EncryptFacade {

    //维持对子系统对象的引用
    private FileReader fileReader;
    private CipherMachine cipherMachine;
    private FileWriter fileWriter;

    public EncryptFacade() {
        fileReader = new FileReader();
        cipherMachine = new CipherMachine();
        fileWriter = new FileWriter();
    }

    //对外提供的门面方法，  调用子系统对象的业务方法
    public void fileEncrypt(String fromPath, String toPath) {
        String text = fileReader.read(fromPath);
        System.out.println(">>>>>>>>>> : 读取文件[ " + fromPath + " ]中的明文数据 : " + text);
        String encryptStr = cipherMachine.encrypt(text);
        System.out.println(">>>>>>>>>> : 明文数据加密后的结果 : " + encryptStr);
        fileWriter.write(encryptStr, toPath);
    }
}
