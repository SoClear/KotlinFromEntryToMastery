package p1_introductory.p8_collectionTypes

fun main() {
    /*
    序列——一组数据
    序列类型是一种惰性集合类型。
    序列中的数据是在代码运行期间动态生成的，所以它可以表示超过内存大小的数据范围。
     */
    //1.在创建序列时指定元素
    /*
    语法：
    sequenceOf(元素列表)
     */
    val seq = sequenceOf(1, 2, 3)
    for (i in seq) {
        println(i)
    }

    //2.用函数创建序列
    /*
    语法：
    generateSequence(seed){
        Lambda表达式
    }
    seed：可以接受任何数据类型，主要用于提供创建序列中的元素的基准值。
    Lambda表达式：用于创建序列中的元素，程序在运行时会一直重复执行该Lambda表达式。
    若Lambda表达式返回非空数据，则该数据会作为序列的元素和新的seed值；
    若返回空值，则在序列创建完毕之后，程序停止执行lambda表达式。
    另外，也可以在Lambda表达式中通过隐式参数it获得当前的seed值
     */

    val seqs = generateSequence(3) {
        val t = it + 5
        if (t > 20) null else t
    }

    for (i in seqs) {
        println(i)
    }

    //在使用该函数时无法获得上一个创建的元素。
    var ss = 0
    val seqs1 = generateSequence {
        ss++
        if (ss <= 6) 3 else null
    }

    for (i in seqs1) {
        println(i)
    }
}