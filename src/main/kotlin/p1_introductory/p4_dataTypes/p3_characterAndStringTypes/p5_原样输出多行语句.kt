package p1_introductory.p4_dataTypes.p3_characterAndStringTypes

fun main() {
    /*
    kotlin中的换行符和java一样是字符“\n”，所以在kotlin程序中编写多行语句时，
    必须在每一行最后都添加换行符。
    */
    val multipleLines="one,two,three,\n"+
            "four,five,six,\n"+
            "seven.eight,nine,ten"

    println(multipleLines)
    /*
    在这段代码中使用了换行符“\n”和字符串连接符“+”，字符串的实际输出结果变得非常不直观。
    为了解决这个问题，kotlin提供了原样输出功能，即直接把按源代码里的代码格式进行输出。
    原样输出的语法非常简单，就是就原来包裹字符串的双引号换成连续的3个双引号（"""  """）。
    语法：
    """字符串"""
     */
    //【举例】将上面的例子替换为原样输出
    val multipleLines2="""one,two,three,
        four,five,six,
        seven,eight,nine,ten
    """.trimIndent()
    println(multipleLines2)
    /*
    在这种情况下，源代码中3个双引号之间的所有空格和换行都会被保留。
     */


    val multipleLines3="""|It was the best of times.
        |   It was the worst of times.
        |       It was the age of wisdom.
        |           It was the age of foolishness.
    """.trimMargin("|")
    println(multipleLines3)
}