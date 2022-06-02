在电商平台中，一个订单会有多种状态，临时单、已下单、待支付、已支付、待发货、待收货、已完成等等。
每一种状态都和变化前的状态以及执行的操作有关。

比如，用户将商品加入购物车后，后台会生成一个所谓的“临时单”。因为用户还没有点击下单，所以这个订单实际上还没有生成。
只有当用户下单后，这个“临时单”才会转化为一个“待支付的订单”。

以上过程中只有将一个处于“临时单”状态的订单执行下单操作，才能得到一个状态为“待支付”的订单。
即一个前置状态+一个恰当的操作，才能流转订单的状态。在这个过程中如果使用硬编码，我们就需要一系列的 if-else 语句来检查订单的当前状态、
可执行操作以及这两个组合得到的下一个应该被流转的状态值。如果订单的状态流转很复杂，代码逻辑就会很复杂，可读性低，后期维护困难。

前置态  + 操作(事件触发)  + 后置态

if(  前置态1?? ){
    操作1
    修改成后置态2.
}else if( 前置态2?? ){
    操作2
    修改成后置态3.
}

 WAIT_PAYMENT      WAIT_DELIVER         WAIT_RECEIVE       FINISH
              PAYED             DELIVERY             RECEIVED
              发消息              发消息                 发消息
              处理                 处理                 处理
              用户                 物流                 用户

处理以上问题，我们可以使用状态设计模式来处理。对应到实践，就是   状态机。

状态机是状态模式的一种应用框架，相当于上下文角色的一个升级版。
在****工作流或游戏等各种系统中有大量使用，如各种工作流引擎，它几乎是状态机的子集和实现，封装状态的变化规则。
状态机可以帮助开发者简化状态控制的开发过程，让状态机结构更加层次化。

Spring 提供了一个很好的解决方案，Spring Statemachine(状态机)是应用程序开发人员在 Spring 应用程序中使用状态机概念的框架。


   spring版本:  <spring.version>5.3.20</spring.version>
   　　　　
   　　　　　<dependency>
             <groupId>org.springframework.statemachine</groupId>
             <artifactId>spring-statemachine-core</artifactId>
             <version>3.2.0</version>
         </dependency>

            <dependency>
                     <groupId>org.springframework.boot</groupId>
                     <artifactId>spring-boot-starter</artifactId>
                     <version>2.7.0</version>
                 </dependency>
