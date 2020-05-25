package p3_advanced.p7_asynchronousProgramming.p6_asyncFunctionAnd_awaitMethod

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/*
在上面的例子中已经使用到了await()方法，该方法是Deferred类的成员方法，
其功能主要是等待async()函数中的代码块执行完毕后返回执行结果。
如果在等待的过程中该任务被取消，则抛出CancellationException异常。

如果某些任务之间存在依赖关系，可以用await()方法等待前置任务执行完毕。
async()函数和await()方法在协程中主要用于编排任务。

除非在Deferred对象上调用await()方法等待异步任务执行完毕外，
也可以用awaitAll()函数等待一组任务执行完毕，执行结果会被封装到List对象中。
*/
//【举例】用awaitAll()函数等待一组异步任务的执行结果
fun main() = runBlocking {
    val duration= measureTimeMillis {
        val action1=async { getNumber1() }
        val action2=async { getNumber2() }
        //等待action1和action2两个异步任务
        val resultList= awaitAll(action1,action2)
        println(resultList.sum())
    }
    println("耗时： $duration")
}
/*
输出结果如下：

3
耗时： 2040

 */

