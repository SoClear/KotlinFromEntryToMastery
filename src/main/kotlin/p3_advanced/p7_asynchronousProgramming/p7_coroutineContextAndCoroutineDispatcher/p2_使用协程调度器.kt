package p3_advanced.p7_asynchronousProgramming.p7_coroutineContextAndCoroutineDispatcher

import kotlinx.coroutines.*

/*
使用协程调度器
Kotlin中一共有以下几种协程调度器:
(1) Dispatchers.Default
(2) Dispatchers.Unconfined
(3) Dispatchers.Main
(4) Dispatchers.IO
(5) 自定义的协程调度器

(1) Dispatchers.Default
默认的协程调度器。如果在协程的上下文中没有指定调度器，则程序会使用此调度器启动协程。
默认的协程调度器在底层使用JVM环境的工作窃取线程池ForkJoinPool来调度协程，
默认的并行度与运行程序的CPU核数相同(最小值为2)。
(2) Dispatchers.Unconfined
不受限的协程调度器，通俗地讲就是:不指定具体执行线程的协程调度器。
在用该调度器启动协程时，协程会在调用处所在的线程中被执行。
如果在执行过程中该协程被挂起，则在恢复执行时该协程会执行在挂起函数所在的线程中。

*/
//[举例]使用不受限的协程调度器。具体代码如下:
fun main () = runBlocking {
    val job1=launch {
        println("主协程调度器：${Thread.currentThread().name}")
        delay(1000)
        println("主协程调度器中恢复${Thread.currentThread().name}")
    }

    val job2=launch(Dispatchers.Unconfined) {
        println("Unconfined调度器：${Thread.currentThread().name}")
        delay(500)
        println("Unconfined调度器中恢复：${Thread.currentThread().name}")
    }

    joinAll(job1,job2)
}
/*
输出结果如下：
Unconfined调度器：main
主协程调度器：main
Unconfined调度器中恢复：kotlinx.coroutines.DefaultExecutor
主协程调度器中恢复main


(3) Dispatchers.Main
依赖于平台实现的协程调度器，对于Android平台就是UI线程。

(4) Dispatchers.IO
主要用于后台I/O操作的协程调度器，并行度为“CPU的核数”和64这两者中的更大的值

(5) 自定义的协程调度器
自行创建线程池，并调用线程池对象的扩展方法asCoroutineDispatcher()获得自定义的协程调度器
 */