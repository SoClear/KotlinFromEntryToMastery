package p2_intermediate.p2_classAndObject.p4_theConceptAndUseOfClass

/*
1了解类————同一种概念的的抽象。
类不是用来表示任何一个具体的事物的，它是从一群具体事物中去除细节部分抽象后的结果。

2.类的基本结构
kotlin和其他面向对象语言一样————用关键字“class”来声明一个类。
类中可以定义任意个数的属性和方法。
类的基本结构：
[访问控制符] class 类名 {
    属性...
    方法...
}


· 访问控制符有public、internal、private三种。
· 类名一般为“大驼峰”形式，即类名的首字母是大写英文字母。
    如果类名由多个英文单词构成，那么从第二个英文单词开始，首字母是大写英文字母。
· 属性（Property）表示类的固有特性和状态。
· 方法（Method）用于表示类的行为。方法在本质上是定义在类中的函数（Function）

类中的属性和方法的定义顺序没有任何限定，但是我们通常习惯将所有属性都放在前面，将所有方法放在属性后面。
将名词或者动名词定义为属性，将动词定义为方法。
 */

/*
3.定义一个电脑类
 */
class Computer{
    //属性
    var cpus=2
    var hardDisk=1024

    //方法
    fun running(){
        println("电脑运行中。。。")
    }

    fun turnOn(){
        println("启动电脑。。。")
    }

    fun shutDown(){
        println("关闭电脑。。。")
    }
}