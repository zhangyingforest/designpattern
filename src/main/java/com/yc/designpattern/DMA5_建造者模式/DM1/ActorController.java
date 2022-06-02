package com.yc.designpattern.DMA5_建造者模式.DM1;

/**
 * @project: design-patterns
 * @description: 角色控制器, 充当指挥者
 */
public class ActorController {

    //逐步构建复杂产品对象
    public Actor construct(ActorBuilder actorBuilder) {
        Actor actor;
        actorBuilder.buildType();
        actorBuilder.buildSex();
        actorBuilder.buildFace();
        actorBuilder.buildCostume();
        actor = actorBuilder.createActor();
        return actor;
    }
}
