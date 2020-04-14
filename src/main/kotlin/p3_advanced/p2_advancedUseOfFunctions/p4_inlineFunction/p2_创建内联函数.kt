package p3_advanced.p2_advancedUseOfFunctions.p4_inlineFunction

/*

创建内联函数
在Java中，一个函数是否是内联函数是由JVM在运行时决定的，开发者无法自行指定。
而在Kotlin中，只需要在函数声明前加上“inline" 作为前缀修饰即可。
如果内联函数的参数类型是函数类型，则在该函数类型中定义的语句也会被复制。
*/
//[举例]创建个内联函数reduce()，该函数的最后一个参数为Lambda 表达式。具体代码 如下:
//第1个参数是List类型，第2个参数是函数类型
inline fun reduce(list: List<Int>, f: (Int, Int) -> Int): Int {
    var result = 0
    for (i in list) {
        result = f(i, result)
    }
    return result
}

fun main() {
    //向函数类型参数传递Lambda表达式
    val result = reduce(listOf(1, 2, 3, 4, 5)) { i, seed ->
        i + seed
    }
    //输出: 15
    println(result)
}
/*
当编译器编译该段代码时，内联函数中的语句和作为该函数参数的Lambda表达式中的语句都会被复制到main()函数的调用处，
编译结果相当于以下代码:
fun main(){
    var result = 0
    fox (1 in listOf(1,2,3,4，5){
        result = i + result
    }
    println (result)
}
内联函数是以空间换取时间来提高程序的执行效率的，
所以如果一个函数中包含大量语句，那么将其指定为内联函数会浪费大量空间，有些得不偿失。
如果一个函数只包含少量语句，那么可以将其设置为内联函数。此外，内联函数中不能包含任何本地函数或函数表达式，
所以在这种情况下也不能使用内联函数。
 */