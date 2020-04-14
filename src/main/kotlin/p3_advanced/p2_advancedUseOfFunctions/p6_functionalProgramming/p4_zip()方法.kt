package p3_advanced.p2_advancedUseOfFunctions.p6_functionalProgramming

/*
语法：
zip(other: Array<out R>): List<Pair<T,R>>

zip()方法的主要作用是:按位置连接两个数据集中的数据，生成一个新的数据集。
新的数据集的长度取决于两个数据集中长度更短的数据集。
*/
//[举例]用zip()方法连接两个列表。具体代码如下:
fun main() {
    val numbers1 = listOf(1, 2, 3, 4, 5, 6)
    val numbers2 = listOf(10, 20, 30)

//连接numbers1和numbers2两个列表
    val zipResult1: List<Pair<Int, Int>> = numbers1.zip(numbers2)
//输出: zip1 => [(1, 10)， (2, 20)， (3, 30)]
    println("zip1 => $zipResult1") // [(1， 10)，(2， 20)，(3, 30)]

    val zipResult2: List<Pair<Int, Int>> = numbers2.zip(numbers1)
//输出: zip2 => [(10， 1)， (20， 2)， (30， 3)
    println("zip2 => $zipResult2") // [(10, 1)，(20，2)，(30，3)] )
}
/*
在这个例子中，由于numbers1列表的长度是6,而numbers2列表的长度是3，所以生成的新列表长度只能是3。
*/
