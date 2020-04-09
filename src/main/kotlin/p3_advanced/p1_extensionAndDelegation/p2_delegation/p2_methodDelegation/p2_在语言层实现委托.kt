package p3_advanced.p1_extensionAndDelegation.p2_delegation.p2_methodDelegation

/*
2.在语言层实现委托
[语法]
委托的类型 by 委托对象

如果在类声明语句的末尾添加以上语句，
则编译器在编译时会根据委托的类型生成对应的方法，并将这些方法交由委托对象来执行。
*/
//[举例]在语言层使用委托特性，功能与“1.在应用层实现委托”中的那个例子完全一致。具体代码如下:
class Delegation2(base: Base) : Base by base

/*
编译器在编译上行代码时会为Delegation2类生成所有来自Base类的方法，
并且委托主构造方法中的base对象执行这些方法。

使用委托后，如果需要在委托方法中执行自定义操作，则可以在类中直接重写该委托方法。
*/
//[举例]自定义委托方法的代码如下:
class Delegation3(base: Base) : Base by base {

    //自定义log()方法， 而isEnabled()方法则交由委托特性来实现
    override fun log(message: String) {
        println("override log()")
    }
}