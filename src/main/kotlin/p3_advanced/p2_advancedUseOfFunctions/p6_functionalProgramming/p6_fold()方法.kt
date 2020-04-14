package p3_advanced.p2_advancedUseOfFunctions.p6_functionalProgramming

/*
[语法]
fold(initial: R, operation: (acc: R, T) -> R): R

fold()方法和reduce()方法类似，也是用于对数据进行累计操作。
但是，fold()方法可以指定初始累计值，该累计值的类型会作为最后累加结果的类型。
即: reduce()方法要求累计值类型和结果类型一致，而fold()方法没有该限制。
除该方法外，Kotlin 还提供了foldRight()方法，用于从右开始进行累计操作。
*/
//[举例]用fold()方法和foldRight()方法累计列表中的值。具体代码如F:
fun main() {
    val numbers1 = listOf(1, 2, 3, 4, 5, 6)
//从左开始累计，初始累计值为2,累计过程是将累计值减去当前值
    val foldLeftResult = numbers1.fold(2) { acc, n -> acc - n }
//输出: foldLeft => -19
    println("foldLeft→> $foldLeftResult")
//从左开始累计，初始累计值为0， 累计过程是将累计值加上当前值
    val foldRightResult = numbers1.foldRight(0) { acc, n -> acc + n }
//输出: foldRight => 21
    println("foldRight => $foldRightResult")
}
