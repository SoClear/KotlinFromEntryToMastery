package p3_advanced.p4_exception.p2_exceptionHandling

import java.util.*

/*
抛出异常


1.手动抛出异常
异常对象可以由系统产生，也可以手动抛出。
抛出异常是指，将异常对象提交给当前运行环境进行处理。
手动抛出异常需要使用throw语句，通常该语句都会包裹在try语句中以便进行捕获和处理。

[语法]
throw 异常对象

//[举例]抛出一个找不到文件的异常，具体代码如下:
//throw FileNotFoundException("file not found.")

throw语句和try语句一样，也可以作为表达式来使用。
该表达式返回的是Noting类型，Kotlin中的Nothing类型只是用于标记种无法真正返回的状态， 所以它并没有真实的返回值。




2.在表达式中抛出异常
Kotlin中的throw语句常常和各种表达式放在一起使用。

//[举例]结合猫王操作符使用throw表达式。具体代码如下:
fun getEntity(): Entity {
    val entity: Entity? = getValueFromDB()
    //使用猫王操作符
    return entity ?: throw RuntimeException ("没有找到对象")
}
在这个例子中，首先通过“getValueFromDB()”方法获得了”个可空类型的返回值，然后
结合猫王操作符来实现了“如果entity对象不为空则返回entity对象，如果entity 为空则抛出异常”的功能。
这种用法在实际应用中也非常常见。除使用猫王操作符外，也可以将throw 表达式用在if表达式上实现类似的功能。
[举例]结合if表达式使用throw表达式。具体代码如下:
val half =
if(n%2==0)
    n/2
else
    throw RuntimeException("n must be even")



3.再次抛出异常
如果当前上下文中的try 语句无法处理被抛出的异常，则应该在catch语句块中再次将该异常抛出，由上层来捕获和处理。
*/
//[举例]将异常返回给方法调用处进行处理。具体代码如下:
fun test1() {
    try {
        //业务逻辑
    } catch (e: IllegalFormatException) {
        //处理IllegalFormatException异常
    } catch (e: Exception) {
        //打印异常信息
        e.printStackTrace()
        //再次抛出异常
        throw UnsupportedOperationException("不支持的操作", e)
    }
}

fun main() {
    try {
        test1()
    } catch (e: UnsupportedOperationException) {
        //处理test()方法中出现的异常对象
    }
}

/*
在这个例子中:
●如果在test()方法中发生了IllegalFormatException 类型的异常，则该方法会自行处理该异常。
●如果在test()方法中发生了其他类型的异常，
  则程序会将该异常包装为UnsupportedOperationException类型的异常，
  然后交由调用处(这里是main)方法)进行处理。


在实际采用分层结构的应用中，这种将异常“包装后向上抛出”的用法非常常见。
它主要有以下3个优点:
●可以在上层统处理异常， 而不是每个地方进行重复作业。
●防止泄露实际的异常信息给上层。比如数据库的异常，如果直接暴露给前端，则可能暴露实际的表结构，降低程序的安全性。
●提高异常的可读性。 默认的系统异常信息通常包含大量的无效信息。通过自行包装可以将错误信息进行定制化。

在上层捕获被抛出的异常对象时，也需要按异常范围从小到大进行捕获，
避免直接创建捕获Exception类型的catch代码块，这种做法会造成异常被吞噬。

*/
