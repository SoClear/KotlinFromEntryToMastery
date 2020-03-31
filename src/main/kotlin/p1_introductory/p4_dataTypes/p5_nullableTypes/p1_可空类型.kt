package p1_introductory.p4_dataTypes.p5_nullableTypes

fun main() {
    var nullableString:String?="可以为空"
    val nullableString2:String?=null
    //如果直接使用nullableString2.length会报错
    println(nullableString2?.length)

    //用安全操作符调用可空字符串的方法
    nullableString2?.substring(1,10)

    //用安全操作符使得链式调用变得安全
    nullableString2?.substring(1,10)?.substring(5)?.replace("java","kotlin")

    //可空类型只能赋给另一个可空类型，不能赋给另一个非空类型,下面这行会报错
    //val nullableString3:String = nullableString2

    //使用安全操作符不会改变可空性，下面这句会报错
    //val len:Int=nullableString2?.length

    //强制调用 !! 操作符，用来在一个可空类型上调用方法或属性，或者将可空对象赋给非空变量
    //方法一：将可空对象赋给非空变量
    val len1:Int=nullableString2?.length!!
    //方法二：在可空对象上强制访问属性
    val len2:Int=nullableString!!.length
}