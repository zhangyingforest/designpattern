package com.yc.designpattern.DMB11_组合模式.DM2;

/**
 * @project: design-patterns
 * @description: 自定义异常类
 */
public class FileTreatMentException extends RuntimeException {

    public FileTreatMentException() {

    }

    public FileTreatMentException(String msg) {
        super(msg);
    }
}
