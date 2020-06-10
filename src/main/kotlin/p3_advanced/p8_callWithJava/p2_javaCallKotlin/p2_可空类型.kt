package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
Java并不支持可空类型，所以直接在java中将kotlin的可空类型变量设置为空值是非常不安全的。
为此Kotlin采用了在运行时进行检测的的机制:如果在Java中将非空类型设置为空值，
则程序会抛出IllegalArgumentException异常。
*/
//[举例]在Java程序中，将Kotlin对象的非空类型属性设置为空值。
//(1)创建一个包含非空类型属性的Kotlin类
class KotlinBean2 (var name: String)

/*(2)在lina中向该属性传递空值。具体代码如下:
KotlinBean2 kotlinBean2 =new KotlinBean2(null);


在运行这段代码后控制台会直接打印java.lang.IllegalArgumentException:Parameter specified as non-null is null异常

*/
