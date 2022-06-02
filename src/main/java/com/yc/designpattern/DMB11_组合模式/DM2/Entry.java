package com.yc.designpattern.DMB11_组合模式.DM2;

/**
 * @project: design-patterns
 * @description: 表示目录条目的抽象类, 充当Component角色
 */
public abstract class Entry {

    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatMentException {
        throw new FileTreatMentException();  //对于文件而言，是没有下一级的，所以add时抛异常.
        //在Directory类中可以有这个方法，所以要重写
    }

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}