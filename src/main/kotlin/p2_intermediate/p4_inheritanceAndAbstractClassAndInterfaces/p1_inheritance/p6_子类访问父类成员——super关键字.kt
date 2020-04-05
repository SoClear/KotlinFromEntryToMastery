package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p1_inheritance

/*
子类访问父类成员一-super关键字
在子类中，可以使用“super”关键字访问父类的成员。下面是访问各种父类成员的语法。
访问父类属性的语法如下:
super.属性名
访问父类方法的语法如下:
super.方法名(参数列表)
访问父类构造方法的语法如下:
super(参数列表)

如果子类包含一个内部类， 那么在这个内部类访问外部类的父类时，需要使用“super@外部类”
*/

//[举例]在子类的内部类中访问父类的成员。具体代码如下:
//父类
open class View3(val width:Int,val height:Int){
    open var size:Int=0
}

//子类
class SmallView3(width: Int,height: Int):View3(width,height){
    override var size: Int=width*height

    //在子类中创建一个内部类
    inner class Painter{
        //内部类访问外部类的成员
        fun sizeInOuterClass():Int=size
        //内部类访问外部类的父类成员
        fun sizeInSuperClass():Int=super@SmallView3.size

    }
}

