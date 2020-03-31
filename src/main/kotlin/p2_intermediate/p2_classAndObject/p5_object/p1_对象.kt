package p2_intermediate.p2_classAndObject.p5_object

/*
1.了解对象————类的具体实现
类是一种抽象的概念，而对象是类的具体实现。
对象创建自类，拥有类的所有成员：类可以看做是创建对象的模板。

2.创建对象
在java中，创建对象，需要通过“new”关键字来实现。
而在kotlin中，直接用类名加上小括号即可。
 */
//【举例】创建两个来自于类（人类）的对象（你、我）
//类：人类
class Human{
    var age=0
    fun growUp(){
        age++
    }
}

fun main() {
    //创建对象
    val you= Human()
    val me= Human()

    /*
    you和me两个对象都来自于Human这个类，所以，“you”和“me”自然也拥有了Human类中定义的age属性和growUp()方法。

    在kotlin中，对象可以通过点“.”符号来访问类中定义的属性和方法。
     */

    you.growUp()
    you.growUp()
    you.growUp()

    me.growUp()

    println("you 的年龄是${you.age}")
    println("me 的年龄是${me.age}")
}