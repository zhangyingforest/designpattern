package com.yc.designpattern.DMB11_组合模式.DM2;

/**
 * @project: design-patterns
 * @description: 表示文件的类, 充当Leaf角色
 */
public class File extends Entry {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this.toString());
    }
}
