package p3_advanced.p2_advancedUseOfFunctions.p3_lambdaExpressions

/*
3 作为参数的Lambda表达式
如果函数参数列表中的最后一一个参数是函数类型，且需要传递到参数的实参为Lambda表达式，
则Kotlin允许将该Lambda表达式提取到参数列表的小括号之外。
[举例]创建最后一个参数为函数类型的函数，并向该参数传递一个Lambda表达式。具体代码如下:
 */
//第一个参数是List类型，第二个参数是函数类型
fun reduce(list: List<Int>, f: (Int, Int) -> Int): Int {
    var result = 0
    for (i in list) {
        result = f(i, result)
    }
    return result
}

/*
由于传递到reduce()函数的最后一个参数是Lambda表达式，所以可以将它提取到小括号之外，具体代码如下:
*/
val result = reduce(listOf(1, 2, 3, 4, 5)) { i, seed ->
    i + seed
}
/*
此外，如果函数仅有一个参数， 且该参数为函数类型，则传递Lambda表达式时可以省略函数调用时的小括号。
*/
