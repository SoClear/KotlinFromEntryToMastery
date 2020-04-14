package p3_advanced.p2_advancedUseOfFunctions.p6_functionalProgramming

/*
partition()方 法
[语法]
partition (predicate: (T) -> Boolean): Pair<List<T>, List<T>>

partition()方法使用参数中的predicate()函数对数据集进行分区操作，每个分区的结果会被保存为列表对象。

predicate()函数的返回值为布尔类型。
若该函数返回true,则将当前元素追加到新生成的第1个分区列表中;
若该函数返回false, 则将当前元素追加到新生成的第2个分区列表中。
*/
//[举例]用partition()方法对列表进行分区。具体代码如F:
fun main() {
    val numbers1 = listOf(1, 2, 3, 4, 5, 6)
//将数据集划分为偶数分区和奇数分区
    val partitionResult = numbers1.partition { it % 2 == 0 }

//输出: (12, 4, 6]，(1, 3, 5)
    println(partitionResult)

}