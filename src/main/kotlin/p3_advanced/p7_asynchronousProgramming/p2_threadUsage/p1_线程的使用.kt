package p3_advanced.p7_asynchronousProgramming.p2_threadUsage

import kotlin.concurrent.thread

/*
在使用多线程进行异步编程时，Kotlin完全采用了Java的线程API，只是为了减少代码量而增加了一些语法糖。
java的线程API的核心是Thread类和Runnable接口。
Thread类表示线程对象，该类包含一个run()方法，该方法的代码会运行在指定的线程中。
Runnable接口也包含一个同样的run()方法。这两者的区别是：Thread类有一个接受Runnable对象作为参数的构造方法，
这样在创建不同的Thread对象时可以复用同样的业务逻辑代码。
 */
//【举例】用Java API的方法创建线程

/*
fun main() {
    //方式一，基于Thread类创建线程
    val thread1=Thread{
        run {
            println("线程运行中...")
        }
    }
    //启动线程
    thread1.start()

    //方式二，基于Runnable接口和Thread类创建线程
    val runnable= Runnable {
        println("线程运行中...")
    }
    val thread2=Thread(runnable)
    //启动线程
    thread2.start()
}
 */
/*
在创建完线程后，可以通过Thread类的start()方法启动刚刚创建的线程。
除了使用这种方法创建线程外，Kotlin还提供了顶层函数thread()来简化线程的创建过程。
需要import kotlin.concurrent.thread
下面是thread()函数的完整函数签名：
public fun thread(
    start:Boolean=true,
    isDaemon:Boolean=false,
    contextClassLoader:ClassLoader?=null,
    name:String?=null,
    priority:Int=-1,
    block: () -> Unit
):Thread

● start————布尔值。若为true (默认值)，则线程创建后立即启动;若为false,则需要手动调用start()方法启动线程。
● isDaemon————布尔值。 若为true,则该线程为守护线程;若为false,则该线程为普通线程。
  如果在JVM中只有守护线程存活，则进程会停止运行，所以守护线程中的代码可能不会被执行完毕。
  而普通线程只有在执行完毕后才会停止运行。
● contextClassLoader————ClassLoader 类型，用于在线程中加载类和资源。
● name————字符串， 表示线程的名字。
● priority整型，表示线程的优先级，最小为1,最大为10， 默认为5。
  优先级越高的线程越有可能优先获得资源，但是优先级依赖于操作系统本身。
  所以，如果操作系统只支持两种优先级，那么1~5级和6~ 10级的线程的实际上可能具有相同的优先级。
● block————编写在run()方法中需要运行的代码。
 */
//[举例]用Kotlin 风格创建线程。具体代码如下:
fun main() {
    //方式一，创建并启动线程
    thread {
        println("线程运行中... ")
    }
    //方式二，在创建时指定各参教并手动启动线程
    val thread= thread(start=false,isDaemon = true,name = "t1"){
        println("线程运行中...")
    }
    thread.start()
}
