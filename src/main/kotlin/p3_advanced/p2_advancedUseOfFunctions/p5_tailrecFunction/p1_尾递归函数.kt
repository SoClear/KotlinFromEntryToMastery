package p3_advanced.p2_advancedUseOfFunctions.p5_tailrecFunction

/*
每次调用函数时，虚拟机都会在函数调用栈上创建一个新的函数栈帧并保留现场，
在函数返回时会弹出栈帧恢复现场。
如果该函数是递归函数(函数调用自身)，则可能会出现不停地创建新栈帧，最后造成栈溢出的问题。
即使没有出现这种问题，不停创建栈帧对于性能来说也是一种很大的消耗。
尾递归函数可以将递归函数的调用过程优化为循环，
这样执行尾递归函数就变成了在一个循环体中执行代码，性能得到很大的提高。

在Kotlin中，可以用"tailrec" 关键字声明个尾递归函数。
*/
//[举例]创建一个尾递归函数。 具体代码如下:
tailrec fun factorialTail(n: Int, result:Int = 1): Int {
    if (n == 1) {
        return result
    }
    return factorialTail(n-1, result*n)
}
/*
不是所有递归函数都能被声明为尾递归函数。
尾递归函数要求:函数的最后一个语句只能是调用该函数自身的语句，语句中不能出现任何运算符。
所以，如果将上面最后行改为“ return factorialTail(n-1, result*n)* 1”，
则该函数依然是普通的递归函数，编译器无法对其进行优化。
*/
