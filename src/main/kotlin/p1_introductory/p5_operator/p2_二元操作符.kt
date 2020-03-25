package p1_introductory.p5_operator


import java.util.*

fun main() {
    //1.四则运算操作符（+-*/）
    //2.复合操作符（+=，-=，*=，/=，%=）
    //3.比较操作符(>,<,>=,<=)
    //4.位运算方法
    /*
    and()   按位与
    or()    按位或
    inv()   按位取反
    xor()   按位异或
    shl()   左移
    shr()   右移
    ushr()  无符号右移
     */

    //5.猫王操作符?:
    /*
    用于在第一个操作符的值为空时，返回指定的默认值
     */
    val doorState = null
    val doorStateElvis = doorState ?: "Closed"
    println(doorStateElvis)

    //6.相等操作符
    /*
    相等操作符分为等同和等于两种
    等同（==）意味着两个操作数可以看做是相等的，所以它们可以是不同类型的数据
    不等同（!=）

    等于（===）意味着两个操作数是完全一样的，只有当两个操作数指向同一对象时，改方法才会返回true
    不等于（!==）
     */
    val startDate=Date(100)
    val endDate=Date(100)
    println("startDate == endDate is ${startDate==endDate}")
    println("startDate === endDate is ${startDate===endDate}")

    /*
    备注：在Kotlin中，非空的数值类型在底层实现为Java的基础类型，
    所以只要值相同，则两个非空的数值类型变量就是相等的。
    而可空的数值类型在底层实现为java基础类型的包装类型，
    所以两个可空数值类型变量是不相等的。
     */
    val m:Int?=1000
    val n:Int?=1000
    println("m===n is ${m===n}")

    //7.in和!in操作符
    /*
    in和!in操作符属于逻辑操作符，主要用于判断第一个操作符是否在第二个操作数的范围内。
    in操作符，相当于调用第二个操作数的contains()方法
    !in操作符，相当于调用第二个操作符发minus()方法
     */
    val langs="java groovy scala kotlin"
    println("java" in langs)
    println("go" !in langs)

    //8.索引操作符（[]）
    /*
    处于赋值位置（等号右边）的索引操作符，相当于调用第一个操作数的get()方法
    处于声明位置（等号左边）的索引操作数，相当于调用第一个操作数的set()方法
     */
    val song="The beauty of the song reminds me we belong together in our souls"
    println(song[2])

    //9.区间操作符（..）
    /*
    用于创建区间对象
    相当于调用了第一个操作数的rangeTo()方法
     */
    val range=1..10
    for (r in range){
        print("$r ")
    }

}