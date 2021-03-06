设计模式之单一职责原则（Open Close Principle）

一个类只负责一项职责，不要存在 1 个以上导致类发生变更的原因。

优点：
    a. 降低类的复杂度，一个类只负责一项职责，逻辑简单清晰；
    b. 类的可读性，系统的可维护性更高；
    c. 因需求变更引起的风险更低，降低对其它功能的影响。

总结和注意事项

1、降低类的复杂度，一个类只负责一项职责。
2、提高类的可读性， 可维护性
3、降低变更引起的风险
4、通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级违反单一职责原则，
        只有类中方法数量足够少，可以在方法级别保持单一职责原则