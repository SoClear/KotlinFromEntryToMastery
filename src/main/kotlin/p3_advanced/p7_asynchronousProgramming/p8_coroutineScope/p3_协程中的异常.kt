package p3_advanced.p7_asynchronousProgramming.p8_coroutineScope

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

/*
如果协程作用域中的某一个协程抛出了异常，则整个协程作用域中的所有协程都会被取消
 */
//【举例】在一个协程中手动抛出异常。
fun main()= runBlocking {
    val job=launch {
        launch {
            println("CoroutineScope before")
            delay(700)
            throw RuntimeException()
            println("CoroutineScope after")
        }
        launch {
            println("CoroutineScope2 before")
            delay(1000)
            println("CoroutineScope2 after")
        }
    }

    job.join()
    println("主协程退出")
}

/*
输出结果如下：
CoroutineScope before
CoroutineScope2 before
Exception in thread "main" java.lang.RuntimeException
...

在这个例子中，因为在job的一个子线程中手动抛出了异常，所以整个job协程都被取消了。
 */