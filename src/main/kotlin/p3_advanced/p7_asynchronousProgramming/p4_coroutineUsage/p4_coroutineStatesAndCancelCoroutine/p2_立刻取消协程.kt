package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p4_coroutineStatesAndCancelCoroutine

import kotlinx.coroutines.*

/*
如果需要立即停止协程有以下两种方法：（1）在协程执行过程中穿插状态检查逻辑。（2）调用yield()函数

（1）在协程执行过程中穿插状态检查逻辑。
 */
//【举例】在while循环中，检查协程是否是isActive状态，如果不是则退出while循环
fun main() = runBlocking {
    val startTime=System.currentTimeMillis()
    val job=launch (Dispatchers.Default){
        var nextPrintTime=startTime
        var i=0
        //当协程状态为_Canceling_时退出循环
        while (isActive && i<15){
            if (System.currentTimeMillis() >= nextPrintTime){
                println("休眠${i++}次")
                nextPrintTime+=500
            }
        }
    }
    delay(10)
    println("协程取消")
    //cancel()方法将协程状态由_Active_变成了_Canceling_。
    job.cancel()
    println("主协程执行完毕")
}
/*
输出结果如下：

休眠0次
协程取消
主协程执行完毕
 */


/*
（2）调用yield()函数
yield()函数属于挂起函数。Kotlin中的所有内置的挂起函数都是可以被取消的。
【举例】在while循环中调用yield()函数
fun main() = runBlocking {
    val startTime=System.currentTimeMillis()
    val job=launch (Dispatchers.Default){
        var nextPrintTime=startTime
        var i=0
        //当协程状态为_Canceling_时退出循环
        while (isActive && i<15){
            yield()
            if (System.currentTimeMillis() >= nextPrintTime){
                println("休眠${i++}次")
                nextPrintTime+=500
            }
        }
    }
    delay(10)
    println("协程取消")
    //cancel()方法将协程状态由_Active_变成了_Canceling_。
    job.cancel()
    println("主协程执行完毕")
}

输出结果如下：

休眠0次
协程取消
主协程执行完毕

Kotlin类库中的yield()函数的完整逻辑如下：
public suspend fun yield(): Unit = suspendCoroutineUninterceptedOrReturn sc@ { uCont ->
    val context = uCont.context
    //检查协程当前状态
    context.checkCompletion()
    val cont = uCont.intercepted() as? DispatchedContinuation<Unit> ?: return@sc Unit
    if (cont.dispatcher.isDispatchNeeded(context)) {
        // this is a regular dispatcher -- do simple dispatchYield
        cont.dispatchYield(context, Unit)
    } else {
        // This is either an "immediate" dispatcher or the Unconfined dispatcher
        // This code detects the Unconfined dispatcher even if it was wrapped into another dispatcher
        val yieldContext = YieldContext()
        cont.dispatchYield(context + yieldContext, Unit)
        // Special case for the unconfined dispatcher that can yield only in existing unconfined loop
        if (yieldContext.dispatcherWasUnconfined) {
            // Means that the Unconfined dispatcher got the call, but did not do anything.
            // See also code of "Unconfined.dispatch" function.
            return@sc if (cont.yieldUndispatched()) COROUTINE_SUSPENDED else Unit
        }
        // Otherwise, it was some other dispatcher that successfully dispatched the coroutine
    }
    COROUTINE_SUSPENDED
}

internal fun CoroutineContext.checkCompletion() {
    val job = get(Job)
    if (job != null && !job.isActive) throw job.getCancellationException()
}
从这段代码可以看到，yield()函数执行过程中，会判断当前协程是否是isActive状态，
如果不是则抛出CancellationException异常，协程也就测被真正取消了。
 */