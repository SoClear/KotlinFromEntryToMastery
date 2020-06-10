package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
检查异常
Kotlin 中不存在检查异常，因此Kotlin不用强制抛出异常。
而Java的风格是随时捕获可能发生的异常。
如果希望编译器能够提醒Java代码进行主动捕获，
则可以用注解@Throws声明该方法将抛出指定异常类。

[举例]在Kotlin代码中声明异常类。
首先创建一个Kotlin方法，并为该方法添加异常声明，具体代码如下:
@Throws (IOException::class)
fun getInputStream:FileInputStream{
    val file = File(fileName)
    return FileInputStream(file)
}
@Throws注解声明了该方法在调用过程中可能会发生IOException异常，
所以在以下Java代码中必须显示捕获该异常：

InputStream inputStream=null;
try {
    inputStream =kotlinBean.getInputStream("hello.txt");
}catch(IOException e){
    e.printStackTrace();
}
 */