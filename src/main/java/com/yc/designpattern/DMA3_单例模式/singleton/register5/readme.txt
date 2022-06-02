将每个实例都登记到某一个地方,使用唯一标识获取实例.
有两种形式：
1. 枚举式单例    EnumSingleton1
2. 容器式单例    ContainerSingleton2


分析：
jad工具安装 :  https://blog.csdn.net/qq_37175706/article/details/122446419

先分析枚举式单例.

再看容器式单例:  容器式单例适用于实例非常多的情况，便于管理，但它非线程安全的。

spring中采用的就是这种容器式单例模式.