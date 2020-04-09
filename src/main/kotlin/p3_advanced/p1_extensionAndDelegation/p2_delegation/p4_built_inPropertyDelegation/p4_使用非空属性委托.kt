package p3_advanced.p1_extensionAndDelegation.p2_delegation.p4_built_inPropertyDelegation

import kotlin.properties.Delegates

/*
4.使用非空属性委托
在Kotlin中，所有非空属性都必须在定义类时就执行初始化操作，
而非空属性委托允许将该初始化操作延迟到使用属性之前。
非空属性委托也依赖ReadWriteProperty 类的对象来实现，
但是此时需要使用单例对象Delegates的notNull()方法来创建委托对象.
 */


//[举例]在类中使用非空属性委托。具体代码如下:
class A2 {
    var notNullStr: String by Delegates.notNull<String>()
}

fun main() {
    //然后就可以在属性使用前进行赋值操作了，具体代码如下:
    A2().notNullStr="str"
}
/*
如果该属性在使用前没有赋值，则程序会抛出IllegalStateException类型的异常。
*/
