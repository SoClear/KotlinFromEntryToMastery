package p2_intermediate.p7_genericParadigm.p2_useOfGenerics

/*
泛型类
1.创建泛型类
如将泛型应用在类上，则需要将类型形参放在类名后面。
和泛型函数一样，在一个泛型类上也可以同时声明多个类型参数。
*/
//[举例]创建泛型类Capture和该类的对象。
//(1) 创建一个泛型类Capture, 具体代码如下:
class Capture<T> (val t: T)
//(2)创建两个Capture类的对象(注意创建过程需要指定类型实参)具体代码如下:
//向类型形参<T>传递类型实参Int类型
val integerCapture = Capture<Int> (10)
//此时取出的对象为真实数据类型
val nint10: Int = integerCapture.t
/*
和调用泛型函数一样，如果编译器能够在创建对象时推断出类型参数的实际类型，那么就可以省略泛型参数的声明。
这里的Capture类只有一个主构造方法，当调用该构造方法并传递参数t时，泛型的类型就已经被确定了，
因此这里可以省略类型参数的声明，具体代码如下:
*/
//省略了类型参数<String>，编译器能够自行推断出该类型
var stringCapture = Capture ("Hi")
val str: String = stringCapture.t
/*
提示:
在声明类型参数时，Kotlin 和Java有一个不同点- Kotlin 不支持原始类型，
即:如果需要显式指定泛型变量的类型，则必须明确指定类型参数，而不能省略。
例如在上面例子中，可以指定stringCapture 变量的类型为Capture<String>,
但是不能将该类型声明为Capture或Capture<>。


2.泛型类的子类
在创建一个继承自泛型类的子类时， 需要在该子类的声明过程中明确指定类型实参的值，
而不能继续沿用父类的类型形参。
*/
//[举例]创建泛型类Holder并继承该泛型类的子类SubHolder.具体代码如下:
//<T>为泛型形参
open class Holder<T> (obj: T)
// <Int>为泛型实参
class SubHolder(obj: Int) : Holder<Int> (obj )

