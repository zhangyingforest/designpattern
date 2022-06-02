package com.yc.designpattern.DMA5_建造者模式.DM1;

/**
 * @project: design-patterns
 * @description: 英雄角色建造者, 充当具体建造者
 */
public class HeroBuilder extends ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("英俊");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }
}
