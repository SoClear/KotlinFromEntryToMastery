package p3_advanced.p4_exception.p1_exceptionIntroduction

/*
异常
本章将介绍Kotlin中异常的概念和使用方法，包括创建异常、抛出异常及处理异常。

了解异常
异常是指:程序无法如预期那样运行下去。
为了描述在异常发生时的具体情况，各种编程语言都会将异常信息抽象为携带各种运行环境信息的异常类。
Kotlin沿用了Java 的异常处理机制，所有异常类都是Throwable类的子类。
但和Java不同的是，Kotlin 并没有提供检查异常的功能，所有异常都属于运行时异常，即开发者可以自行选择是否需要对异常进行捕获。

除此之外，Kotlin 还通过别名机制从Java导入两个Throwable类的子类一Error 类和Exception类。
这两个类代表着异常的两个大类:
●Error类， 表示错误(如硬件故障等)，这种异常类型通常不可恢复。
●Exception类，表示程序错误，通常可以进行恢复。本章提到的异常处理机制是指，处理Exception类的异常。
*/
