package p3_advanced.p1_extensionAndDelegation.p1_extension

/*
2.扩展方法
扩展方法相当于为类添加一个定义在类外部的成员方法，所以声明一个扩展方法的方法和声明一个类中的方法非常类似，
只是此时需要在方法名前添加该方法的接收者(即方法的拥有者)类型。
*/
//[举例]为Num类添加一个扩展方法。
//(1)创建包含一个整型类型的Num类，具体代码如下:
class Num(var x: Int)

//(2)对该类进行扩展，添加一个扩展方法add(), 在打展方法中可以用“this"关键字获得该扩展方法的实际接收者对象，具体代码如下:
fun Num.add(y: Int) {
// this表示接收者，即调用该方法的Num类的对象
    this.x += y
}

//(3)测试-下该扩展方法，具体代码如下:
/*
fun main() {
    var num = Num(10)
    //调用扩展方法
    num.add(4)
    // 输出14
    println(num.x)
}
*/


/*

如果扩展方法的签名和在类中已经定义过的方法的签名完全一致，则此时实际调用的总是A类中定义的方法。
*/
//[举例]在A类的内部和外部各定义一个test()方法，然后分别调用这两个方法。具体代码如下:

class A {
    //类内部的test()方法
    fun test() {
        println("A类中定义的方法")
    }
}

//类外部的test()方法
fun A.test() {
    println("扩展方法")
}
//调用test()方法

fun main() {
    A().test()
}
/*
输出结果如下:
A类中定义的方法
*/
