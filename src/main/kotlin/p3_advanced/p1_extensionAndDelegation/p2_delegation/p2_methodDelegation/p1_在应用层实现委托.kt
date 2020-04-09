package p3_advanced.p1_extensionAndDelegation.p2_delegation.p2_methodDelegation

/*
2 使用方法委托
1.在应用层实现委托
首先看一个手工实现委托模式的例子。
*/
//(1)创建一个Base 接口和该接口的实现类 BaseImpl,具体代码如下:
interface Base {
    fun log(message: String)
    fun isEnabled(): Boolean
}

class BaseImpl : Base {
    override fun isEnabled(): Boolean {
        return true
    }

    override fun log(message: String) {
        println(message)
    }
}

/*
创建一个实现了Base接口的委托类Delegation1，该类重写Base接口的log()方法和isEnabled()方法，
实际上是调用主构造方法中的base属性的log()方法和isEnabled()方法。具体代码如下:
*/
class Delegation1(val base: Base) :
    Base {
    override fun log(message: String) {
        base.log(message)
    }

    override fun isEnabled(): Boolean {
        return base.isEnabled()
    }
}

//(3)创建个委托类的对象并进行测试，具体代码如下:
fun main() {
    val delegation =
        Delegation1(
            BaseImpl()
        )
    delegation.log("test")
}
/*
这个例子是在代码层面实现了委托模式。
可以看到，如果Base按口包含更多方法，则委托类也需要一一实现这些方法。
这个过程未免有些烦琐，所以Kotlin直接在语言层面提供了委托类的创建方法。
*/
