package p3_advanced.p4_exception.p2_exceptionHandling

import java.io.FileNotFoundException
import java.io.File

/*
捕获和处理异常
捕获并处理异常需要使用”try...catch...finally“语句，
在try代码块中编写可能会引起异常的语句，
在catch代码块中处理异常、恢复现场，
在finally代码块中编写无论异常是否会发生都会执行的语句。
 */

/*
1.处理异常
[举例]捕获并处理异常。具体代码如下:
*/
fun handleException() {
    try {
        //编写可能出现异常的语句
        val source = File("")
        val text = source.readText()
    } catch (e: FileNotFoundException) {
        println("处理异常，恢复现场。")
    } finally {
        println("无论异常是否发生，该语句总是会被执行。")
    }
}
/*
在”try...catch...finally“语句中，
try代码块必须出现且只能出现一次，
而catch代码块可以出现0次到多次，
finally代码块则可以出现0次或1次，

但是catch代码块和finally代码块这两者不能同时被省略(即:可以是try--catch或try--finally,但不能是单独的try)。

●如果try代码块中没有发生异常，则catch代码块中的代码会被跳过，程序会继续执行finally代码中的代码。
●如果try代码块中抛出了异常对象，则程序会立即停止执行try代码块中剩余的语句，
  并自动从上到下依次寻找当前上下文中是否存在能够处理该异常对象的catch代码块。
    ■如果找到了匹配的catch 代码块，则程序会将该异常对象交由该catch代码块进行处理。
    ■如果在当前方法中找不到合适的catch 代码块，则异常对象会被提交给方法的调用方。
    ■如果一直都无法找到合适的catch代码块，则程序会中断执行。
*/

class BusinessException:java.lang.Exception(){
    fun busy(){
        println("business exception")
    }
}
//[举例]用多个catch代码块捕获不同的异常。具体代码如下:
fun readTxt(fileName: String) {
    try {
        //该方法可能抛出异常
        val source = File("")
        val text = source.readText()
        println("读取完毕")
    } catch (e: FileNotFoundException) {
        //处理异常
        println("无法找到a.txt文件")
    } catch (e: BusinessException) {
        //处理异常
        println("无法读取a.txt文件")
    } finally {
        println("操作完成")
    }
}

/*

在这个例子中，首先创建了两个catch代码块，
在发生异常后程序会判断异常对象是否为第1个catch代码块中指定的FileNotFoundException类或其子类的对象。
如果不是该类型的异常，则程序会跳转到第2个catch代码块，继续判断异常对象是否为Exception类型或其子类的对象。
如果仍然不匹配，则异常对象会被向上抛到调用readText()方法的地方。


2.异常捕获顺序
当出现多个catch代码块时，运行环境总是从最上面的catch代码块开始一个个判断实际发生的异常对象与捕获的异常对象是否匹配。
所以，在编写异常捕获代码时，应该将表示范围较小的异常处理逻辑放在上面，将表示范围较大的异常处理逻辑块放在下面。
如果将这两者反过来，则程序就总是会执行表示范围较大的异常处理逻辑，而范围较小的异常处理逻辑会一直无法得到被执行的机会。

[举例]先处理较大范围的异常类型，再处理较小范围的异常类型。具体代码如下:
try{
}catch(e: Exception) {
}catch(e: NullPointerException) {}

在这个例子中，由于Exception类是NullPointerException 类的父类，
所以无论程序如何运行，第2个catch代码块总是无法被执行，即这段代码不可达。

提示:
在Java中，当出现异常捕获顺序不对而造成某段catch代码不可达时，IDE会提示该异常已被捕获的警告。
而在Kotlin中则不会出现任何警告，程序依然可以正常执行。在这一点上Kotlin不如Java。

*/

