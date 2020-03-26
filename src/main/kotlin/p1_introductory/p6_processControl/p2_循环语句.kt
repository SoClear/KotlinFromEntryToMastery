package p1_introductory.p6_processControl
fun main() {
    //1.while循环
    /*
    语法：
    while(条件){
        代码块
    }
     */
    val max=3
    var i=0
    while (i<max){
        println("repeat while $i")
        i++
    }

    //2.do...while循环
    /*
    语法：
    do{
        代码块
    }while(条件)
     */

    //3.for循环
    /*
    语法：
    for(常量 in 区间对象 / Iterable对象){
        代码块
    }
     */
    for (a in 0..3){
        println("repeat range $a")
    }

    val min1=1
    val max1=5
    for (i in min1..max1){
        print("For $i ")
    }

    //4.repeat语句
    /*
    语法：
    repeat(循环次数){
        Lambda表达式
    }

    在lambda表达式中可以通过隐式参数it获得当前循环次数
     */
    println()
    repeat(3){
        println("repeat $it times")
    }
}