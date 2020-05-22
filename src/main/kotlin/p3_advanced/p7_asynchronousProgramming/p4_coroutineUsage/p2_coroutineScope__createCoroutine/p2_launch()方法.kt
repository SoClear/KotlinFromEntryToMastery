package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p2_coroutineScope__createCoroutine

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
1.launch()方法
launch()属于CoroutineScope接口的成员，单例对象GlobalScope实现了该接口。
用launch()方法可以创建一个新的协程，这个新创建的线程不会阻塞当前线程的运行。

launch()方法的完整签名如下：
public fun CoroutineScope.launch(
    context:CoroutineContext=EmptyCoroutineContext,
    start:CoroutineStart=CoroutineStart.DEFAULT,
    block:suspend CoroutineScope.() -> Unit
):Job

context————协程的上下文
start————协程的启动选项。默认值为CoroutineStart.DEFAULT，表示在创建协程后立即启动该协程。
block————在线程上下文中执行的具体代码块
 */
//【举例】用launch()方法创建一个新的协程
fun main() {
    //创建新的协程
    GlobalScope.launch {
        //协程进行休眠
        delay(1000)
        println("world")
    }
    //主线程继续执行
    println("hello")
}
/*
输出结果如下：
hello
在这个例子中，delay()方法用于使当前线程休眠1秒，而此时主线程仍然在继续执行，在打印完字符串hello后主线程就退出了，
所以字符串world并不会被打印。
 */