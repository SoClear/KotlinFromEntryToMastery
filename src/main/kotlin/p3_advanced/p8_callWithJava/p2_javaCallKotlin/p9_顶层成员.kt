package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
顶层成员
在Kotlin中，可以在类外部定义变量和函数。
这些变量和函数也被称为顶层成员或类外成员。
当一个Kotlin源文件中包含这些成员时，编译器会将该源文件编译为代表该文件的类。
这个自动生成的类的类名是原文件名后加上“Kt”。
所有顶层成员都会作为该类的静态成员。

[举例]在Java程序中，访问Kotlin脱离类存在的方法和变量。

(1)创建一个Kotlin文件，并将该文件命名为“test.kt”， 具体代码如下:
package p3_advanced.p8_callWithJava.p2_javaCallKotlin
var debug = false

fun foobar() {
    println("A function without class.")
}


(2)在Java程序中访问这两个成员，
具体代码如下:
TestKt.foobar();
boolean debug = TestKt.getDebug();

Kotlin也支持用注解@JmName修改默认生成的类名。该注解须放在源文件的最开始位置。
[举例]在Kotlin程序中修改默认创建的类名。具体代码如下:
@file:JvmName("GlobalUtils")
package p3_advanced.p8_callWithJava.p2_javaCallKotlin

var debug = false
然后就可以使用指定的类名进行访间了，具体代码如下:
GlobalUtils.foobar();

在用@JmNane注解自定义类名时，
有以下几点值得注意:
● 如果多个源文件都用@JvmName注解指定了同样的类名，则只有一个文件会被编译为类。
●如果多个源文件都用@JvmName注解指定了同样的类名，
并且这些源文件上都添加了@JvmMultifileClass注解，
则这些文件会被统一编译为个类。
所以，在这些源文件中不能存在相同签名的成员，否则会编译出错。
*/
