package p3_advanced.p4_exception.p3_exceptionObject

/*
本节将介绍外常对象和异常类的创建方式，以及异常类的各种内置成员。
1.
了解异常对象
和普通类一样，用异常类的构造方法可以创建一个异常对象。
[举例]创建一个Exception类型的异常对象。具体代码如下:
val e = Exception()
每个异常对象都包含以下几个成员:
●message:String————字符串类型，包含异常对象的缩略信息。
●stackTrace: StackTraceElement[]————StackTraceElement数组类型，包含异常发生时的栈信息。
●printStack()————用于将异常的栈信息打印到控制台上。
●printStack(pw/is)————参数为PrintWriter/PrintScreen类型，用于将异常的栈信息打印到参数指定的流对象。

2.
自定义异常类
在实际工程中，为了区分异常的种类，一般不会手动抛出系统内置的异常类， 而是地出由开发者自定义的各种异常类。
所有自定义的异常类应该维承Exception类。

[举例]创建一个自定 义的异常类BusinessException。具体代码如下:
 */
class BusinessException(val code:String,errorMessage:String,cause:Throwable?=null):Exception(errorMessage,cause)

/*
在这个例子中，自定义的异常类BusinessException包含一个字符串类型的code属性，该属性用于表示异常状态码。
在实际工程中，通常会将该状态码返回给前端，由前端通过该异常码判断该如何提示用户。
 */