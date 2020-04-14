package p3_advanced.p2_advancedUseOfFunctions.p6_functionalProgramming

/*
[语法]
flatMap (transform: (T) -> Iterable<R>): List<R>

flatMap()方法使用参数中的transform()函数将数据集中的数据抽出，从而获得拍平后的输出结果。
在实际工程中，flatMap()方法的主要作用是将多个 List 类型中的数据抽取出来组装成一个List类型的数据。
*/
//[举例]在元素为列表的列表上使用flatMap()方法。具体代码如下:
fun main() {
    val numbers1 = listOf(1, 2, 3, 4, 5, 6)
    val numbers2 = listOf(10, 20, 30)
// numbers中的元素是List对象
    val numbers = listOf(numbers1, numbers2)
//拍平numbers
    val flatMapResult: List<Int> = numbers.flatMap { list -> list.map { it * 10 } }

//输出:flatMap => [10, 20, 30, 40, 50, 60, 100, 200, 300]
    println("flatMap => $flatMapResult")
}
/*
在这个例子中，faMap()方法将 numbers中的所有元素都抽出组成一个新的列表flatMapResult。
如果仅需要拍平容器类型而不进行任何其他操作，则可以直接调用flatten()法
*/
//[举例]用flatten()拍平列表。具体代码如下:
//输出：flatten => [1,2,3,4,5,6,10,20,30]
//println("flatten => ${numbers.flatten()}")
