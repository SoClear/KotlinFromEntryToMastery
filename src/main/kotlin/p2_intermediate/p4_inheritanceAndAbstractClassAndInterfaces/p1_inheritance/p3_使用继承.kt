package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p1_inheritance

/*
使用继承
*/
//[举例]创建Parent类和维承该类的子类Child.具体代玛如下:
//父类
open class Parent
//子类
class Child: Parent()
/*
如果父类包含自定义的构造方法，那么在继承父类时，子类的主构造方法必须调用父关的构造方法。
*/
//[举例]继承拥有自定义构造方法的父类。
//(1)创建一个包含自定义的主构造方法和副构造方法的类View,具体代码如下:
//父类，定义了主构造方法和副构造方法
open class View(val width: Int, val height: Int){
    constructor():this(0,0)
}
//(2)创建两个继承自View类的子类，具体代码如下:
//子类一，调用了父类的主构造方法
class SmallView(width: Int, height: Int) : View (width, height)
//子类二，调用了父类的副构造方法
class DefaultView:View()
/*
从这个例子中可以看到，两个子类的主构造方法分别直接和间接地调用了父类的主构造方法。
那么，如果在子类中没有显式定义主构造方法呢?
此时子类的副构造方法就必须通过“super” 关键字调用父类的构造方法。
*/
//[举例]子类通过修改副构造方法来继承拥有自定义构造方法的父类。具体代码如下:
//子类三，副构造方法调用了父类的主构造方法
class LargeView : View {
    constructor (width: Int, height: Int) : super(width, height)
}
