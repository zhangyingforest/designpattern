package com.yc.designpattern.DMB19_备忘录模式.DM3;

import java.util.Stack;

/**
 * @program: design-pattern-yc
 * @description: 备忘录管理角色_ 草稿箱
 * @author: zy
 * @create: 2022-05-18 10:11
 */
public class Drafts {
    /**
     * Stack类有以下方法:
     * boolean empty()	判断堆栈是否为空
     * Object peek()	查看堆栈顶部的对象，但不从堆栈中移除它
     * Object pop()	移除堆栈顶部的对象，并作为此函数的值返回该对象
     * Object push(Object element)	把对象压入堆栈顶部
     * int search(Object element)	返回对象在堆栈中的位置，以1为基数
     */
    private final Stack<ArticleMemento> STACK = new Stack<ArticleMemento>();

    /**
     * 用于恢复memento对象
     * @return
     */
    public ArticleMemento getMemento() {
        ArticleMemento articleMemento = STACK.pop();   //从栈顶取出元素且删除它.
        return articleMemento;
    }

    public void addMemento(ArticleMemento articleMemento) {
        STACK.push(articleMemento);
    }
}
