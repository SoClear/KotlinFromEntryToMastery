package p3_advanced.p7_asynchronousProgramming.p8_coroutineScope

/*
协程必须定义在协程作用域（CoroutineScope）中，这也是为什么不能直接在main()函数中创建协程的原因

协程作用域和协程上下文的大致关系如下：
协程作用域CoroutineScope
    协程上下文CoroutineContext
        协程调度器CoroutineDispatcher

在每个协程作用域都有一个协程上下文。在每个上下文中都有一个协程调度器。
 */