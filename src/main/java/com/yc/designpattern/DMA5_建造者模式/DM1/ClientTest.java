package com.yc.designpattern.DMA5_建造者模式.DM1;

/**
 * @project: design-patterns
 * @description: 客户端测试类
 */
public class ClientTest {

    /**
     * 下面是一个使用了建造者设计模式的简单示例程序,其概述为 : 无论是何种游戏角色,都需要逐步创建其组成部分,再将各组成部分配装成一个完整的游戏角色
     */

    public static void main(String[] args) {
        ActorController actorController = new ActorController();

        ActorBuilder zero = new HeroBuilder();
        Actor actor_zero = actorController.construct(zero);
        System.out.println(actor_zero);

        System.out.println("------------------------------");

        ActorBuilder angel = new AngelBuilder();
        Actor actor_angel = actorController.construct(angel);
        System.out.println(actor_angel);
    }
}
