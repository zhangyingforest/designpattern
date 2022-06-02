package com.yc.designpattern.DMA5_建造者模式.DM1;

/**
 * @project: design-patterns
 * @description: 游戏角色建造者, 充当抽象建造者
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    //工厂方法,返回一个完整的游戏角色对象
    public Actor createActor() {
        return actor;
    }
}
