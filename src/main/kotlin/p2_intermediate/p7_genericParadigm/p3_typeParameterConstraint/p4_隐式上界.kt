package p2_intermediate.p7_genericParadigm.p3_typeParameterConstraint

/*
4 隐式上界
事实上Kotlin 中的所有类型参数都必须拥有上界。如果没有显式指定上界类型，则上界类型默认为可空类型“Any?”
*/
//[举例]创建使用隐式上界的eq()方法。由于参数上界为可空类型，所以在调用参数的方法时必须使用安全操作符。 具体代码如下:
fun <T> eq(first: T,second: T): Boolean? {
// T实际上界为Any?类型
    return first?.equals(second)
}
/*
可空类型在很多时候用起来会非常不方便，要想解决这个问题，可以显式将上界类型设置为Any类型，这样参数就变成了非空类型。
*/
//[举例]手动指定类型参数上界为非空类型Any.具体代码如下:
//手动指定上界为Any
fun <T:Any> eq(first: T,second: T): Boolean {
    return first == second
}
