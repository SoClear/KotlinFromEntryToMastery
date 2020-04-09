package p3_advanced.p1_extensionAndDelegation.p2_delegation.p4_built_inPropertyDelegation

import kotlin.properties.Delegates

/*
3.使用观察者属性委托
观察者属性委托用于观察属性值的变化情况，并在属性值发生改变时执行用户自定义的操作。

(1)使用observable()。
观察者属性委托主要依赖ReadWriteProperty类的对象来实现。
单例对象Delegates的observable()方法用于生成该类的对象，该方法的参数含义如下:
●第1个参数为属性初始值。
●第2个参数为Lambda表达式————当属性值改变时，Lambda表达式会被执行。
 该Lambda表达式也包含了3个参数，分别是对委托属性的引用、属性的旧值和属性的新值。

*/
//[举例]创建一个包含观察者属性委托的类。具体代码如下:
class User {
    // name 属性使用了观察者属性委托
    var name: String by Delegates.observable("<init value>") { _, old, new ->
        //观察者的Lambda表达式
        if (old != new) {
            println("$old -> $new")
        }
    }
}
/*
在这段代码中，如果旧属性值和新属性值不一致，则程序会执行打印操作。 下面测试一下该功能，具体代码如下:
 */
fun main() {
    val user=User()
    //第一次访问，输出：<init value>
    println(user.name)

    //改变值，输出：<init value> -> first
    user.name="first"
    //输出：first
    println(user.name)

    //没有改变值
    user.name="first"
    //改变值，输出：first -> second
    user.name="second"
    //改变值，输出：second
    println(user.name)
}





/*
使用vetoable()方法
除observable()方法外，vetoable()方法的也可以用于观察者属性委托。
这两者的区别是：vetoable()方法的lambda表达式包含布尔类型的返回值。
若返回true，则执行对属性的修改；若返回false，则可以取消对该属性的修改
 */
//【举例】用vetoable()方法实现观察者属性委托
var age:Int by Delegates.vetoable(0){_,_,new ->
    //下面这句的意思是if (new<20) true else false
    new<20
}

/*
在这段代码中，当用户的年龄小于20时，Lambda表达式才会返回true。
所以如果设置的年龄大于20，则修改属性的操作无效。下面测试一下属性委托功能。
fun main(){
    val user=User()
    user.age=10
    //输出：10
    println(user.age)

    user.age=20
    //输出：10
    println(user.age)
}
 */