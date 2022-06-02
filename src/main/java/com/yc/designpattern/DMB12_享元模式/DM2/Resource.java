package com.yc.designpattern.DMB12_享元模式.DM2;

/**
 * @program: design-pattern-yc
 * @description: 资源类
 */
public class Resource {
    private String hashId;   //资源内容的 hash值，用于map中的键，以去重
    private int byteSize;    //大小
    private String content;   //真实内容

    public Resource(String content) {
        this.content = content;
        this.hashId = HashUtil.computeHashId(content);   // 文件的hash值
        this.byteSize = content.length();
    }
    // ....getter、setter、toString...

    public String getHashId() {
        return hashId;
    }

    public void setHashId(String hashId) {
        this.hashId = hashId;
    }

    public int getByteSize() {
        return byteSize;
    }

    public void setByteSize(int byteSize) {
        this.byteSize = byteSize;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "hashId='" + hashId + '\'' +
                ", byteSize=" + byteSize +
                ", content='" + content + '\'' +
                '}';
    }
}
