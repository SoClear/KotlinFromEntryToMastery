package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p3_JobClass__controlCoroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
Job类————控制协程
在通过launch()函数启动协程时，该函数会返回一个 Job类的对象，该对象表示一个任务(当前运行中的协程)。使用该对象的以下方法可以控制协程的运行。
● job.start()————启动协程。
    如果在创建协程时指定协程启动选项为CoroutineStart.LAZY,
    则需要手动调用该方法来执行协程。否则协程创建后会自动启动，无须调用该方法。
● job.join()————该方法可以阻塞当前协程直到该任务执行完毕。
● job.cancel()————该方法可以取消指定任务。
● job.cancelAndJoin()————该方法用于阻塞当前协程直到该任务被真正取消。
● delay()————该函数属于项层函数，可以用于挂起当前协程。挂起动作只会影响协程，不会阻塞线程。
*/
//[举例]用job对象的方法控制协程的运行。具体代码如下:
fun main() = runBlocking {
    val job1=launch {
        delay(1000)
        println("协程1执行中")
    }
    job1.join()
    println("协程1执行完毕")

    val job2=launch {
        delay(100)
        println("协程2执行中")
    }
    job2.cancel()
    delay(1200)
    println("主协程执行完毕")
}
/*
输出结果如下:
协程1执行中
协程1执行完成
主协程执行完毕

在这个例子中，runBlocking()函数的代码块中包含了隐式参数CoroutineScope,所以可以直接调用该对象的launch()方法来启动动新的协程。
job1任务调用了join()方法，所以只有当该协程内的语向执行完毕后代码才会继续执行下去。
而job2任务调用了cancel()方法，所以协程被取消了，代码块中的语句没有被执行。


 */