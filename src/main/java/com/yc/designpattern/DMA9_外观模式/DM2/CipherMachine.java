package com.yc.designpattern.DMA9_外观模式.DM2;

/**
 * @project: design-patterns
 * @description: 数据加密类(求模运算), 充当子系统类
 */
public class CipherMachine {

    public String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            String s = String.valueOf(text.charAt(i) % 7);
            result.append(s);
        }
        return result.toString();
    }
}
