package p3_advanced.p7_asynchronousProgramming.p8_coroutineScope

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
在一个协程中启动另一个和原协程拥有相同作用域的新协程时，新协程就和原协程形成了父子关系。
父子协程在使用时有以下几个特点：
●取消副协程可以立即取消子协程
●子协程中发生异常会导致父协程被取消。
●可以进取消子协程而不影响父协程。
●在调用父协程的join()方法后，父协程会等待所有的子协程执行完毕。

但是，通过GlobalScope启动的协程运行在一个独立的作用域中，所以其和外部的协程是没有父子关系的。
 */
//【举例】取消子协程和使用GlobalScope创建的协程。
fun main()= runBlocking {
    val job=launch {
        //用GlobalScope启动线程
        GlobalScope.launch {
            println("GlobalScope before")
            delay(1000)
            println("GlobalScope after")
        }

        //运行在runBlocking()所在的协程作用域中
        launch {
            println("Coroutine before")
            delay(1000)
            println("Coroutine after")
        }
    }

    delay(500)
    job.cancel()
    delay(1000)
    println("主协程退出")
}
/*
输出结果如下：
Coroutine before
GlobalScope before
GlobalScope after
主协程退出

从这个例子中可以看到，调用了job协程的cancel()方法后，其子协程launch()中定义的代码没有被执行完毕就退出了。
而GlobalScope创建的协程虽然定义在job所有的代码块中，但是因为运行在不同的作用域中，所有仍然被完整执行了。
 */