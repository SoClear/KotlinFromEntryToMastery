package p3_advanced.p7_asynchronousProgramming.p7_coroutineContextAndCoroutineDispatcher

import kotlinx.coroutines.*
import p3_advanced.p3_annotationAndReflect.p1_annotation.Constant.n
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/*
协程上下文与协程调度器
本节将介绍协程上下文和协程调度器的概念和使用方法。

1
上下文与调度器
在Kotlin 中，接口CoroutineContext 代表协程上下文。
协程上下文控制了协程的实际运行环境。
每个协程的上下文中都有一个协程调度器。
协程调度器决定了执行协程的具体线程或线程池。

所有协程构建器(比如launch()方法)在创建时都包含一个协程上下文类型的参数，
通过该参数可以为协程分配不同的调度器。
如果在使用协程构建器时没有指定具体的上下文，则上下文为当前协程作用域中的上下文。

除在创建协程时指定协程的上下文外，在协程内部可以用withContext()函数切换上下文，
该函数会挂起当前协程然后在新的上下文中执行代码块，执行完后返回原来的上下文，同时被挂起的协程将恢复执行。
 */
//【举例】通过指定的协程上下文来使用不同的协程调度器
fun main() = runBlocking {
    //不指定上下文
    val job1=launch {
        println("运行在主协程中，线程名： ${Thread.currentThread().name}")
    }

    //使用非受限调度器
    val job2=launch (Dispatchers.Unconfined){
        println("Unconfined，线程名：${Thread.currentThread().name}")
    }

    //使用默认调度器
    val job3=launch (Dispatchers.Default){
        println("Default，线程名：${Thread.currentThread().name}")
    }

    //自定义线程池
    val executor:ExecutorService = Executors.newSingleThreadExecutor{
        Thread("thread-11")
    }
    //通过扩展方法将线程池转换为调度器
    val dispatcher: CoroutineDispatcher = executor.asCoroutineDispatcher()
    val job4=launch(dispatcher) {
        println("newSingleThreadContext，线程名：${Thread.currentThread().name}")
    }

    joinAll(job1,job2,job3,job4)
    executor.shutdown()
}

/*
输出结果如下：
Unconfined，线程名：main
Default，线程名：DefaultDispatcher-worker-1
运行在主协程中，线程名： mai

运行在主协程中,线程名: main从这个例子中可以看到:
. job1 没有指定上下文,所以其上下文对象为 runBlocking()函数中的上下文对象。
. job2 指定了基于非受限调度器的上下文。
. job3 指定了基于默认调度器的上下文。
. job4 指定了以自定义的线程池为运行环境的上下文。在使用完线程池后需要将其主动关闭，否则会造成资源浪费。

 */