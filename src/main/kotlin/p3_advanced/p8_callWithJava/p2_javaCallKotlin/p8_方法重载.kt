package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
方法重载
在Kotlin中。通过参数默认值和命名参数，可以让一个方法在调用过程中传入不下同数量的参数。
而在java中如果想实现同样的功能，则需要手动编写多个同名方法（即方法法重载）。
如果在一个kotlin的方法上添加“@JvmOverloads”注解，则这些提供给Java的重载方法会由编译器自动生成。
这个注解不能用在任何抽象方法上。

[举例]在Kotlin中用用注解生成重载方法，如下，
@JvmOverloads
fun foobar(a::String, b:Int=0,c:String="c") {
    println("a=$a b=$b c=$c")
}
然后用java程序调用该方法，具体代码如下:
kotlinBean.foobar ("new a");
kotlinBean.foobar("new b", 100);
kotlinBean.foobar ("new a",100,"new b");

从这个例子中可以看到，编译器会恨据Kotlin方法的参数列表，为所有设置了默认值的参数生成重载方法。
如果一个方法的所有都拥有默认值，那即使不使用@JvmOverloads注解，编译器也会为其生成多种重载方法。
*/
