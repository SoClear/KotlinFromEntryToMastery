package p3_advanced.p3_annotationAndReflect.p1_annotation

/*
了解元注解
元注解是应用在注解上的注解，即元注解就是为注解添加的额外信息。
在Kotlin 中内置了四种元注解，它们分别是Target、Retention、 Repeatable和MustBeDocumented.


1. Target 元注解
Target元注解用于指定注解可以应用的范围。
该注解包含一个参数，参数类型为变参形式的枚举类AnnotationTarget,该枚举类包含以下几种枚举常量:
●CLASS————应用在类 (包含注解类)、对象、接口上。
●ANNOTATION_CLASS————应用在注解类 上。
●TYPE PARAMETER————应用在泛型参数上(尚未支持)。
●PROPERTY————应用在属性上。
●FIELD————应用在字段上 (包含属性的“幕后”字段)。
●LOCAL_VARIABLE————应用在本地变量上。
●VALUE_PARAMETER————应用在函数或构造方法上的值参数上。
●CONSTRUCTOR————应用在构造方法上。
●FUNCTION————应用在函数上。
●PROPERTY_GETTER————应用在 Getter访问器上。
●PROPERTY_SETTER————应用在 Setter 访问器。
●TYPE————应用在任何类型.上。
●EXPRESSION————应用 在表达式上。
●FILE————应用在文件类型上。
●TYPEALIAS————应用在类型别名上。

Target元注解用于的默认值为CLASS、PROPERTY、 FIELD、 LOCAL_VARIABLE、
VALUE_PARAMETER、CONSTRUCTOR、FUNCTION、PROPERTY_GETTER、PROPERTY_SETTER这些值的集合，
不包含FILE,所以上节最后的例子中才必须指定值为FILE。




2. Retention元注解
Retention 元注解用于指定注解的保存位置。它包含一个枚举类AnnotationRetention的参数，
该枚举类包含以下3种枚举常量:
●SOURCE————将注解保存在源文件中。
●BINARY————将注解保存在编译后的二进制文件中。
●RUNTIME————将注解保存在编译后的二进制文件中，并对反射可见(默认值)

提示:
Kotlin的注解默认是对反射可见的(即可以通过反射API获得注解信息)，
而Java的注解默认只保存在源文件中，对反射不可见。
如果将注解的作用范围(Target)设置为表达式( EXPRESSION)则该注解只能保存在源文件( SOURCE)中。


3. Repeatable元注解
在默认情况下，在一个位置只能同时添加一个同名的注解，但使用Repeatable元注解后则可以突破该限制。
但使用Repeatable元注解时有一个限制条件:必须同时将Retention元注解的值指定为SOURCE。
*/
//【举例】用Repeatable元注解为同一个属性添加多个标注
//（1）创建一个带有Repeatable元注解的注解类Alias，具体代码如下:
@Repeatable
//必须使用AnnotationRetention.SOURCE来使得可以添加同名注解
@Retention(AnnotationRetention.SOURCE)
annotation class Alias(val name:String)

//(2)用该注解为属性name设置多个别名，具体代码如下：

class User1{
    @Alias("name")
    @Alias("first_name")
    @Alias("firstName")
    val name:String= ""
}
/*
4.MustBeDocumented元注解
MustBeDocumented元注解用于表示其标记的注解应该包含在生成的API文档中。
 */