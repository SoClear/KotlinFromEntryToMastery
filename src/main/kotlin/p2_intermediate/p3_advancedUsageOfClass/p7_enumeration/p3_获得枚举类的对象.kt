package p2_intermediate.p3_advancedUsageOfClass.p7_enumeration

/*
本节会通过实例来介绍一下在实际工程中枚举类的常见使用方法。
首先创建一个表示一周的枚举类WeekDay1,本节的例子都会以这个枚举类作为基础。具体代码如下
 */
enum class WeekDay1(val abbr: String) {
    Monday("Mon"), Tuesday("Tue"), Wednesday("Wed"), Thursday("Thu"),
    Friday("Fri"), Saturday("Sat"), Sunday("Sun");

    //添加了自定义方法，所以上面的枚举常量列表需要以分号结尾
    //判断是否是工作日
    fun isWorkingDay():Boolean{
        return !(this==Saturday||this==Sunday)
    }
}
/*
这段代码中，枚举类WeekDay包含一个表示星期一到星期日的枚举常量，以及一个判断当前对象是否是工作日的方法isWorkingDay()


1.创建枚举类的对象
枚举类的对象实际就是枚举常量。
获得一个枚举对象主要有三种方法：直接引用、通过枚举举常量名引用、通过位置引用。
下面解释一一下这三种方法:
(1) 直接引用。
直接引用是指，直接通过枚举类名获得枚举对象。
[举例]通过“枚举类名枚举常量名”的形式获得了代表周一的枚举对象。具体代码如下:
val monday = WeekDay.Monday
(2)通过枚举常量名引用。
所有枚举常量都隐式包含一个name属性，该属性保存着枚举常量名。
如要使用枚举类的valueOf()方法，则可以通过这个枚举常量名获得枚举对象。
[举例] 通过Monday字符串查找名称一 致的枚举对象。具体代码如下:
val mondayByName = WeekDay.valueOf ("Monday")
/打印枚举对象的name属性，输出Monday
println (mondayByName.name )
在这个例子中，如果传入的枚举常量名不在指定的枚举类中，则程序就会抛出“java. lang. IllegalArgumentException: No enum constant”异常。
(3)通过位置引用。
枚举类有一个内置方法values(), 该方法可以数组形式返回枚举类中所有定义的枚举常量。
因此，可以通过这个该数组对象遍历整个枚举常量，也可以通过位置索引来获得指定的枚举常量。
此外，所有枚举对象也包含了一个内置属性ordinal, 这个属性的值为枚举常量在枚举列表中的位置。
[举例]通过索引“0”获得位于第1个位置的枚举对象。具体代码如下:
val mondayByOrder = WeekDay.values()[0]
//打印在枚举列表中的位置
println (mondayByOrder，ordinal)
 */