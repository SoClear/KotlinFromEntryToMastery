package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p4_coroutineStatesAndCancelCoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull

/*
5.超时取消
一般情况下,取消协程的最常见理由就是在网络请求中发生了请求超时。
在Kotlin 中,可以通过 withTimeout()为一段代码设置超时时间(最大执行时间)。
如果实际执行时间超过了超时时间,则协程会抛出TimeoutCancellationException异常并停止运行。
 */
//【举例】用 withTimout()函数指定超时时间。具体代码如下:
/*
fun main() = runBlocking {
    withTimeout(1300L){
        repeat(1000){i ->
            println("休眠了 $i 次")
            delay(500L)
        }
    }
}
*/

/*
输出结果如下：
休眠了 0 次
休眠了 1 次
休眠了 2 次
Exception in thread "main" kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 1300 m

如果需要在超时取消后进行一些特殊逻辑处理,则可以将超时取消的代码整体放在try…catch 代码块中。
除此之外还有一种做法:用withTimeoutOrNull()函数替代 withTimeout()函数。
如果超时则 withTimeoutOrNull() 函数返回 null,如果没有超时则返回 kotlin.Unit。

 */
//【举例】用 withTimeoutOrNull() 函数指定超时时间。具体代码如下:
fun main () = runBlocking {
    val timeout= withTimeoutOrNull(1300L){
        repeat(1000){i ->
            println("休眠 $i 次")
            delay(500L)
        }
    }
    println(timeout)
}
/*
输出结果如下：

休眠 0 次
休眠 1 次
休眠 2 次
null
 */