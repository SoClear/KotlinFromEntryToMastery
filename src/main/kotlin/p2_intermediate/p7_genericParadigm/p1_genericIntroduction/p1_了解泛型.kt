package p2_intermediate.p7_genericParadigm.p1_genericIntroduction

/*
了解之型
本节将介绍泛型的基本概念，以及为什么需要有泛型。

1.泛型的概念
泛型(Generics) 是种将类型进行参数化的机制，即将类型作为参数进行传递。
使用泛型后，开发者可以在声明类、接口、函数时使用自定义的符号来表示特定类型(类型形参)，
在代码编译时传递实际类型作为参数( 类型实参)。


2.为什么要有泛型
要理解泛型的存在意义，需要先来看一个不使用泛型的实例。
该实例的需求是，设计并实现个可以保存任何对象作为缓存的类。
按照Kotlin 的类继承结构，只有Any类型的属性可以保存任意类型对象，
所以这里创建一个包含Any类型属性的类ObjectCapture,具体代码如下:
class ObjectCapture(val obf: Any)
然后创建该类的对象，将一个整型数值10保存到该对象的属性中，具体代码如下:
val intObjectCapture = ObjectCapture(10)
val any:Any=intObjectCapture.obj
由于obj属性为Any类型，所以保存的数字10只能赋值给Any类型的变量。
此时如果想继续调用整型的成员方法，则需要对该属性的值进行强制类型转换，具体代码如下:
val int10: Int = integerObjectCapture.obj as Int
上面这种操作无疑是不安全的。
在实际项目中，integerObjectCapture 可能来自外部或其他人编写的方法，程序本身是没有机制保证该对象保存的一定是整型。
所以在类型转换前，还必须对所有可能用到的类型都进行类型判断和类型转换。
这种操作无疑非常烦琐，而使用泛型则可以优化这个过程。

 */