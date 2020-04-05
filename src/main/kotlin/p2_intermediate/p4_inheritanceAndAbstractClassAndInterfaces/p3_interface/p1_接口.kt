package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p3_interface

/*
接口
本节将介绍接口的概念和使用方法。
了解接口
接口(interface)是种表示标准的引用对象，
Kotlin 不支持多重继承，而接口可以弥补这个缺点，任何一个类都可以同时实现多个接口。
接口由实体方法、抽象方法和抽象属性组成。

使用接口
1.定义抽象方法
接口需要用“interface" 关键字进行声明。
接口和类的关系通常被称为实现(而非继承)，所以实现接口的类也被称为实现类。
由于接口中的成员都可以是抽象成员，所以在声明抽象成员时可以直接省略“abstract" 关键字。
*/
//[举例]创建OnClickListener接口，该接口中包含一个抽象方法onClick()。具体代码如下:
//接口
interface OnClickListener {
    //袖象方法，可以省略abstract关键字
    fun onClick()
}
/*
2.定义抽象属性
在接口中添加抽象属性主要有两种方式:
●仅声明属性而不进行初始化操作。
●在声明属性后提供自定义的Getter访问器。 由于抽象属性不包含字段，所以在抽象属性的访问器中不能使用幕后字段(backing field)。
*/
//[举例]在接口中声明抽象属性。具体代码如下:
interface OnTouchListener {
    //抽象属性
    var target: String

    //提供Getter访问器实现
    val description: String
        get() = "a touch listener"
}
/*
实现技口和继承类的语法一样， 就是在实现关后面加上冒号(:)和接口类型。
如果需要同时实现多个接口，则需要将这些接口以逗号(,) 进行分隔。
3.同时继承类并实现接口
继承关系和实现关系是允许同时存在的，所以一个类可以同时实现多个接口并继承一个类。
这些接口和类的摆放顺序是没有任何强制要求的，按照java语言习惯，通常将类放在前面，接口放在后面。
*/
//[举例]创建View1类的子类Button1并实现两个接口。
//(1)分别创建两个接口和一个抽象类。具体代码如下:
interface OnClickListener1{
    fun onClick()
}

interface OnTouchListener1{
    fun onTouch()
}

abstract class View1{
    abstract fun onDraw()
}

//(2)创建Button1类，该类继承自抽象类View1并实现了OnClickListener接口和OnTouchListener接口
//同时实现类和接口，类放在前面，接口放在后面
class Button1:View1(),OnClickListener1,OnTouchListener1{
    override fun onDraw() {
        println("invoke onDraw()")
    }

    override fun onClick() {
        println("invoke onClick()")
    }

    override fun onTouch() {
        println("invoke onTouch()")
    }
}

/*
4.接口间继承关系
接口只是一种标准，不包含实现，所以接口都是抽象的，不能继承任何类。
但是，接口和接口之间可以存在继承关系，而且是多继承关系，即一个接口可以同时继承多个接口。
*/
//[举例]创建一个继承多个接口的接口。具体代码如下:
interface A
interface B
//同时继承多个接口
interface C : A,B
