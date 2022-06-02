package com.yc.designpattern.DMA9_外观模式.DM2;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @project: design-patterns
 * @description: 文件保存类, 充当子类系统类
 */
public class FileWriter {

    public void write(String encryptStr, String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(encryptStr.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}