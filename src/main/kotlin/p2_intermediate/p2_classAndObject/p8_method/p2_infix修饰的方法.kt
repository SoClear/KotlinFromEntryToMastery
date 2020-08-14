package p2_intermediate.p2_classAndObject.p8_method

/*
infix :中缀表达式,中缀符号(infix notation)
函数还可以通过中缀符号形式来调用，需要满足如下3个条件:
1。是成员函数或是扩展函数
2。拥有单个参数
3。声明时使用infix关键字

如果一个关键字被infix关键字修饰，则在调用该方法时可以省略点符号和小括号。
此时需要在方法名、参数和对象之间各留一个空格，整个调用方式就像使用二元操作符一样，所以infix方法只能包含一个参数。
 */
//【举例】在Student类，创建infix方法height()并调用该方法
class Student{
    var height=0
    //infix方法
    infix fun height(height:Int){
        this.height=height
    }
}

fun main() {
    //创建对象
    val student=Student()
    //方式一，使用 传统方法调用方法
    student.height(170)
    //方式二，省略点和小括号调用方法
    student height 180
    //输出：180
    println(student.height)
}