package p2_intermediate.p2_classAndObject.p6_constructionMethod

/*
1.副构造方法的定义
副构造方法的作用是辅助主构造方法来创建对象，
所以，所有的副构造方法最终都必须调用主构造方法，
但是在调用主构造方法的过程中可以先调用其副构造方法，即间接调用主构造方法。
一个类有且仅有一个主构造方法，但是可以拥有0个到多个副构造方法。
语法：
constructor(参数列表一) : this(参数列表二)

副构造方法本质也就是一个特殊的方法。
其中冒号前面的部分表示副构造方法的参数列表，
this表示调用主构造方法或者其他副构造方法（即参数列表一就是副构造方法的形参），
this后的参数列表二是传递给调用目标（主构造方法或者其他副构造方法）的实参。

提示：在副构造方法的小括号中定义的是参数列表，而不是属性列表。
即在副构造方法中定义的只是形参，而不是属性。
只有主构造方法才能定义属性。
 */

/*
2.定义副构造方法
【举例】继续对之前定义的Button类进行修改，为其添加多个副构造方法。
 */

//主构造方法
class Button5 constructor(var text:String,width:Int,height:Int){
    //副构造方法一
    //调用主构造方法
    constructor(text: String):this(text,0,0)

    //副构造方法二
    //调用主构造方法
    constructor(width: Int,height: Int):this("",width,height)

    //副构造方法三
    //调用副构造方法一
    constructor():this("默认按钮")
}


/*
3.用副构造方法创建对象
在创建实例时，可以使用主构造方法，也可以使用副构造方法。


fun main() {
    //通过主构造方法创建对象
    val btnOk=Button5("OK",120,30)
    //通过副构造方法一创建对象
    val btnCancel=Button5("Cancel")
    //通过副构造方法二创建对象
    val btnGo=Button5(140,20)
    //通过副构造方法三创建对象
    val btnDefault=Button5()
}

 */

/*
4.副构造方法和初始化代码块
由于初始化代码块是属于主构造方法的一部分，所以，即使将初始化代码块放在副构造方法的下面，初始化代码块仍旧会先执行。
 */
class Button6(text:String){
    constructor():this("Default"){
        println("执行副构造方法。")
    }

    init {
        println("执行初始化代码块。")
    }
}

fun main() {
    //创建一个Button类的对象
    val btn=Button6()
    /*
    输出结果如下：
    执行初始化代码块。
    执行副构造方法。
     */
}