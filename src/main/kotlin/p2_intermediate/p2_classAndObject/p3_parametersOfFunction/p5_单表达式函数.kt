package p2_intermediate.p2_classAndObject.p3_parametersOfFunction

/*
单表达式函数是指，整个函数由一个表达式构成。
在这种情况下，kotlin提供了以下特殊的语法糖来简化函数声明。
可以省略表示函数体的大括号，但是需要在函数体前加上等号。
可以省略返回值类型，编译器能通过单表达式推断出返回值的数据类型。
返回值不需要也不能添加“return”关键字。
 */
//【举例】（1）声明一个用于获取参数绝对值的函数。
fun abs(x: Int): Int {
    return if (x > 0) x else -x
}

//用单表达式函数重写这个函数
fun abs1(x: Int) = if (x > 0) x else -x

/*
这里需要注意，单表达式函数是指只有一个表达式，而不是指只有一行语句。
所以分成两行写也没有问题。
 */

fun abs2(x: Int) = if (x > 0) x
                    else -x