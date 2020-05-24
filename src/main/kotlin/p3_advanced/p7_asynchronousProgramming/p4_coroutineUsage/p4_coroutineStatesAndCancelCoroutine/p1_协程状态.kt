package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p4_coroutineStatesAndCancelCoroutine

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
协程状态和协程取消
上节介绍了用cancel()方法来取消协程，实际上在调用该方法后协程并不会立即被取消。
协程本身是由状态机构成的，cancel()方法只是改变了协程的状态，只有满足了特定条件协程才会被真正取消，
1.协程状态
下展示了协程的各种状态。其中，isActive,isCompleted和isCancelled为协程的内置属性，用来判断当前协程的执行状态。
------------------------------------------------------------------------------
状态                   |      isActive    |    isCompleted    |     isCancelled
------------------------------------------------------------------------------
_New_(可选初始态)       |    false         |     false         |      false
------------------------------------------------------------------------------
_Active_(默认初始态)    |    true          |     false         |      false
------------------------------------------------------------------------------
_Completing_(暂态)     |    true          |     false         |      false
------------------------------------------------------------------------------
_Cancelling_(暂态)     |    false         |     false         |      true
------------------------------------------------------------------------------
_Cancelled_(终态)      |    false         |     true          |      true
------------------------------------------------------------------------------
_Completed_(终态)      |    false         |     true          |      false
------------------------------------------------------------------------------


调用launch()方法创建的协程会立即启动，这种情况下协程的初始态为_Active_ 。
如果将launch()方法的初始启动选项设置为CoroutineStart.LAZY,
则该协程需要手动启动，在这种情况下协程的初始态就是_New_ 。

调用cancel()方法或在协程执行过程中发生了异常，则该协程的状态会立即变成Cancelling 。
在协程执行完任务后，当暂态Cancelling 会变成终态Cancelled 时，协程才会真正停止。
*/
//[举例]取消一个正在执行任务的协程。具体代码如下:
fun main() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("休眠${i++}次")
                nextPrintTime += 500L
            }
        }
    }
    delay(100)
    println("取消协程")
    job.cancel()
    println("主线程执行完毕")
}
/*
输出结果如下：
休眠0次
取消协程
主线程执行完毕
休眠1次
休眠2次
休眠3次
休眠4次

在这个例子中，虽然调用了cancel()方法，但是协程中的代码仍然被执行完毕，因为整个while循环的执行过程是不可被取消的。
 */