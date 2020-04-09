package p3_advanced.p1_extensionAndDelegation.p1_extension

import java.math.BigDecimal


/*
5 扩展可空类型
如果将扩展功能应用在可空类型上，则可以在扩展功能中添加当接收者为空时该如何执行的业务逻辑，
这样在实际调用可空类型的扩展功能时就不用强制加上安全操作符了。
*/
//[举例]为可空类型“BigDecimal? ”添加一个add()方法。 具体代码如下:
fun BigDecimal?.add(y: BigDecimal): BigDecimal {
//当接收者为空值时的处理逻辑
    if (this == null) {
        return y
    }
    //智能转换，this此时已经变成了非空类型
    return this.add(y)
}


//然后测试一下该扩展方法，具体代码如下:
fun main() {
    //接收者为null
    val x: BigDecimal? = null
    println(x.add(BigDecimal(100)))
    //接收者不为null
    println(BigDecimal(10).add(BigDecimal(100)))
}

/*
在这个例子中，如果扩展方法add()的接收者为空值，
则该方法会直接返回参数的值，而不是抛出空指针异常。
如果扩展方法add()的接收者不为空，则程序会将该参数值与当前对象的数据进行相加并返回计算结果。
*/
