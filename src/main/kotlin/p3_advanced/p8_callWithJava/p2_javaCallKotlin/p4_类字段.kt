package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*

类字段
单例对象或伴生对象中定义的属性都包含私有的幕后字段。
如果需要将该字段导出以便在Java代码中进行访问，则需要使用以下几种方式之一:
●用@JvmField 注解修饰属性。
●用lateinit修饰属性。
●用const 修饰属性。
用以上方式导出的字段与对应的属性具有相同的访问权限。

[举例]用@JvmField注解修饰伴生对象的属性，具体代码如下:
*/
class KotlinBean4 {
    companion object {
        @JvmField
        var companionProperty = 1
    }
}
/*
在Java代码中访问导出的字段，具体代码如下:
KotlinBean4 kotlinBean4 = new KotlinBean4() ;
KotlinBean4.companionProperty = 1;
如果没有导出该字段，则必须使用“KotlinBean4.Companion.setCompanionProperty(1);"才能修改该属性的值。
[举例]在单例对象中，声明延迟初始化属性和const属性，具体代码如下:
//单例对象
object Singleton {
    lateinit var name: String
    const val id= 1
    const val MAX_ INT = Int.MAX_VALUE
}

在Java代码中，访问导出的字段，具体代码如下:
Singleton.name = "singleton";
System.out.println(Singleton.id) ;
System.out.println (GlobalUtils.MAX INT);
从这个例子中可以看到，使用const修饰的常量被导出后是静态常量。
*/