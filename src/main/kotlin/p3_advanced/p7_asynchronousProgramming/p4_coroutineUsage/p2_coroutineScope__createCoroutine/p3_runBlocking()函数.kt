package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p2_coroutineScope__createCoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
1.runBlocking()函数
runBlocking()函数属于顶层函数，可以用来创建一个阻塞当前线程的协程。
只有当该协程内部的代码执行完毕后当前线程才能继续执行下去。
runBlocking函数的完整签名如下：
@Throws(InterruptException::class)
public fun <T> runBlocking(
    context:CoroutineContext=EmptyCoroutineContext,
    block:suspend CoroutineScope.() -> T
):T

context————协程上下文
block————在线程上下文中执行的具体代码块。

在执行过程中，如果协程所在的线程被中断了，则会抛出InterruptException异常。
 */
//【举例】用runBlocking()函数创建一个新的协程。
fun main() {
    //阻塞当前线程
    runBlocking {
        delay(1000)
        println("world")
    }
    //协程执行完主线程才能执行
    println("hello")
}
/*
输出结果如下:
world
hello
在这个例子中，协程执行时主线程被阻塞了，只有协程中的代码执行完毕后主线程才能继续执行下去，
所以，控制台先打印协程中的字符串“world”，然后打印main函数中的字符串hello

runBlocking()函数实际并不是被设计用来在应用程序中创建协程对象的，而是被设计用来桥接阻塞代码和挂起风格代码的。
它的主要应用场景是各种入口函数，比如main()函数或者Junit程序中的各种test()方法，具体代码如下：
fun main() = runBlocking{
    //编写代码
}
 */