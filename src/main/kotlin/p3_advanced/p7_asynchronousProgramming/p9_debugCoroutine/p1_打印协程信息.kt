package p3_advanced.p7_asynchronousProgramming.p9_debugCoroutine

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/*
1.打印协程信息
调试协程非常麻烦，所以Kotlin提供了“-Dkotlinx.coroutines.debug"这个JVM参数，
那么问题来了，在哪里写这个JVM参数呢？

在idea顶部Run ---> Edit Configurations，
在左侧选择你要修改哪个代码文件的配置，在右侧的VM options中添加-Dkotlinx.coroutines.debug=on
这样在打印线程信息的同时也会打印当前协程信息。
*/
//[举例]打印协程信息。具体代码如下:
fun main()= runBlocking {
    async {
        println(Thread.currentThread().name)
    }

    async {
        println(Thread.currentThread().name)
    }
    delay(1000)
    println("主协程退出")
}
    /*
main @coroutine#1
main @coroutine#2
主协程退出
输出结果格式为“线程名 @协程名#协程ID”，即这里的协程名都是“coroutine”， 所以只能通过协程ID来进行区分。

 */