package p3_advanced.p2_advancedUseOfFunctions.p3_lambdaExpressions

/*
2 隐式参数it
如果可以从当前上下文推断出参数类型，则Lambda 表达式的参数类型可以被省略。
如果处于这种情况下的Lambda表达式只包含一个参数时，则参数声明本身也可以被省略，
此时在Lambda表达式内部可以通过隐式参数it来获得传入的实参的值。
*/

//[举例]创建两个Lambda表达式，一个 省略了参数类型，另.个省略了参数声明。 具体代码如下:
fun main() {
    //因为指定了函数类型，所以可以省略参数类型
    val double: (Int) -> Int = { i -> i * 2 }
    //输出: 6
    println(double(3))
    //因为只包含一个参数且参数类型在上下文中可见，所以可以省略参数声明
    val triple: (Int) -> Int = { it * 3 }
    //输出: 9
    println(triple(3))
}
