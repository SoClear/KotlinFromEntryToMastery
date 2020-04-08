package p2_intermediate.p7_genericParadigm.p4_genericVariances

/*
 类型型变
本节将介绍泛型中非常重要的类型型变，包括协变和逆变两种型变方式的使用方法和注意事项。



型变
通过一个泛型类可以创建多个拥有不同类型参数的对象。
这些类型相同但类型参数不同的对象间进行转换的过程被称作型变。
Kotlin 默认是不支持型变的，即无法将泛型类对象直接赋值给另一个属于同样泛型类的变量。
*/
//[举例]一个不采用型变的例子。
//(1)创建一个Parent类和该类的子类Child,然后创建一个泛 型类Holder具体代码如下:
open class Parent
class Child : Parent ()
//泛型类
class Holder <T>(var obj: T)
//(2)创建两个Holder 类的对象，类型参数分别为Parent类型和Child类型，具体代码如下:
var childHolder: Holder<Child> = Holder (Child())
var parentHolder: Holder<Parent> = Holder(Parent())
//下面两行代码会造成编译错误
//parentHolder=childHolder
//childHolder=parentHolder
/*
从这个例子中可以看到，尽管这对两个对象都诞生自Parent类型，
但无论是将childHolder对象赋值给parentHolder变量，
还是将parentHolder对象赋值给childHolder变量都会导致编译错误。
这就是不采用型变的结果。
*/