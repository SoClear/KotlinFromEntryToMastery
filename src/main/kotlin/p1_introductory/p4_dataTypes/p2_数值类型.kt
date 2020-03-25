package p1_introductory.p4_dataTypes

/**
 * 数值类型分为整型，浮点型
 *
 * 整型分为：整型(Int)、长整型(Long)、短整型(Short)
 * 浮点型分为：单精度浮点型(Float)、和双精度浮点型(Double)
 */
fun main() {
    //整型即Int型
    var aInt=100

    //长整型即Long型。只能用大写字母L作为后缀，因为小写l与数字1容易混淆
    var aLong=100L

    //短整型即Short型
    var aShort:Short=100

    //包含下划线的文字，相当于1000000000
    var money=1000_000_000
    var money2=1000_0000

    //十六进制,数字前加0x,或者0X
    var hex1=0xffff

    //二进制，数字前加0b,或者0B
    var bin1=0b00001

    //Kotlin不支持八进制

    //单精度浮点类型（Float）。后缀f或者F
    var aFloat=1.1f
    var aFloat2=2.2F

    //双精度浮点类型,不带后缀，默认为Double类型
    var aDouble=1.1
    var aDouble2=2.3

    //科学计数法
    //表示1.1乘10的2次方
    var sicience=1.1e2
}