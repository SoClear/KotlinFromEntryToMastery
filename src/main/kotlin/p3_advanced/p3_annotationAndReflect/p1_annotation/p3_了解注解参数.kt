package p3_advanced.p3_annotationAndReflect.p1_annotation

import kotlin.reflect.KClass

/*
了解注解参数

1.添加注解参数
可以通过为主构造方法添加只读属性(val) ，从而为注解类添加参数。
*/
//[举例]为注解类Bean1添加一个字符串类型的只读属性。具体代码如下:
annotation class Bean1 (val name: String)
/*
这里需要注意，注解的属性和普通类的属性不同，它只支持以下几种数据类型，并且这些类型也不能是可空类型。
●对应Java原生类型的类型(如Int、Long等)。
●字符串。
●类。
●枚举。
●注解。
●上面这些类型的数组类型。


2.用注解作为注解的参数类型
如果将一个注解作为另一个注解的参数类型，则无须在该注解前加上“annotation”关键字，只有在应用注解时才需要添加该关键字。
*/
//[举例]用注解Api作为注解ApiModel的参数类型。具体代码如下:
//创建注解Api
annotation class Api(val version: String= "1")

//创建注解ApiModel, 该注解的version属性为Api类型
annotation class ApiModel (val name:String, val version: Api)

//应用注解ApiModel
@ApiModel (name = "响应对象",version =Api("1.2"))
class Response


/*
3.用类作为注解的参数类型
如果需要将一个类指定为注解的参数，则需要使用KClass类作为该参数的数据类型。
KClass类相当于Java中的java.lang.Class类,它包含一个表示实际数据类型的泛型类型参数。
*/
//[举例]创建一个注解类Converter该类包含两个KClass参数，并且允许任何类型作为实参进行传递。
//所以，应该将KClass的类型参数设置为星号。具体代码如下:
annotation class Converter(val from:KClass<*>,val to:KClass<*>)
//如要引用一个类的类型， 则需要使用“类型名::class"这样的语法，具体代码如下:
@Converter (String::class,Int::class)
class String2IntConverter
/*
从这个例子中可以看到，字符串类型String和整型类型Int被分别应用到了注解Converter的两个参数上。




4.用数组作为注解的参数类型
数组也可以作为注解的参数类型，此时可以用中括号“[]” 直接创建数组类型的参数。
*/
//[举例]创建一个用整型数组作为参数的注解类，并使用该注解类。
//(1)创建一个用整型数组作为参数的注解类，具体代码如下:
annotation class NumArray(val array: IntArray)
//(2)将该注解应用到类上。此时既可以用内置函数创建数组，也可以用中括号创建数组(中括号创建数组的语法只能用于注解参数中)。具体代码如下:
//用内置函数创建数组参数
@NumArray (intArrayOf(1, 2, 3))
class A1

//用中括号语法创建数组参数
@NumArray([1, 2, 3])
class Str1


/*
5.用常量作为注解的参数值
如果用常量作为注解的参数值，则需要将常量声明为“const val”，
这表示该常量为编译期常量，它的值在编译期就已经被确定了。
编译期常量可以声明在object类或顶层作用域中。
*/
//[举例]用常量作为注解参数。
//(1)创建一个包含 整型参数的注解类Desc,具体代码如下:
annotation class Desc(val code: Int)
//(2)创建一个包含编译期常 量的object类，并在A类的注解参数上使用该常量，具体代码如下:
//将编译期常量定义在object类中
object Constant {
    const val n = 1
}
//用编译期常量作为参数的值
@Desc(code = Constant.n)
class A

/*
在这个例子中，如果去神“const”"关键字，而使用普通常量，
则编译器程序会抛出“only 'const val' can be used in constant expressions."错误
(只有“const val”关键字可以用在常量表达式中)。

提示:
Kotlin没有Java那样的静态常量。
Kotlin中的常量实际上是被保存在单例对象中的(上面例子中的n属性就被保存在Constant类的对象中)，
而单例对象是在运行期创建完成的，所以这里不能用普通常量作为注解参数，而必须用编译期常量作为注解参数。
*/
