package com.yc.designpattern.DMA9_外观模式.DM2;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @project: design-patterns
 * @description: 文件读取类, 充当子系统类

 */
public class FileReader {

    public String read(String path) {
        StringBuilder stringBuffer = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int data = 0;
            while ((data = fileInputStream.read()) != -1) {
                stringBuffer.append((char) data); //char
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
