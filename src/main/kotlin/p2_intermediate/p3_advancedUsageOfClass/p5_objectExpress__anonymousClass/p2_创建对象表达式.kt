package p2_intermediate.p3_advancedUsageOfClass.p5_objectExpress__anonymousClass

/*
(1)基本语法。
object:父类型列表

冒号后面是需要扩展功能的父类型(类或接口)。
一个对象表达式可以同时扩展多个父类型，但是这些父类型(parent type)中最多只能有一个父类型为类(class)。


(2)基于类和接口创建对象表达式。
 */
//[举例]创建一个抽象类和一个接口。具体代码如下:
interface Valuable{
    fun getPrice():Int
}

abstract class Item{
    abstract  var group:String
}

//然后创建一个继承Item类，并实现Valuable接口的对象表达式
//定义了一个继承Item类，并实现Valuable接口的对象表达式
private var blueBottle = object : Item(),Valuable{
    override fun getPrice(): Int {
        return 100
    }

    override var group: String="药物"
}

fun main() {
    println(blueBottle.group)




    println(redBottle.group)
}
/*
(3) 直接创建匿名对象。
对象表达式的底层实现是:先创建了一个匿名类， 然后基于该匿名类创建了一个对象并进行返回。
这种没有显式类型声明的对象也被称为匿名对象( Anonymous Object)。
在Kotlin中，可以在不指定任何父类型的情况下，直接用对象表达式创建匿名对象。
[举例]直接创建一个包含属性和方法的匿名对象。具体代码如下:
 */
//直接使用对象表达式
private val redBottle=object{
    fun getPrice():Int{
        return 100
    }

    var group="药物"
}