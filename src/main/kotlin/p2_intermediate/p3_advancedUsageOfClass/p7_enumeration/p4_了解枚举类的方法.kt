package p2_intermediate.p3_advancedUsageOfClass.p7_enumeration

/*
2.了解枚举对象的方法
使用枚举类中定义的方法和使用普通类中定义的方法一一样，直接通过对象(枚举常量)进行调用即可，具体代码如下:
val monday = WeekDay.Monday
println (monday.isWorkingDay())


在为枚举对象添加自定义方法时，不仅可以直接将方法定义在枚举类中，
还可以将方法定义在继承自枚举对象的匿名内部类中。
后一种方式可以让同 一个枚举类的不同枚举对象的同名方法里的代码是不一样的，
比如下面例子中asChinesePattern方法的Saturday对象和Sunday对象，一个是返回星期六，一个是返回星期日。
 */
//【举例】创建枚举类WeekEnd,该类包含一个抽象方法
enum class WeekEnd(val abbr:String){
    Saturday("Sat"){
        override fun asChinesPatter(): String {
            return "星期六"
        }
    },
    Sunday("Sun"){
        override fun asChinesPatter(): String {
            return "星期日"
        }
    };


    //定义抽象方法
    abstract fun asChinesPatter():String
}

/*
在这个例子中，枚举类包含一个抽象方法asChinesePattern()，
而枚举类中的每个匿名内部类都实现了该抽象方法，并返回以中文形式表示的星期。
使用这种方式，可以很方便地为每个枚举常量提供不同的方法实现。
除这种用法外，还可以通过让枚举类实现指定接口来达到同样的功能。下面代码演示了这种用法:
 */

//定义接口
interface ChinesePattern{
    fun display():String
}
//每个枚举类都拥有了不同的实现
enum class WeekEnd1(val abbr:String):ChinesePattern{
    Saturday("Sat"){
        override fun display(): String {
            return "星期六"
        }
    },
    Sunday("Sun"){
        override fun display(): String {
            return "星期日"
        }
    }
}