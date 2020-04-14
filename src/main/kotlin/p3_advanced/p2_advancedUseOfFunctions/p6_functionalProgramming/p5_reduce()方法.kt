package p3_advanced.p2_advancedUseOfFunctions.p6_functionalProgramming

/*
reduce()方法
[语法]
reduce (operation: (acc: S, T) -> S): S

reduce()方法使用参数中的operation()函数对数据集中的所有数据进行累计操作。
在累计时，初始值为数据集中的第一条数据，累计结果和数据集中的数据类型相同。
累计的具体过程是:从左开始依次遍历数据，每次遍历时都会将累计值和当前数据进行计算。

除该方法外，Kotlin 还提供了reduceRight()方法，用于从右开始进行累计操作。
在实际工程中，reduce()方法主要用于和map()方法组成经典的"map-reduce" 操作，
即先对大数据集中的数据进行转换，然后再对结果集进行裁剪，从而得到更小的数据集或结果。
*/
//[举例]用reduce()方法和reduceRight()方法累计列表中的值。具体代码如下:
fun main() {
    val numbers1 = listOf(1, 2, 3, 4, 5, 6)
//从左开始累计，累计过程是将累计值减去当前值
//在第一次遍历时，acc的值为第一条数据， 即教字1
    val reduceLeftResult = numbers1.reduce { acc, n -> acc - n }
// 输出: reduce => -19
    println("reduce -> $reduceLeftResult")

    //从右开始累计，累计过程是将累计值加上当前值
    val reduceRightResult=numbers1.reduceRight{n,acc -> acc+n}
    //输出：reduceRight => 21
    println("reduceRight => $reduceRightResult")
}

