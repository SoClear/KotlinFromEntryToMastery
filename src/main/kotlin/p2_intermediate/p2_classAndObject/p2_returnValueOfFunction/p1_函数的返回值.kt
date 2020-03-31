package p2_intermediate.p2_classAndObject.p2_returnValueOfFunction

//1.在函数中返回值
fun add(x:Int,y:Int):Int{
    return x+y
}

//2.了解返回值的数据类型
//方式一：省略返回值类型
fun test(){}
//方式二：指定返回值类型为Unit,Unit代表没有返回值，和java中的void一样
fun test1():Unit{}

//3.在函数中同时返回多个值——Pair类型与Triple类型
/*
Pair类型的对象可以同时接受两个参数，并将它们保存到其内部的属性first和second中。
Triple类型的对象可以同时接受3个参数，并将它们保存到其内部的属性first，second和third中。
 */
//返回两门成绩
fun getTwoScores():Pair<Int,Int>{
    return Pair(100,80)
}

//返回三门成绩
fun getThreeScores():Triple<Int,Int,Int>{
    return Triple(100,80,70)
}



fun main() {
    val addResult= add(2, 3)
    println(addResult)
    val mathChinese= getTwoScores()
    val mathChineseEnglish=
        getThreeScores()
    println("数学成绩是${mathChinese.first},语文成绩是${mathChinese.second}")
    println("数学成绩是${mathChineseEnglish.first},语文成绩是${mathChineseEnglish.second},英语成绩是${mathChineseEnglish.third}")
}