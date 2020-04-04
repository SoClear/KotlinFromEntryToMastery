package p2_intermediate.p3_advancedUsageOfClass.p6_dataClass.p1_dataClassIntroduction

/*
数据类(Data) 是Kotlin中一种用“data”关键字作为前缀修饰的特殊类，它的主要功能是携带数据。
和普通类相比，数据类在定义时会基于在主构造方法中定义的属性自动创建一些内置方法。
使用数据类可以简单地实现领域模型编程中的贫血模型。

提示:
贫血模型( Anemic Domain Model)是一种除Setter方法和Getter方法外，
不包含任何业务方法的数据模型。
在Java应用程序中常用的Java Bean就是一种非常典型的贫血模型。
 */