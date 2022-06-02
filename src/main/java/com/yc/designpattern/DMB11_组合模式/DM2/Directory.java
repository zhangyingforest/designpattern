package com.yc.designpattern.DMB11_组合模式.DM2;

import java.util.ArrayList;

/**
 * @project: design-patterns
 * @description: 表示文件夹的类, 充当Composite角色
 */
public class Directory extends Entry {

    private String name;
    //子节点的列表
    private ArrayList<Entry> directory = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    //计算它的下一级节点的总大小.
    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : directory) {
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this.toString());
        for (Entry entry : directory) {
            entry.printList(prefix + "/" + name);
        }
    }
}
