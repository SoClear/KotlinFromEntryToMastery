package p2_intermediate.p2_classAndObject.p8_method

/*
在第六章介绍过了，在类中可以使用operator修饰的方法来实现操作符的重写 功能。
本节介绍另一种使用operator修饰的方法————componentN方法。
 */

/*
1.定义componentN方法
componentN方法是指类似component1()、component2()、component3()等以“component”作为开始以自然数字作为结尾的方法。
componentN方法没有任何参数，其主要功能是：从对象中提取指定的属性值。
componentN方法也被称为解构方法（解析对象结构的方法）。
 */
//【举例】创建一个包含3个componentN方法的Student1类
class Student1(val name:String){
    var height=0
    var weight=0

    operator fun component1():String{
        return name
    }
    operator fun component2():Int{
        return height
    }
    operator fun component3():Int{
        return weight
    }
}

/*
在这个类中，component1()等方法分别返回了Student类中的name属性、height属性和weight属性。
接下来创建一个该类的对象，并调用这些方法，
val peter=Student1("Peter")
peter.height=180
peter.weight=70
val peterName=peter.component1()
val peterHeight=peter.component2()
 */

/*
2.解构对象
上面介绍的是直接调用componentN方法。
componentN方法的真正作用是：将对象的属性按照位置同时赋给多个变量。
 */
fun main() {
    val peter=Student1("Peter")
    peter.height=180
    peter.weight=70
    var (name,height,weight)=peter
    //输出：name=Peter
    println("name=$name")
    //输出：height=180
    println("height=$height")
    //输出：weight=70
    println("weight=$name")
}
/*
在这个例子中，peter对象的component1()方法的返回值被赋给了第1个变量————name,
component2()方法的返回值被赋给了第2个变量一height，
component3()方法的返回值被赋给了第3个变量————weight。
虽然Student类中定义了3个componentN方法，但是这并不表示在解构时也必须定义3个变量，
事实上在解构时完全可以省略位于后面的componentN方法，例如如以下代码:
val(name2，height2) = (peter)
在这段代码中，解构后的结果只赋值给了两个变量。
如果希望在解构时忽略位于前面的componentN方法，则可以将其对应的变量名设置为下画线“_”，
此时对于该位置的解构赋值操作会被忽略。下面代码只解构了component2()对应的属性值:
val (_，height3) = (peter)
 */