package p3_advanced.p2_advancedUseOfFunctions.p4_inlineFunction

import kotlin.concurrent.thread

/*
   本地返回与非本地返回
   在调用函数时，如果该函数包含return 语句，那么程序执行到该语句时会退出该函数并返回到调用处，这种方式也被称作本地返回(或局部返回)。
   而内联函数由于是被直接复制到了调用处，所以调用return语句时可以直接退出调用处，这种方式也被称作非本地返回(或非局部返回)。
   在非本地返回时，由于是直接返回调用处， 所以即使是Lambda表达式也不用显式写明返回的作用域。
   */

//[举例]在Lambda表达式中退出函数执行。具体代码如下:
inline fun traverse(list: List<Any>, f: (Any) -> Unit) {
    for (item in list) {
        println("应用$item")
        f(item)
    }
}

/*
fun main() {
    println("执行内联函数之前")
    traverse(listOf(1, 2, 3)) {
        if (it == 2) {
            return
        }
    }
    println("执行内联函数之后")
}
*/

/*
输出结果如下:
执行内联函数之前
应用1
应用2


在这个例子中，当traverse()函数的Lambda表达式中遍历到数字2时，
就会退出该函数的执行过程，所以在数字3没有被遍历到时程序就停止执行了。

如果内联函数包含函数类型的变量，则该函数类型参数有可能不在当前环境中被立即执行，
而是被放到其他环境(比如新线程中)延迟执行。
此时由于上下文已经改变，所以无法(也不应该)在函数类型参数的内部用return 语句控制流程。

为了提醒由此造成的错误调用，此时应该用crossinline 修饰该函数类型参数，
这样如果在函数类型内部使用return 语句，则编译器会直接报错。
*/
//[举例]用crossinline修饰内联函数的参数。具体代码如下:
inline fun applyList(list: List<Int>, crossinline f: (Int) -> Unit) {
    thread {
        for (item in list) {
            f(item)
        }
    }
}


fun main() {
    applyList(listOf(1, 2, 3)) {
        if (it % 2 == 0) {
            //下面这段话会直接报错
            //return
        }
        println("应用奇数: $it")
    }
}

