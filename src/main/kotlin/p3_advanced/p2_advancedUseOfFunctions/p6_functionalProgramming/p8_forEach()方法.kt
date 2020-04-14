package p3_advanced.p2_advancedUseOfFunctions.p6_functionalProgramming

/*
[语法]
forEach(action: (T) -> Unit): Unit
forEach（）方法用于对容器元素进行遍历操作。
*/
//[举例]用forEach()方法遍历列表。具体代码如下:
fun main() {
    val numbers1 = listOf(1, 2, 3, 4, 5, 6)
    //输出: 1->2->3->4->5->6->
    numbers1.forEach{ print("$it->")}
}
