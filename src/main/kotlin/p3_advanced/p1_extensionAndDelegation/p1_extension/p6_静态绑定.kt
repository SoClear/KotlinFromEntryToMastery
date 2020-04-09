package p3_advanced.p1_extensionAndDelegation.p1_extension

/*
6 静态绑定

将任意扩展方法绑定到实际接收者类型的过程采用的是静态绑定的方式，
即: 在调用扩展方法时，接收者类型为调用者的声明类型，而不是程序运行时的实际类型。
*/
//[举例]验证静态绑定功能。
//(1) 创建一个A1类和它的子类B1类，具体代码如下:
open class A1
class B1 : A1()

//(2) 分别为A1类和B1类添加一个扩展方法test()，具体代码如下:
fun A1.test() {
    println("A")
}

fun B1.test() {
    println("B")
}

//(3)在这两个类外各添加一个print()方法，该方法会调用传入参数的test()方法，具体代码如下:
fun print(a: A) {
    a.test()
}

fun main() {
    val b1=B1()
    //输出结果 A
    println(b1)
}
/*
从这个例子中可以看到，虽然print()方法的形参为A类型的数据，但是实际调用该方法的实参b1为B1类型的数据。
由于test()方法是一个扩展方法，所以print()方法中的test()方法的绑定对象就是该参数的声明类型————A1 类。
 */

