package p1_introductory.p6_processControl

fun main() {
    //1.if语句
    /*
    语法：if(条件){
        代码块
        }
     */

    //2.if...else
    /*
    if(条件){
        代码块1
    }else{
        代码块2
    }
     */

    //3.if...else if...else
    /*
    if(条件){
        代码块1
    }else if{
        代码块2
    }else{
        代码块3
    }
     */

    //4.单行if表达式（if语句可以有返回值）
    /*
    单行if表达式一般用来替代java中的三元表达式
     */
    var money = 66
    money = -6
    val myMoney = if (money < 0) 0 else money

    //5.多行if表达式
    /*
    多行if表达式，自动返回分支的最后一行语句的计算结果
     */
    val n1 = 10
    val n2 = 50
    //result变量是字符串类型
    val result = if (n1 < n2) {
        val diff = n2 - n1
        "n2-n1=$diff"
    } else {
        val diff = n1 - n2
        "n1-n2=$diff"
    }
    println(result)

    //6.when代码块
    /*
    语法：
    when{
        条件一 -> 代码块一
        条件二 -> 代码块二
        条件n -> 代码块n
        else -> else代码块
    }

    when代码块中可以包含多个不相关的条件语句。因此when代码块可以被看作是将一堆不同的if语句聚合在一起。
    当when代码块包含多条语句时，也需要将这些语句包含在大括号中。如果不需要默认处理逻辑，则最后的else分支也可以被省略。
     */
    when {
        3 + 3 == 6 -> println("3+3=6")
        2 < 9 -> println("2<9")
        else -> println("else")
    }


    //7.when语句
    /*
    语法
    when(变量){
        条件一 -> 代码块一
        条件二 -> 代码块二
        条件n -> 代码块n
        else -> else代码块
    }

    when语句和when代码块有以下不同点：
    when语句的条件都基于同一个变量的值，而when代码块的分支则没有这个限制。
     */
    val language = "kotlin"
    when (language) {
        "java" -> println("学习java")
        "kotlin" -> println("学习kotlin")
    }

    //8.when表达式
    /*
    when表达式作返回值用，必须有最后的else分支
     */
    var lang = "kotlin"
    var currentLang = when (lang) {
        "java" -> "学习java"
        "kotlin" -> "学习kotlin"
        else -> "学习其他JVM语言"
    }

    lang = "java"
    currentLang = when (lang) {
        "java", "kotlin" -> "学习jvm语言"
        "JavaScript", "TypeScript" -> "学习脚本语言"
        else -> "学习其他语言"
    }

    val score = 99
    var final = when (score) {
        in 90..100 -> "优秀"
        in 80..89 -> "良好"
        in 60..79 -> "一般"
        else -> "还需努力"
    }
    final=when(score){
        !in 60..100 -> "没有及格"
        !in 80..89 -> "没有达到良好"
        !in 90..100 -> "没有达到优秀"
        else -> "还需努力"
    }

    var unknown:Any="哈哈哈"
    println(when(unknown){
        is Int -> "参数为Int类型"
        is Boolean -> "参数为Boolean类型"
        is String -> "参数为String类型"
        else -> "参数未知类型"
    })

}