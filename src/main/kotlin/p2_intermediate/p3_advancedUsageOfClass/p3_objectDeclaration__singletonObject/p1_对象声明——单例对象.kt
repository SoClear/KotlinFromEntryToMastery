package p2_intermediate.p3_advancedUsageOfClass.p3_objectDeclaration__singletonObject

/*
对象声明（object declaration）是一种用object关键字修饰的特殊类型。
kotlin官方文档中定义的这个名字其实并不容易理解。
在其他语言中（比如Scala），它有一个更贴切的名字：单例对象（Singleton object）。
顾名思义，这种类型只有一个实例，并且该实例的创建过程是线程安全的，
所以用单例对象可以非常容易地实现设计模式中的单例模式。
 */
//【举例】创建一个单例对象Singleton
//单例对象
object Singleton{
    //单例对象的属性
    private var num=0

    fun equence():Int{
        num+=1
        return num
    }
}
/*
在程序中，可以直接通过类名获得该单例对象的实例，具体代码如下:
1/ Singleton 在这里获得的就是单例对象的唯一实例
assert(1 == Singleton. sequence() )
assert(2 == Singleton. sequence() )
assert(3 == Singleton. sequence() )
在这个例子中，由于单例对象只有一个实例，所以每次调用sequence()方法后改变的都是同一个num属性，
调用3次后该属性的值就变成了3。

提示:
单例对象使用时看起来很像Java中的静态成员，但是这两者差别很大，并不能画上等号。
Kotlin语言没有提供任何静态成员，
单例对象本质上是根据声明语句隐式创建一个类，并将该类的对象返回。
对单例对象的任何访问操作都是访问该唯一实例的成员。
 */