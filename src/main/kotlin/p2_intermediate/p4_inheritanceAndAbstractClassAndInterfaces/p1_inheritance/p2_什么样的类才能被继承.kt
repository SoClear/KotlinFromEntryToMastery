package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p1_inheritance

/*
什么样的类才能被继承
在Java语言中，所有类默认都可以被继承。
而在Kotlin语言正好相反，所有类默认都隐式被“final”关键字修饰。
该关键字修饰在类上表示类无法被继承。
为了实现继承功能，需要执行以下两个步骤:
(1)在父类声明语句的最前面加上“open”关键字。该关键字修饰在类上，表示类可以被继承。
(2)在子类声明语句后面加上冒号(:)和父类类型。
需要注意的是:和Java 样，Kotlin也采用的是单维承方式，即每个子类只能同时继承一个父类
 */