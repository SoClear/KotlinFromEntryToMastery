package p2_intermediate.p3_advancedUsageOfClass.p2_innerClass

/*
内部类(Inner Class)是使用“inner”关键字作为前缀修饰的、定义在类内部的类，
它的完整限定类名和嵌套类一样，也是“外部类.内部类”。
但是，嵌套类是独立的类，而内部类则是外部类的一个成员，不能直接通过内部类的构造方法创建对象。
*/
//[举例]创建了一个外部类Outer,并在该类内部创建了一个内部类Inner。具体代码如下:
//外部类
class Outer(private val name:String="Outer"){
    //内部类，用inner修饰
    inner class Inner{
        //访问外部类属性
        fun getOuterName()=name
    }
}

/*
在内部类对象时，会同时创建一个外部类的对象。
该外部类对象会作为内部类的内置属性，
所以，在内部类对象中可以直接访问外部类的成员。
在上面代码中，内部类Inner中的getOuterName()方法就直接返回了外部类中的name属性。
 */
//接下来创建Inner类的对象
fun main() {
    //创建外部类对象
    val outer=Outer()
    //通过外部类对象创建内部类对象
    val inner=outer.Inner()
    //内部类对象访问外部类的私有成员。
    println(inner.getOuterName())
}

/*
从这个例子中可以看到，创建内部类对象的具体步骤是：先创建一个外部类对象，然后通过该外部类对象创建内部类对象。
 */