package com.yc.designpattern.DMB19_备忘录模式.DM3;

/**
 * @program: design-pattern-yc
 * @description:
 * @author: zy
 * @create: 2022-05-18 10:13
 */
public class Test {
    public static void main(String[] args) {
        Drafts Drafts = new Drafts();  //草稿箱(集合，用于存备忘录对象)


        TextEditor TextEditor = new TextEditor("Java设计模式", "23种设计模式", "1.png");
        //生成备忘录，用于保存
        ArticleMemento articleMemento = TextEditor.saveToMemento();
        //存到草稿箱
        Drafts.addMemento(articleMemento);

        System.out.println("标题：" + TextEditor.getTitle() + "\n" + "内容：" + TextEditor.getContent() + "\n" + "插图：" + TextEditor.getImgs() + "\n暂存成功");
        System.out.println("完整信息" + TextEditor);

        System.out.println("==========首次修改文章===========");
        TextEditor.setTitle("首次修改文章  Java设计模式：23种设计模式全面解析");
        TextEditor.setContent("首次修改文章 23种设计模式全面解析");
        System.out.println("==========首次修改文章完成===========");
        System.out.println("完整信息" + TextEditor);
        articleMemento = TextEditor.saveToMemento();
        Drafts.addMemento(articleMemento);
        System.out.println("==========保存到草稿箱===========");

        System.out.println("==========第2次修改文章===========");
        TextEditor.setTitle("第2次修改文章 Java设计模式：23种设计模式全面解析（超级详细）");
        TextEditor.setContent(" 第2次修改文章 Java设计模式");
        System.out.println("完整信息" + TextEditor);
        System.out.println("==========第2次修改文章完成===========");

        System.out.println("==========第1次撤销===========");
        articleMemento = Drafts.getMemento();
        TextEditor.undoFromMemento(articleMemento);
        System.out.println("完整的信息" + TextEditor);
        System.out.println("==========第1次撤销完成===========");

        System.out.println("==========第2次撤销===========");
        articleMemento = Drafts.getMemento();
        TextEditor.undoFromMemento(articleMemento);
        System.out.println("完整的信息" + TextEditor);
        System.out.println("==========第2次撤销完成===========");
    }
}
