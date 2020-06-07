package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p9_checkException

/*
检查异常
Kotlin没有Java那样的检查异常，所以在调用Java中要求捕获异常的方法时，可以不用显式进行捕获(即编写try...catch语句)。

[举例]在Kotlin中调用声明异常的Java方法。
(1)创建一个声明异常的Java方法，具体代码如下:
public FileInputStream getInputStream (String fileName)
    throws FileNotFoundException {
        File file= new File (fileName) ;
        return new FileInputStream (file);
}
(2)编写调用该方法的kotlin方法，具体代码如下:
val input = javaBean.getInputStream("hello.txt")

 */