package p3_advanced.p2_advancedUseOfFunctions.p6_functionalProgramming

/*
map()方法
[语法]
map(transform: (T) -> R) :List<R>

map()方法使用参数中的transform()函数处理数据集中的所有数据，
处理后的结果值可以和数据本身的类型不同。
在实际工程中，map()方法的主要作用是进行数据转换————将一种类型的数据转换为另一种类型的数据。
*/
//[举例]在整型数组和列表上使用map()方法。具体代码如下:
fun main() {
    val numbers1 = intArrayOf(1,2,3,4,5, 6)
    //将Int型计算后转换为Int型
    val numbers1Ret=numbers1.map { it*10}
    //输出: [10, 20，30，40, 50, 60]
    println (numbers1Ret)
    val score = listOf(20, 30, 70)
    //将Int类型转换为String类型
    val scoreRet=score.map { if (it>60) "及格" else "还需努力"}
    //输出：[还需努力，还需努力，及格]
    println(scoreRet)
}