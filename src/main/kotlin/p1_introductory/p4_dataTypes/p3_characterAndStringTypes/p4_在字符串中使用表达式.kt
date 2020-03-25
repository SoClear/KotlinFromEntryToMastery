package p1_introductory.p4_dataTypes.p3_characterAndStringTypes

/*
语法：
${表达式}
 */
fun main() {
    val greeting="Hello"
    val name="Peter"
    val age=18
    val words="$greeting,my name is $name,I'm $age years old."
    println(words)
}

/*
注意在字符串模板中直接输出$符号，需要使用${'$'}这样的形式
 */