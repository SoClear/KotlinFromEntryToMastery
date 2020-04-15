package p3_advanced.p3_annotationAndReflect.p2_reflect.p3_useReflection

import kotlin.reflect.KFunction

/*
2. KFunction类型
(1)获得KFunction对象。
KFunction在反射API中代表Kotlin中的函数。在程序中可以通过“类名::方法名”这样的语法获得一个KFunction 实例。
*/
//[举例]获得KFunction类对象。
//(1)创建一个类Person1, 并在该类中创建了一个sayHello()方法， 具体代码如下:
class Person1 {
    fun sayHello(message: String) {
        println("hello $message")
    }
}
//(2)通过反射API获得sayHello()方法对应的KFunction实例，具体代码如下:
//sayHello的类型是 KFunction2<Person1, String, Unit>
val sayHello = Person1::sayHello

/*
在这个例子中，反射sayHello()方法后获得的返回值是KFunction2类型，
该类型实际不存在于任何类库中，而是在编译代码时由编译器根据方法的参数列表和返回值自动生成的。

KFunction 类型可以包含多个泛型参数，这些泛型参数中的最后一个参数代表该方法的返回值类型。
如果KFunction引用的是类中的对象(即原方法为类中的普通方法)，那么它的第1个参数必须是该类的类型。
上面例子中的“KFunction2<Person1, String, Unit>”就表示Person1是该方法的接收者，String 是方法的参数，而Unit是方法的返回值。


(2)调用KFunction对象。
KFunction类型还包含一个 invoke()方法，可以用这个方法来动态调用实际的方法。
[举例]用invoke()方法调用Person类的sayHello()方法。具体代码如下:
sayHello.invoke (person, "world")
invoke()方法的第1个参数是实际执行该方法的对象，从第2个参数开始是方法的实际参数列表。
如果参数签名(参数数量和类型)与实际方法不兼容，则编译器会直接报错。


(3)顶层函数。
KFunction类型除可以代表类中的方法外，还可以代表项层函数。
由于顶层函数是独立于类存在的，所以获得KFunction实例时无须指定类名。
[举例]获得顶层函数的KFunction对象。具体代码如下:
*/

//创建一个顶层函数
fun isOdd(x:Int)=x%2!=0

fun main() {
    //获得顶层函数对应的KFunction实例
    val odd=::isOdd
    //调用KFunction
    println(odd.invoke(3))
}
