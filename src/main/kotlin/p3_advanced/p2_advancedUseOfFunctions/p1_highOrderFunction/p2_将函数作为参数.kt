package p3_advanced.p2_advancedUseOfFunctions.p1_highOrderFunction

/*
函数类型可以作为函数的参数类型。
由于函数类型只限制了参数列表和返回值类型，
所以拥有不同实现的函数可以传递给同一个函数类型的形参。
 */
//【举例】创建自增函数inc(),，并将函数类型只限制作为高级函数apply100()的参数。
//inc和dec为函数类型
val inc=fun(x:Int):Int{
    return x+1
}

val dec=fun(x:Int):Int{
    return x-1
}

//高阶函数，参数为函数类型
fun apply100(f: (Int) -> Int ):Int{
    //调用函数参数，并传入实参100
    return f(100)
}

fun main() {
    //传递函数类型
    //输出：101
    println(apply100(inc))
    //输出：99
    println(apply100(dec))
}

/*
从这个例子中可以看到，函数inc()实现了递增功能，而函数dec()实现了递减功能。
这两个函数的功能完全不一致，但是由于它们的函数类型都是“(Int) -> Int”，所以可以当它们作为参数传递给同一个高阶函数。
 */