package p2_intermediate.p3_advancedUsageOfClass.p7_enumeration

/*
语法：
enum class 类名{
    枚举常量列表
    其余部分
}

村举类由枚举常量列表和其余部分组成。
枚举常量列表包含一个或多个以逗号(,)分隔的枚举常量。
在创建枚举类时，枚举常量列表必须放在首行，而其余部分则可以被省略。
所有枚举类都继承自类库中的kotlin.Enum类型。
枚举类的构造方法是私有的，并且枚举类不能被继承。
*/
//[举例]创建一个表示周末的枚举类，该枚举类包含周六和周日两个枚举常量。具体代码如下:
enum class Weekend {
    Saturday, Sunday
}

/*
这个例子中的枚举类不包含其余部分。如果存在其余部分，则枚举常量列表必须以分号“;”作为结尾。
*/
//[举例]在表示周末的枚举类Weekend中添加一个空方法idle(),此时必须为枚举常量列表添加分号，否则编译器会直接报错。具体代码如下:
enum class Weekend1 {
    //注意后面的分号
    Saturday, Sunday;

    fun idle() {}
}

/*
枚举类的构造方法可以包含属性，但是由于枚举类的构造方法是私有的，所以不能在类外创建该枚举类的对象。
*/
//[举例]创建表示一周的枚举类 WeekDay, 并在该类的主构造方法中定义了一个表示星期的英文缩写的属性abbr。具体代码如下:
enum class WeekDay(val abbr: String) {
    Monday("Mon"), Tuesday("Tue"), Wednesday("Wed"), Thursday("Thu"),
    Friday("Fri"), Saturday("Sat"), Sunday("Sun")
}
/*
从这个例子中可以看到，由于枚举类包含了一个String 类型的属性，
所以枚举常量也必须传递一个String类型的参数，
这是因为:枚举常量其实就是该枚举类的对象。
*/