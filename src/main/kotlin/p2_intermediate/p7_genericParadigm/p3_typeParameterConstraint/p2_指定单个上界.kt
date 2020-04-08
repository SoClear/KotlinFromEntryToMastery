package p2_intermediate.p7_genericParadigm.p3_typeParameterConstraint

/*
16.3.2 指定单个上界
在为类型参数指定单个上界时，只需要在该类型参数后加上冒号“:” 和上界类型即可，上界既可以用在类上，也可以用在函数上。
*/
//[举例]将上界类型Number应用在函数sum0)上。 具体代码如下:
fun<T: Number> sum(first: T,second: T):T{
return (first.toDouble() + second.toDouble()) as T
}
/*
然后，传入不同类型的数据，
测试一下该函数。具体代码如下:
*/
fun main() {
    //输出: 3
    println(sum(1, 2))
    //输出: 1.
    println(sum(1.4, 0.3))
    //输出: 30.3
    println (sum(10,20.3))
    //这条语句会引起编译错误， 字符串不是Number类型的子类
    //println (sum ("one", "two"))
}


/*
从这个例子中可以看到，类型参数的上界为Number类型，所以该函数的参数必须为Number类型的子类型。
如果将String 等类型的参数进行传递，则编译器会直接报错。
另外，由于参数的实际类型肯定兼容Number类型，
所以在函数体内可以调用Number类型的toDouble()方法将两个参数值转换为Double类型后再进行相加。
*/