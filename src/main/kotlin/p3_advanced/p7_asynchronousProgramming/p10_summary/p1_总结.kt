package p3_advanced.p7_asynchronousProgramming.p10_summary

/*
本章有以下重点:

●一个应用程序由多个进程组成。
●一个进程由多个线程组成。
●一个线程由多个协程组成。
●多线程是Java中异步编程的解决方案。
●多协程是Kotlin中异步编程的解决方案。
●协程只能定义在协程的作用域中。
●协程由协程构建器创建。
●协程上下文决定了协程的运行环境和恢复环境。
●协程调度器决定了执行协程的具体线程。
●Job和Deferred代表运行中的协程，后者可以携带协程的运行结果。
●协程间存在父子关系，父协程可以控制子协程。

Kotlin从1.3版本正式引入协程，
但在目前协程库中还有许多特性都属于实验阶段，其中包括Scala语言中常用到的Channel和Actor等。
在之后的版本中，这些特性可能会发生很大改变，所以暂不对它们进行介绍，感兴趣的读者可以自行阅读官方相关文档，
但建议在实际项目中还是不要引入这些实验阶段的特性。
 */