package p3_advanced.p1_extensionAndDelegation.p2_delegation.p3_propertyDelegation

import kotlin.reflect.KProperty

/*
除方法委托外，Kotlin 还支持属性委托。
属性委托默认是线程安全的，其底层实现是:将指定属性的Setter/Getter访问器的调用过程委托给其他类的setValue/getValue方法来执行。
所以，不能为委托属性添加自定义的Setter/Getter访问器。

[语法]
val/var <属性名>: <类型> by <委托对象>

在使用属性委托时，除使用上面的语法修饰属性外，还需要在委托类中提供setValue()和getValue()两个方法。
*/
//[举例]使用属性委托。
//(1)创建Logger类，该类包含一个委托属性loglevel.该属性的读写操作都被委托给Delegate类的对象来执行，具体代码如下:
class Logger {
    //该属性被委托给Delegate类的对象
    var logLevel: Int by Delegate()
}

//(2)创建Delegate 类，在类中创建setValue()和getValue()方法来处理委托属性，具体代码如下:
class Delegate {
    private var logLevel = -1

    //委托Getter访问器
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): Int {
        return logLevel
    }

    //委托Setter访问器
    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: Int) {
        logLevel = value
    }
}


//(3)测试该委托属性，具体代码如下:
/*
fun main() {
    val logger = Logger()
    logger .logLevel = 3
    //输出结果: 3
    println(logger.logLevel)
}
*/

/*
在这个例子中，getValue()方法 和setValue()方法中的参数“thisRef"表示实际被委托的对象(即Logger类的对象);
参数“prop"表示对委托属性的引用;
seValue()中的参数“value” 为设置属性时传递的值。


提示:
getValue()方法的返回值和委托属性的类型必须保持一致。
在使用属性委托时，委托类的getValue()方法的返回值必须与委托的属性相同或者是委托属性的父类型。


从Kotlin 1.1起，属性委托不仅可以应用在类的成员上，也可以应用在局部变量上。
*/
//[举例]将属性委托应用在局部变量上。具体代码如下:
class DelegationVal {
    operator fun getValue(nothing: Nothing?, property: KProperty<*>): String {
        return "hello world"
    }
}

fun main() {
    //main()函数中的局部变量
    val str:String by DelegationVal()
    //输出结果 hello world
    println(str)
}
