package p3_advanced.p2_advancedUseOfFunctions.p6_functionalProgramming

/*
filter()方法

[语法]
filter (predicate: (T) -> Boolean): List<T>
filter()方法使用参数中的predicate()的数过滤数据集并生成新的列表。
predicate()函数返回值类型为布尔类型。
若该函数返回true,则当前数据会追加到新列表中;若该函数返回false则跳过该数据。
*/
//[举例]用filter()方法获得列农中的所有偶数具体代明如下:
fun main() {
    val numbers1= listOf(1,2,3,4,5,6)
    val filterResult=numbers1.filter { it%2 == 0 }
    //输出：filter => [2, 4, 6]
    println("filter => $filterResult")
}