package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p4_coroutineStatesAndCancelCoroutine

import kotlinx.coroutines.*

/*
4.不可被取消的代码
上面介绍了使用内置挂起函数中断finally分支的代码逻辑，在实际工程中finally分支常常
被用于释放资源，所以它当中的代码必须能够执行完毕。要想达到此功能，需要使用withContext()
函数将代码所在的上下文切换为NonCancellable上下文。

提示：
NonCancellable上下文对象同时也是Job对象，其协程状态始终为_Active_，所以不可被取消。
 */

//【举例】用withContext()函数使得finally分支中的所有代码被执行
fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("休眠了$i 次")
                delay(500L)
            }
        } finally {
           withContext(NonCancellable){
               println("finally分支中的代码")
               //这里会抛出CancellationException异常
               delay(1000)
               println("finally分支中位于挂起函数后的代码")
           }
        }
    }
    delay(1200L)
    println("等待协程被取消")
    job.cancelAndJoin()
    println("主协程退出执行")
}
/*
输出结果如下

休眠了0 次
休眠了1 次
休眠了2 次
等待协程被取消
finally分支中的代码
finally分支中位于挂起函数后的代码
主协程退出执行
 */