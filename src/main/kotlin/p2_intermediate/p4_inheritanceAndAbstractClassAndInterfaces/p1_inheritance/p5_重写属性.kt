package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p1_inheritance

/*
重写属性
和方法一样，属性也是默认不能被重写的。为实现属性重写，需执行以下两个步骤:
(1)在父类属性声明的最前面加上“open”关键字，表示允许重写该属性。
(2)在子类中定义与父类相同名称和类型的属性，并在该属性声明前添加“override”关键字，表示该属性是重写后的属性。
*/
//[举例]创建View2类，该类包含一个可以被重写的属性size。具体代码如下:
open class View2(val width: Int, val height: Int) {
    //open表示该属性可以被覆写
    open var size: Int = 0
}

/*
然后创建两个重写该属性的子类，
重写操作可以通过赋值语句或Getter访问器来实现。具体代码如下:
*/
//方式一，通过赋值语句重写属性
class SmallView2(width: Int, height: Int) : View2(width, height) {
    override var size: Int = width + height
}

//方式二，通过Getter访问器重写属性
class LargeView2(width: Int, height: Int) : View2(width, height) {
    override var size: Int = width * height
        get() = width * height
}
/*
在这个例子中，通过两种方式重写了size 属性的值。
Kotlin 还允许在重写属性时将父类的可写属性(var) 修改为只读属性(val) 。
但是反过来将只读属性(val) 修改为可写属性(var) 则是禁止的，
因为:可写属性是由Setter访问器和Getter访问器构成的，而只读属性只包含Getter访问器。
*/