package p2_intermediate.p2_classAndObject.p1_theConceptAndUseOfFunction

/*
语法：
[访问控制符] fun 函数名(参数列表)[:返回值类型]{
    函数体
}
注：[]代表可以省略
函数命名方式：小驼峰
参数列表由0个或多个参数构成。多个参数间用逗号“,”分开。
在声明参数时，参数名放在前面，参数类型放在后面，并且用冒号“:”分开
 */

fun print(s:String):String{
    println("$s")
    return s
}

fun main() {
    print("Hello fun")
}