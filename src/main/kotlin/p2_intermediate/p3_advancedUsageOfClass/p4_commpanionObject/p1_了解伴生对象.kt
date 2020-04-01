package p2_intermediate.p3_advancedUsageOfClass.p4_commpanionObject

/*
伴生对象(Companion Object)是一种使用
“companion”关键字作为前缀修饰、定义在类中的单例对象。
伴生对象在声明时可以省略类名，此时Kotlin 会使用“Companion” 作为该伴生对象的默认类名。
一个类只能有一个伴生对象。
 */

//[举例]创建AlrDialog类，在该类内部创建一个伴生对象Factory。具体代码如下:
class AlertDialog(var title: String, var message: String) {
    //伴生对象
    companion object Factory {
        fun test() {}
    }
}
/*
在访问伴生对象的成员时，既可以像嵌套类那样使用完整的类名，也可以省略伴生对象的类名直接使用外部类名。
*/

fun main() {
    //[举例]访问单例对象的成员。具体代码如下:
    //方法一，通过伴生对象的完整类名调用方法
    AlertDialog.Factory.test ()
    //方法二，省略伴生对象类名，通过外部类名调用伴生对象中的方法
    AlertDialog.test ()
    /*
    在这个例子中，test()方法只定义在伴生对象中，外部类中并不存在同样签名的方法。
    那如果在外部类中也创建一个test()方法，此时两者会产生冲突吗?
    实际上，如果发生这种情况，则通过类名调用的就是伴生对象中的方法，
    通过类的实例调用的就是外部类中定义的方法。
    */
}