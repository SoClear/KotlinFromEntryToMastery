package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p4_coroutineStatesAndCancelCoroutine

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
在try..catch...finally语句中，finally分支中的代码总是会被执行，在协程中这个规则仍然奏效。
 */
//【举例】在finally分支中编写代码
/*
fun main ()= runBlocking {
    val job=launch {
        try {
            repeat(1000){i ->
                println("休眠了$i 次")
                delay(500L)
            }
        }finally {
            println("finally分支中的代码")
        }
    }
    delay(1200)
    println("等待协程被取消")
    job.cancelAndJoin()
    println("主协程退出执行")
}
*/

/*
输出结果如下：
休眠了0 次
休眠了1 次
休眠了2 次
等待协程被取消
finally分支中的代码
主协程退出执行

从这个例子中可以看到，尽管协程被取消了， finally 分支中的语句仍然被打印到了控制台中。
这里需要注意:如果在finally分支中调用了内置的挂起函数，
由于挂起函数被取消时会抛出CancellationException异常，所以在这之后的代码不会被执行。
*/
//[举例]在finally分支中调用挂起函数。具体代码如下:

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("休眠了$i 次")
                delay(500L)
            }
        } finally {
            println("finally分支中的代码")
            //这里会抛出CancellationException异常
            delay(1000)
            println("finally分支中位于挂起函数后的代码")
        }
    }
    delay(1200L)
    println("等待协程被取消")
    job.cancelAndJoin()
    println("主协程退出执行")
}

/*
输出结果如下:
休眠0次
休眠1次
休眠2次
等待协程被取消
finally分支中的代码
主协程退出执行

从这个例子中可以看到，挂起函数后面的输出语句没有被执行。
因为挂起函数会抛出CancellationException异常，此时程序逻辑已经被中断了。
 */