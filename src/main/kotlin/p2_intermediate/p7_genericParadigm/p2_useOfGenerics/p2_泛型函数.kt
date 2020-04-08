package p2_intermediate.p7_genericParadigm.p2_useOfGenerics

/*

1. 泛型函数
如将泛型应用在函数上，则需要把类型形参放在函数声明处“fun”关键字的后面。
*/
//[举例]以下代码创建了一个泛型函数echo(),函数声明语句中的“<T>”就是该函数的泛型类型形参。
fun <T> echo(t:T): T {
    return t
}
/*
在这个例子中，函数echo()前面的“<T>”为类型形参，
参数和返回值中的字母“T”表示实际使用的泛型类型。
由于Kotlin支持类型推断，所以在创建对象或调用方法时类型实参可写可不写，具体代码如下:
*/
fun main() {
    //声明类型实参
    val m: Int = echo<Int>(1)
    //省略类型实参
    val n = echo(1)
}

/*
在声明泛型函数时，也可以同时指定多个类型形参，这些类型形参之间需要以逗号“，”分隔。
*/
//[举例]在同一个函数上使用两个类型形参。具体代码如下:
// <K>和<V>都是该函数的类型形参
fun <K,V> printKV(k: K, v: V) {
    println("key is $k，value 1s $v")
}
