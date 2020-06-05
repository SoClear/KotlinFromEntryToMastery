package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p1_identifier

import JavaBean1

/*
Kotlin在Java关键字的基础上多增加了一一些关键字，
这导致一些在Java中合法的标识符到了Kotlin中则变成了非法的。
如果需要在Kotlin中需要访问这种命名方式的Java成员，则应该将关键字用符号“``”包裹起来，以此对关键字进行转义。
[举例]在Kotlin代码中访问方法名为关键字的Java 代码。
(1)在Java中创建一个JavaBean类，具体代码如下:
public class JavaBean1 {
    private String name;

    public JavaBean1(String name){
        this.name=name;
    }

    public boolean is(String name){
        return this.name.equals(name);
    }
}
(2）编写一段访问该java对象的kotlin代码
 */
fun main(){
    //生成java类的对象
    val javaBean1 = JavaBean1("JavaBean1")
    //调用方法名为关键字is的方法
    val isSameName=javaBean1.`is`("Peter")
    println(isSameName)
}