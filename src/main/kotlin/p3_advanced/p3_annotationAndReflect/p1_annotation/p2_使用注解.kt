package p3_advanced.p3_annotationAndReflect.p1_annotation

/*
使用注解

1.创建注解类
创建注解类只需要在类声明前添加关键字“annotation"
*/
//[举例]创建5个注解类。具体代码如下:
annotation class Bean
annotation class BeanConstructor
annotation class BeanProperty
annotation class BeanAccessor
annotation class BeanMethod

/*
2.应用注解
注解可以应用在各种位置上，包括类、属性、方法和表达式等。
在应用注解时需要在注解类名前添加“@"符号。
*/
//[举例]将在上面例子中创建的注解类Bean、BeanConstructor BeanProperty、BeanAccessor、
//BeanMethod分别添加到类、主构造方法、属性、访问器和普通方法上。具体代码如下:

//在类和主构造方法上的注解
@Bean
class Person @BeanConstructor constructor() {
    //在属性和Getter访问器上的注解
    @BeanProperty
    var age: Int = 0
        @BeanAccessor get() = field

    //在方法上的注解
    @BeanMethod
    fun sayHello(message: String) {
        println("hello $message")
    }
}

/*
从这个例子中可以看到，如果需要将注解添加到主构造方法上，则需要为主构造方法显式添加“constructor”关键字。
除上面几种位置外，注解也可以被应用在Lambda表达式上。
在这种情况下注解实际是被添加到Lambda表达式内置的invoke()方法上了。
*/
//[举例]创建注解类，并将其应用在Lambda表达式上。具体代码如下:
//创建注解类
annotation class Closure

//将注解类应用在Lambda表达式上
val f = @Closure { i: Int ->
    i * 100
}
