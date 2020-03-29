package p2_intermediate.p2_classAndObject.p6_constructionMethod

/*
1.主构造方法
（1）主构造方法的定义
主构造方法紧跟在类的声明之后。
kotlin规定：所有对象在被创建时都必须用构造方法进行初始化。
如果在定义类时省略主构造方法，或者说没有显式提供主构造方法，则编译器会在编译时自动给类添加一个不带任何属性的默认主构造方法。
只有位于类的首部，才是主构造方法。
所有类都必须有且仅有一个主构造方法。

语法：
下面是主构造方法的声明语法。其中紧跟类名后面的有访问控制符、“constructor”关键字、属性列表构成的部分就是主构造方法。
class 类名 访问控制符  constructor (属性列表) {}

· 关键字constructor：在Java中，构造方法名须和类名相同；
                 而在Kotlin中，是通过constructor关键字来标明的，
                 且对于Primary Constructor而言，它的位置是在类的首部（class header）而不是在类体中（class body）。

· 关键字init：init{}它被称作是初始化代码块（Initializer Block），
            它的作用是为了Primary Constructor服务的，
            由于Primary Constructor是放置在类的首部，
            是不能包含任何初始化执行语句的，这是语法规定的，那么这个时候就有了init的用武之地，
            我们可以把初始化执行语句放置在此处，为属性进行赋值。
上面这两点话引用自https://blog.csdn.net/xlh1191860939/article/details/79412319

· constructor关键字————当主构造方法前不包含任何访问控制符或者注解时，在声明主构造方法是可以省略该关键字。
· 访问控制符————分为public（默认，可以省略）、protected、internal、private四种。
· 属性列表————有些类似函数的参数列表。
            区别是，在属性列表中各属性的属性名前需要加上“val”或者“var”关键字，而函数的参数列表则不需要。
            这里的“val”关键字代表声明了只读属性，而“var”关键字代表声明了可写属性。
            如果像参数列表一样在属性名前没有加上“val”或者“var”关键字，则该参数不会作为类的属性被定义，
            而是作为类的初始化参数存在。
 */

/*
（2）使用主构造方法
 */
//【举例】创建一个表示按钮的类，该类的主构造方法拥有文字、宽度和长度三个属性。
class Button1(var text:String,val width:Int,val height:Int){}
/*
上面的代码中的(var text:String,val width:Int,val height:Int)就是该类的主构造方法，
这里由于采用了默认的访问控制符，所以，可以直接省略类名后面的“constructor”关键字。
其中text为可写属性，width和height为只读属性。
 */

/*
（3）构造方法的默认值
构造方法本身只是一个特殊的方法，所以方法的默认参数值仍然可以被使用
 */
//【举例】为按钮类上显示的文章设置一个默认值。
class Button2(var text:String="Click",val width:Int,val height:Int){}



/*
2.初始化代码块
kotlin中的主构造方法没有方法体，不能像java一样直接编写多个语句进行初始化工作，
但是kotlin提供了实现同一功能的机制————初始化代码块。
注意:虽然主构造方法没有方法体。但是副构造方法可以有方法体，可以在副构造方法的方法体中写初始化代码。

初始化代码块是使用“init”关键字修饰的代码块，代码块中的所有可执行语句都属于主构造方法的一部分，
所以每创建一个对象，初始化代码块都会被执行一次。
一个类中可以同时创建多个初始化代码块，它们之间的执行顺序和代码的摆放位置保持一致。
 */
//【举例】在Button3类中定义两个打印语句的初始化代码块。
class Button3(var text:String="Click",val width:Int=0,val height:Int=0){
    init {
        println("执行初始化语句块一")
    }
    init {
        println("执行初始化语句块二")
    }
}



fun main() {
   val button1=Button3()
   val button2=Button3()
}

/*
初始化代码块还有一个用处————结合初始化参数对类的属性进行初始化操作。
 */
class Button4(var text: String,val width: Int,height: Int){
    val processHeight:Int
    init {
        processHeight=if (height<0) 0 else height
    }

    //其实可以直接这样写：val processHeight:Int = if (height<0) 0 else height
}