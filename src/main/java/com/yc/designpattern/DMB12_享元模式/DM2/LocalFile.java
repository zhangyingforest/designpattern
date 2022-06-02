package com.yc.designpattern.DMB12_享元模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 客户端的本地文件类
 */
public class LocalFile {
    private String filename;
    private String content;

    public LocalFile(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
