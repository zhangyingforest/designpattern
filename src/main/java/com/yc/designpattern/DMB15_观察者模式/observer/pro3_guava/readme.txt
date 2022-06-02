guava提供的一个观察者模式的实现.

   EventBus( 相当于Observable):  主题类/被观察者
              1. 观察者列表
              2。 post(  状态变化值 ) 通知方法，循环观察者列表，通知变更
   eventBus.register(pojo类); :    接口   ->观察者类
            1. 一定有一个回调处理  @Subscribe