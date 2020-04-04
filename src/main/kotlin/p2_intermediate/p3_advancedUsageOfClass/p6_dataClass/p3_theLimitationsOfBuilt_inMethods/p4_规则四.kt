package p2_intermediate.p3_advancedUsageOfClass.p6_dataClass.p3_theLimitationsOfBuilt_inMethods

/*
4.规则四
数据类不能继承自拥有相同签名的copy()方法的父类。
*/
//[举例]创建Item1类及缝承该类的RedBottle1类，Item1类中包含一个copy()方法。具体代码如下:
open class Item1(val price: Int) {
    //自定义的copy()方法
    fun copy(price: Int, hp: Int) {
    }
}
//编译器报错，无法继承
//data class RedBottle1(val _price: Int, val hp: Int) : Item1( _price)

/*
在这个例子中，Item1 类的copy()方法包含两个Int类型的参数，
数据类RedBottle1的主构造方法也包含两个Int 类型的参数。
所以，数据类自动生成的copy()方法的签名在和Item1类中自定义的copy0方法的签名完全一致，
这种情况下编译器就会直接报错。
 */