package p3_advanced.p7_asynchronousProgramming.p9_debugCoroutine

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

/*
协程的上下文可以由多个上下文组合而成，所以在指定协程名字时仍然可以指定其他上下文。
 */
//【举例】在指定协程名的时使用I/O调度器
fun main () = runBlocking {
    async(CoroutineName("io-alias") + Dispatchers.IO) {
        println(Thread.currentThread().name)
    }
    async {
        println("Hello world")
    }
    println("end")
}