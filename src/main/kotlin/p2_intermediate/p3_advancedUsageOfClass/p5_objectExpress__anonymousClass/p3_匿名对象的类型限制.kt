package p2_intermediate.p3_advancedUsageOfClass.p5_objectExpress__anonymousClass

/*
匿名对象的真实类型只存在于本地作用域和私有作用域中。
即:如果将匿名对象保存到本地变量(函数中的变量)或私有属性(用private修饰)中，又或者将匿名对象作为私有方法的返回值，
那在程序中是可以获得该匿名对象的真实类型，并访问到匿名对象所在的对象表达式中的成员。

反之，如果将匿名对象定义为公有方法(public 修饰)的返回值或公有属性，则在程序中就只能获得匿名对象的父类。
如果没有为对象表达式指定父类，则获得的匿名对象是Any类型。
在这种情况下，程序无法访问在对象表达式中定义的成员。
 */
//【举例】在Child类中创建两个返回匿名对象的方法，一个方法是私有方法，另一个方法是共有方法。
open class Parent{
    val y:String="y"
}

class Child{
    //私有方法
    private fun privateMethod()=object : Parent(){
        val x:String="x"
    }
    //公有方法
    fun publicMethod()=object : Parent(){
        val x:String="x"
    }

    fun test(){
        //用私有方法创建的对象，返回真实类型
        val objectFromPrivateMethod=privateMethod()
        //访问对象表达式中的属性
        println(objectFromPrivateMethod.x)
        //访问父类型中的属性
        println(objectFromPrivateMethod.y)

        //用共有方法创建的对象，返回父类型Parent
        val objectFromPublicMethod=publicMethod()
        //只能访问父类型中的属性
        println(objectFromPublicMethod.y)
    }
}

/*
从上面这个例子中可以看到，在test()方法中，只有用私有方法privateMethod()创建的匿名对象可以获取到在对象表达式中定义的属性x,
而用公有方法publicMethod()创建的匿名对象则丢失了真实类型，只能访问在父类Parent中定义的属性y。

在使用时，匿名对象可以任意访问在其作用域内定义的成员。
 */
//[举例]在函数内部的匿名对象中访问在函数中定义的变量。具体代码如下:
fun test(){
    var x=10
    var obj=object {
        var y=x*10
    }
}

/*
在这个例子中，匿名对象obj定义在test()函数中，它的作用域就是test()函数所在的代码块，
因此，可以在对象表达式内部直接访问在test()函数中定义的变量x。
 */