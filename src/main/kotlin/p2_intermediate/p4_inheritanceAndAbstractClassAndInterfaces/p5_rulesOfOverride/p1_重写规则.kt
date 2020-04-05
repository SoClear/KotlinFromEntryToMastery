package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p5_rulesOfOverride

/*
重写规则
一。个类在同时继承父类和实现多个接口时，很容易会碰到在父类型中存在相同签名的成员的情况，
这时编译器是无法知道子类需要继承的具体成员的，
所以Kotlin规定这种情况下子类必须手动重写该成员。
在重写过程中，可以通过“super<父类类型>”这样的语法来调用指定的父类类型中的成员。
*/
//[举例]创建MainActivity类并重写其父类的onCreat()方法。
//(1)创建两个接口，每个接口中都实现了-个onCreate()方法， 具体代码如下:
interface Activity {
    fun onCreate() {
        println("onCreate() in Activity")
    }
}
interface SupportActivity {
    fun onCreate() {
        println("onCreate() in SupportActivity")
    }
}
//(2)创建个实现了这两个按口的 MainActivity类。
// 由于两个接口中都包含onCreate()方法，所以MainActivity类必须手动重写这个方法
class MainActivity:Activity,SupportActivity{
    override fun onCreate() {
        //调用父类型Activity中定义的onCreate()方法
        super<Activity>.onCreate()
        //调用父类型SupportActivity中定义的onCreate()方法
        super<SupportActivity>.onCreate()
    }
}
