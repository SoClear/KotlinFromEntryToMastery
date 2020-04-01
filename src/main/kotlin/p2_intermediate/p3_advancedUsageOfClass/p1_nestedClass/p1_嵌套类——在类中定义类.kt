package p2_intermediate.p3_advancedUsageOfClass.p1_nestedClass

/*
嵌套类NestedCas是一种定义在 类内部的类，它的光整限定类名是“外部类.嵌套类”。
嵌套类类似于Java中的静态内部类，往往和外部类存在一定逻辑上的关联。
但是，嵌套类本身和外部类一样都是独立存在的， 所以无法在嵌套类中访问外部类的成员。
*/
//[举例]创建一个外部类Outer,并在该类内部创建一个嵌套类Nstete具体代码如下:
//外部类
class Outer {
    val outerProperty: String = "外部类属性"

    //嵌套类
    class Nested {
        val nestedProperty: String = "嵌套类属性"
        fun doSomething() {
            //这里无法访问外部类的outerProperty属性
            println(nestedProperty)
        }
    }
}

//接下来创建一个嵌套 类的对象，并调用该对象的方法 。具体代码如下 :
fun main() {
    //通过“外部类.嵌套类”创建嵌套类对象
    val nested = Outer.Nested()
    //调用嵌套类对象的方法
    nested.doSomething()
}

/*
从这个例子中可以看到，嵌套类使用起来和外部类没有什么区别，只是在创建时需要以“外部类.嵌套类”即（Outer.Nested）作为类名。
 */