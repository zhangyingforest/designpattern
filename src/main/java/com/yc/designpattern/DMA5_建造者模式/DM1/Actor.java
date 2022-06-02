package com.yc.designpattern.DMA5_建造者模式.DM1;

/**
 * @project: design-patterns
 * @description: 游戏角色类, 充当复杂产品对象
 */

public class Actor {

    private String type="a"; //角色类型
    private String sex="男"; //性别
    private String face="方形"; //脸型
    private String costume="beauty"; //服装

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getCostume() {
        return costume;
    }

    public void setCostume(String costume) {
        this.costume = costume;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "type='" + type + '\'' +
                ", sex='" + sex + '\'' +
                ", face='" + face + '\'' +
                ", costume='" + costume + '\'' +
                '}';
    }
}