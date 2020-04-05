package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p2_abstractClass

/*
抽象类(Abstract Class)是使用“abstract” 关键字修饰的一种特殊类。
抽象类通常用于制定一个类应该包含的通用功能，而它的子类则负责具体实现这些功能。
所以，抽象类不能被实例化，但默认可以被继承。
如果说类是对象的模板，那么抽象类就是类的模板。

在类的组成方面:
●实体类(普通类)，只有实体方法(拥有方法体)和实体属性(属性有初始值或者属性被延迟初始化)。
●抽象类，既有抽象方法和抽象属性，也有实体方法和实体属性。
这里的抽象属性是指，属性仅仅被声明而没有进行初始化;
抽象方法是指，声明了方法但是没有编写方法体。


使用抽象类
在创建抽象类时，需要在声明语句前面加上“abstract”关键字。对于抽象属性和抽象方法也是同样操作。
 */
//[举例]创建包含抽象方法和抽象属性的抽象类AbstractView.具体代码如下:
//抽象类
abstract class AbstractView(val width: Int, val height: Int) {
    //抽象属性
    abstract val size: Int

    //抽象方法
    abstract fun onDraw()

    //实体方法
    open fun isClickable(): Boolean {
        return true
    }
}

/*
抽象类既可以被实体类继承，也可以被抽象类继承。
●如果实体类继承抽象类，则该实体类必须实现抽象类中的所有抽象成员。
●如果抽象类继承抽象类， 则该抽象类既可以不实现父抽象类的抽象成员，也可以用抽象
方法来重写父类的实体方法。
*/
//[举例]用抽象类ViewGroup继承抽象类AbstractView,并重写父抽象类AbstractView的抽象属性和实体方法。具体代码如下:
//子类也是抽象类
abstract class ViewGroup(width: Int, height: Int) : AbstractView(width, height) {
    //在覆写属性时将size修改为只读属性
    override val size: Int = width * height

    //覆写了父类的普通方法
    abstract override fun isClickable(): Boolean
}
