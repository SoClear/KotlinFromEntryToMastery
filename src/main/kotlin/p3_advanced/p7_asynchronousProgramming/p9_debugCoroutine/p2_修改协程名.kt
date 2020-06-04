package p3_advanced.p7_asynchronousProgramming.p9_debugCoroutine

import kotlinx.coroutines.*

/*
从上面的例子中可以看到，协程的默认名字是coroutine。这对于实际调试还是不那么方便。
如果需要修改协程名，则可以用CoroutineName类创建一个带有名字的协程上下文。
 */
//【举例】为协程指定名字
fun main() = runBlocking {
    async {
        println(Thread.currentThread().name)
    }

    async(CoroutineName("main-alias")) {
        println(Thread.currentThread().name)
    }

    async(Dispatchers.IO) {
        println(Thread.currentThread().name)
    }
    delay(1000)
    println("主协程退出")
}
/*
输出结果如下：
DefaultDispatcher-worker-1 @coroutine#4
main @coroutine#2
main @main-alias#3
主协程退出

 */
