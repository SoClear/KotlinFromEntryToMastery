package p2_intermediate.p2_classAndObject.p8_method

/*
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