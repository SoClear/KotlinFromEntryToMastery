package p1_introductory.p4_dataTypes.p3_characterAndStringTypes

import java.lang.StringBuilder

fun main() {
    /*
    1.用“+”号连接多个字符串
    在kotlin中，如果“+”号左边是字符串，则“+”就会被编译器重载为字符串的连接符；
    如果“+”号左边是数字，则“+”会被当做数学运算中的加法运算符。
     */

    val a = "first"
    val b = "second"
    val c = a + b
    println(c)

    /*
    2.依次打印字符串中的字符
    在下面的例子中，for循环会从字符串中提取字符数组，并依次赋值给变量aChar.
    */
    val aString1="hello world"
    for (aChar in aString1){
        println(aChar)
    }


    /*
    3.获得字符串中的某一个字符
     */
    val aString2="hello world"
    val aLetter=aString2[4]
    println(aLetter)


    /*
    4.获得字符串中一个范围内的子串（字符串中的某一段）
     */
    val aString3="hello world"
    val aSubString=aString3.substring(5,8)
    println(aSubString)
    /*
    该方法的第一个参数为闭区间，第二个参数为开区间。
    对“aString3.subString(5,8)”来说，下标为5的字符会包含在子串中，而下标为8的字符不会包含在子串中。
     */


    /*
    5.替换字符串
    下面这个例子中，replace(source,target)方法使用指定的子串替换字符串中原有的子串。
     */
    val source="java is a programing language"
    source.replace("java","kotlin")
    println(source)

    val target=source.replace("java","kotlin")
    println(target)
    /*
    由于字符串是不可变的，所以该方法实际上返回的是一个新创建的字符串。
     */


    /*
    6.通过StringBuilder对象连接多个字符串。
    kotlin指定字符串是不可变的，所以每次连接字符串时都会创建新的字符串，比如以下代码：
    var str="one,"+""+"two,"+"three,"+"four"
    这段代码会在内存中创建以下7个字符串：
    one,
    two,
    three,
    four
    one,two,
    one,two,three,
    one,two,three,four

    可以看到，像“one,two,”和“one,two,three,”这样的字符串实际是没有任何作用的，纯粹浪费内存空间。
    随着需要连接的字符串个数越来越多，这种内存空间的浪费也会越来越严重。
    为了解决这个问题，可以用StringBuilder对象来连接多个字符串。
    该对象只有在最后调用toString()时才会实际生成字符串对象。
     */
    //【举例】用StringBuilder对象连接多个字符串
    val builder=StringBuilder()
    builder.appendln("hello,")
    builder.append("world")
    //获得连接后的字符串
    val content=builder.toString()
    println(content)
    /*
    在这个例子中，append()方法用于追加字符串,appendln()方法用于追加字符串和换行符，toString()方法用于生成连接后的字符串。

    上面这种写法与java中的写法一致。
    在kotlin中，可以用更简单的lambda表达式来实现同样的功能。
     */
    val content1= buildString {
        appendln("hello,")
        append("world")
    }
    println(content1)

    /*
    提示：
    现在的编译器是非常智能的，当我们用“+”号作为连接符时，底层会自动将其转为使用StringBuilder对象来连接多个字符串。
    尽管如此，我们还是应该自己手动创建StringBuilder对象。
     */
}