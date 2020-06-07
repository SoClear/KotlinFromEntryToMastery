package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p10_JNI

/*
在Java中，JNI是指在Java类中仅声明无方法体的本地方法，方法的具体逻辑由本地语言(C或C++)来实现。
如果Kotlin需要使用JNI,则需要将方法用external进行修饰，其余使用过程和Java相同。

[举例]在Kotlin中定义一个本地方法。具体代码如下:
external fun sum(x: Int, y: Int) : Int

 */