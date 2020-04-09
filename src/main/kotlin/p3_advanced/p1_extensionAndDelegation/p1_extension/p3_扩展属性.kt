package p3_advanced.p1_extensionAndDelegation.p1_extension

/*
3 扩展属性
扩展属性在底层实现上并不是为类添加一个新的属性，而是为类增加特殊的Getter和Setter方法。
已经定义过的类本身没有额外空间来存储新的属性值，所以扩展属性不能有初始值和幕后字段。
声明扩展属性的语法和声明普通属性的语法类似，只是在属性名前需要添加属性的接收者类型。
*/
//[举例]为List 类添加一个能够直接访问该类的第2个元素的展属性。具体代码如下:
//包含Getter方法的扩展属性
val <T> List<T>.second: T
    get() = this[1]

fun main() {
    //读取属性值并打印到控制台上
    val list= listOf(1,2,3)
    //输出2
    println(list.second)
}