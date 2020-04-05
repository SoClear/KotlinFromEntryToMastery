package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p1_inheritance

/*
重写方法
维承关系可以使子类拥有父类的方法， 而重写方法就是修改那些从父类维承的方法。
方法和类一样都是默认隐式被“final”"关键字修饰，这表示方法不能被重写。

为了实现方法重写功能，需要执行以下两个步骤:
(1)在父类方法声明的最前面加上“open" 关键字，表示允许重写该方法。
(2)在子类中定义与父类方法名和参数列表相同的方法，并在该方法声明前添加“override"关键字，表示该方法是重写后的方法。
*/
//[举例]创建子类SmallView,并重写其父类View的onDraw()方法。
//(1)创建View1类，该类包含一个可以被重写的onDraw()方法。 具体代码如下:
open class View1(val width: Int, val height: Int) {
    // open声明该方法可以被重写
    open fun onDraw() {
        println("draw a view")
    }
}
/*
(2)创建-个继承自View1的SmallView1类，在该类中重写来自View1 类的onDraw()方法。
在重写的方法中(SmallView.onDraw())可以通过“super”关键字调用父类中的被重写的方法(View1.onDraw())。具体代码如下:
*/
class SmallView1(width: Int, height: Int) : View1(width, height) {
    // override表示该方法是重写后的方法
    override fun onDraw() {
        println("begin drawing")
        //调用被重写的父类的onDraw()方法
        super.onDraw()
        println("end drawing")
    }
}
/*
重写方法中还有-一个需要注意的地方:用“override”关键字修饰的方法默认是可以被继的。
如果想禁止该方法被再次重写，则需要手动在方法声明前面加上“final”关键字。
 */