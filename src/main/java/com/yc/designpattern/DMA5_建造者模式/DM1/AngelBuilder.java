package com.yc.designpattern.DMA5_建造者模式.DM1;

/**
 * @project: design-patterns
 * @description: 天使角色建造者, 充当具体建造类
 */
public class AngelBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex("女");
    }

    @Override
    public void buildFace() {
        actor.setFace("漂亮");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("裙子");
    }
}
