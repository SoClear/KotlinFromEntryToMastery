package p3_advanced.p3_annotationAndReflect.p1_annotation

/*
注解目标
Kotlin虽然采用了Java的注解方式，但是Kotlin中的一个位置声明却可能对应Java中的多个位置的声明，
最直观的例子就是属性声明。
Kotlin 中的一个属性声明会对应Java中的字段声明、Setter访问器和Getter访问器三种。
所以，当Kotlin源代码被编译成Java字节码后，Kotlin属性上的单个注解会同时出现在Java字节码的多个位置上。
针对这种情况，Kotlin提供了注解目标，可以由开发者控制注解的实际目标位置。

1.使用注解目标
[语法]声明一个注解目标，只需在应用注解的语法前加上具体的目标。
@注解目标:注解
*/
//[举例]将注解目标应用在属性上。具体代码如下:
class User (@get:BeanAccessor val name: String)
/*
在这个例子中，注解类BeanAccessor应用在主构造方法的属性name上，
该注解的目标为“get”，所以编译后，该注解实际是被添加到java字节码中的Getter访问器上了
如果多个注解需要使用同一个注解目标，则可以将这些注解都放在中括号中以简化这个声明过程。
*/
//[举例]在多个注解上应用同个注解目标。具体代码如下:
// BeanAccessor和BeanMethod两个注解的目标都是get
/*
var age: Int= 0
    @get:[BeanAccessor BeanMethod] get()=field

2.注解目标列表
在上面例子中注解目标为get.除此之外，Kotlin还提供了以下几种注解目标:
●property————目标为属性，对Java不可见。
●field————目标为字段。
●get————目标为Getter访问器。
●set————目标为Setter访问器。
●receiver————目标为扩展函数或扩展属性的接收者。
●param————目标为构造方法的参数。
●setparam————目标为Setter访问器的参数。
●delegate————目标为实际委托对象。
●file————目标为源文件， 使用时需要放在包声明之前。
[举例]用file目标注解整个文件。需要注意，这个例子中的代码需要分别放在两个文件中。
具体代码如下:
文件一:
//创建注解类
@Target (AnnotationTarget.FILE)
annotation class Utils
文件二:
//将注解应用到文件中
@file: Utils
package p3_advanced.p3_annotationAndReflect.p1_annotation
从这个例子中可以看到，注解类Utils上多了一个“@Target"注解，这里用到了下节将介绍的元注解。
*/
