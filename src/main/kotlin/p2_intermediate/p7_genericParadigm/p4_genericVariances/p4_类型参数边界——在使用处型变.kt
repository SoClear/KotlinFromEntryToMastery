package p2_intermediate.p7_genericParadigm.p4_genericVariances

/*
2和3 节提到的协变和逆变的类型参数都应用在类声明上，
此时类型参数的作用范围为整个类，这种型变方式也被称为“在声明处型变”。

在声明处型变会对类中的所有方法起到限制作用，
所以，如果一个 类需要同时拥有输入类型和输出类型的能力，则这种型变方式就无能为力了。
解决办法是:将型变的作用范围缩小，一直缩小到函数内部。
这种型变方式被称为“在使用处型变”。
在使用处型变仅限制了函数的参数类型。

在使用处型变时，需要在函数的类型参数前加上协变前缀“out” 或逆变前缀“in”。
*/
//[举例]在函数上添加在使用处协变的类型参数。具体代码如下:
fun covariantFun(holder: Holder<out Number>) {
    val obj: Number = holder.obj
    //下面这行会导致编译错误
    // holder.obj = 5
}

/*
在这个例子中，根据协变定义，传递到该函数的类型参数一定是Number类型的子类型(即类型参数的上界类型为Number类型)，
所以可以将参数holder赋值给Number类型的变量。
但由于不知道真实类型是Number类型的哪一个子类型，所以无法修改参数holder的值。
*/
//[举例]在函数上添加在使用处逆变的类型参数。具体代码如下:
fun contravariantFun(holder: Holder<in Number>) {
    holder.obj = 5
    val any: Any? = holder.obj
}
/*
在这个例子中，根据逆变定义，传递到该函数的类型参数一定 是Number类型的父类型，
所以可以将参数holder的值修改为任何Number类型或其子类型的值，
但由于不知道真实的父类型，所以从参数holder中取出的值只能是Kotlin中项层父类型“Any?"。
*/