package p1_introductory.p4_dataTypes

fun main() {
    /**
     * 1.数值类型转换
    toByte()
    toShort()
    toInt()
    toLong()
    toFloat()
    toDouble()
    toChar()
     */

/*
2.Kotlin中只有在用字面量为变量赋值时才自动转换，不支持隐式隐式向上类型转换
 */
//作为字面量的1属于Int类型
    var b:Byte=1
//下面这行报错，Kotlin不支持自动向上转型
//val i:Int=b

//3.强制类型转换
//    val foo='a'
//    val fooString:String=foo as String

//4.类型提升
/*
类型提升是指：如果两个数值类型进行运算，则结果的类型是这两个数值中范围较大的类型
如果字节型与数值型进行运算，则结果值的类型与该数值类型保持一致（即字节类型与Int类型运算结果为Int类型
字节类型与Long类型运算结果为long类型）
如果两个字节型数据进行运算，结果为Int类型
 */

//5.安全类型转换
/*定义：在强制类型转换时，如果当前类型无法转换为目标类型，则运行程序时会抛出"type mismatch"异常。
如果想避免这种异常，可以使用安全类型转换。
语法：在关键字as后面加上问号（？），若转换失败则返回空值，因此安全类型转换只能赋值给可空类型变量
 */
    var number:Int?="foo" as? Int
    println(number)

    //6.类型判断
    if ("foo" is String) println("是字符串")

    //7.智能转换
    /*
    在Kotlin中，如果编译器能从上下文推断出对象的真实类型，则在该上下文中对象会被自动转换为真实类型。
    这个特性被称为智能装换。
    在下面这个例子中，if分支限制了只有当对象为String类型时程序才能运行其中的代码。
    所以在if分支中，对象的真实类型是可见的。因此才可以在“foo”变量上调用字符串类的toUpperCase()方法。
     */
    val foo="abc"
    if (foo is String) println(foo.toUpperCase())

}