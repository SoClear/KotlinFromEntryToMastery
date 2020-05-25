package p3_advanced.p7_asynchronousProgramming.p5_suspendFunction

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
挂起函数是使用"suspend"关键字修饰的函数。挂起函数只能运行在协程的作用域中，或者被其他挂起函数调用。
除此之外，试图调用挂起函数都会引起编译错误。

在调用挂起函数时可能会挂起当前的协程，但是该协程所在线程并不会被阻塞。
挂起函数和普通函数一样都是顺序执行的。

Kotlin类库中的所有挂起函数被取消后都会抛出CancellationException异常，所以它们可以被用在希望立即取消协程执行的场景。
 */
//【举例】创建一个挂起函数request()，并在协程作用域中调用该函数。
fun main()= runBlocking {
    //measureTimeMillis函数计算了代码块的执行时间
    val duration= measureTimeMillis {
        //调用挂起函数
        getNumber1()
        getNumber2()
    }
    println(duration)
}

suspend fun getNumber1():Int{
    delay(1000)
    return 1
}

suspend fun getNumber2():Int{
    delay(2000)
    return 2
}