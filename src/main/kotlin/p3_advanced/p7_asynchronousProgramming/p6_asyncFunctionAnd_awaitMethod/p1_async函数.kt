package p3_advanced.p7_asynchronousProgramming.p6_asyncFunctionAnd_awaitMethod

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
async()函数和await()方法是实际工程中最常使用的协程函数

1.async()函数
async()函数的完整签名如下
pubic fun <T> CoroutineScope.async(
    context:CoroutineContext=EmptyCoroutineContext,
    start:CoroutineStart=CoroutineStart.DEFAULT,
    block:suspend CoroutineScope.() -> T
):Deferred<T>

其中的参数说明如下：
context————协程上下文
start————协程启动选项。默认值为CoroutineStart.DEFAULT，表示创建协程后立即启动该协程。
block————在协程上下文中执行的具体代码块。
    async()函数类似于launch()函数，也是用于启动一个新协程。两者的区别是：
    launch()函数返回的是不带任何返回值的Job类的对象。
    async()函数返回的是Deferred类的对象。Deferred类是Job类的子类，可以用来获取协程执行的结果

如果多个任务之间没有依赖关系，则可以使用async()函数异步执行这些任务来提高程序执行的效率
 */
//【举例】用async函数并发调用两个没有依赖关系的挂起函数
fun main()= runBlocking {
    val duration= measureTimeMillis {
        val acton1=async { getNumber1() }
        val acton2=async { getNumber2() }
        println(acton1.await() + acton2.await())
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

/*
输出结果如下：
3
2021

和launch()方法一样，如果在调用async()方法时指定了协程启动选项为CoroutineStart.LAZY，则需要手动调用start()方法启动该异步任务。
 */