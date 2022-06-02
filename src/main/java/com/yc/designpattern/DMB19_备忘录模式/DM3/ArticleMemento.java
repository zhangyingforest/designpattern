package com.yc.designpattern.DMB19_备忘录模式.DM3;

/**
 * @program: design-pattern-yc
 * @description: 备忘录角色
 * @author: zy
 * @create: 2022-05-18 10:10
 */
public class ArticleMemento {
    private String title;   //文章的标题
    private String content;  //文章内容
    private String imgs;     //图片

    public ArticleMemento(String title, String content, String imgs) {
        this.title = title;
        this.content = content;
        this.imgs = imgs;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImgs() {
        return imgs;
    }

    @Override
    public String toString() {
        return "ArticleMemento{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }
}
