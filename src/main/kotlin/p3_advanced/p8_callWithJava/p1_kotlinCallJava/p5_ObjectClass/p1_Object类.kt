package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p5_ObjectClass

/*
Object类

如果在Kotlin代码中引入了Java的Object类，则Object类会被映射为Kotlin的Any类。
但这两个类并不完全不相等，Any类中只声明了toString()、 hashCode()和equals()方法，
而Object类的成员方法要比这多。
为了能够使用Object类中的其他成员，需要一些特殊手段。下面分别介绍具体做法。

1. wait()/notify()/notifyAll()方法

Object类中包含传统的、用于线程同步的wait()、notify()和 notifyAll()方法。
如果要在Any对象上使用这些方法，有以下两种方式:
方式一， 使用Java同步包的await()、signal()和 signalAll()方法进行替换(强烈建议)。
方式二，在将Any类转换为Object类后调用wait()、notify()和 notifyAll()方法。
[举例]在将Any对象转换为Object类型后调用wait()方法。具体代码如下:
(foo as java. lang. Object).wait ()



2. getClass()方法

Object类的getClass()方法用于获取指定对象的Java类型。
在Kotlin中，可以通过访问扩展属性javaClass或使用反射API来实现该功能。

[举例]用扩展属性和反射API获取类的引用。具体代码如下:
//扩展属性
javaBean.javaClass
//反射API
javaBean::class.java

 */