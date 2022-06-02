package com.yc.designpattern.DMB19_备忘录模式.DM3;

/**
 * @program: design-pattern-yc
 * @description: 文本编辑器
 * @author: zy
 * @create: 2022-05-18 10:09
 */

public class TextEditor {

    private String title;
    private String content;
    private String imgs;

    public TextEditor(String title, String content, String imgs) {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    /**
     * 保存临时状态, 生成一个备忘录对象
     * @return
     */
    public ArticleMemento saveToMemento() {
        ArticleMemento articleMemento = new ArticleMemento(this.title, this.content, this.imgs);
        return articleMemento;
    }

    /**
     * 恢复数据
     * @param articleMemento
     */
    public void undoFromMemento(ArticleMemento articleMemento) {
        this.title = articleMemento.getTitle();
        this.content = articleMemento.getContent();
        this.imgs = articleMemento.getImgs();


    }

    @Override
    public String toString() {
        return "Editor{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }
}
