package p2_intermediate.p7_genericParadigm.p5_typeErasure

/*
5 类型擦除
本节将介绍类型擦除的概念，以及如何用内联函数消除类型擦除的影响。

1 类型擦除的概念
Kotlin语言和Java语言一样，其泛型声明仅存在于编译期。
在编译过程中，编译器会检查传递的类型实参是否符合类型形参的限制。
在编译后，字节码中并不会保留该类型实参的相关信息，
所以程序在运行时是无法获得类型参数的完整信息，这个特性就被称为类型擦除。


由于存在类型擦除，所以在实际编程中无法将类型参数当作普通类型来使用，
即不能通过类型参数来创建对象，也不能用“is”运算符判断泛型对象是否包含指定的类型参数(如: obj is Holder<Int>)。
为了解决这种问题，在实际编程中， 往往在传递类型实参时也需要传递该类型实参的类型引用。
*/
//[举例]创建一个fillList()方法，用于向列表中填充任意数据的数据。
//该方法包含一个类型参数和该类型参数所在的真实类型的引用。具体代码如下:

fun <T> fillList(list: MutableList<T>, size: Int, clazz: Class<T>) {
    for (i in 1..size) {
        val obj = clazz.newInstance()
        list.add(obj)
    }
}


/*
2内联函数和类型擦除
为了消除类型擦除的影响，开发者往往需要为函数增加一个额外的参数。
那是否有办法消除类型参数的影响呢?
答案是可以通过内联函数来实现。

内联函数在编译时会被复制到该函数的调用处，此时内联函数的类型形参也会被调用处的真实类型替代，
所以内联函数不会受到类型擦除的影响。

在使用内联函数避免类型参数时,除需要将函数修饰为内联函数外，还需要用关键字“reified”修饰该类型参数，
该关键字会告诉编译器应该在代码编译时用真实的类型参数替换这里的类型参数。
*/
//[举例]用内联函数向列表中填充任意类型的数据。由于类型不会被擦除，所以无须将真实类型(Class 对象)作为参数进行传递。具体代码如下:
inline fun <reified T> fillList(list: MutableList<T>, size: Int) {
    for (i in 1..size) {
        val obj = T::class.java.newInstance()
        list.add(obj)
    }
}


