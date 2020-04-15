package p3_advanced.p3_annotationAndReflect.p2_reflect.p3_useReflection

import kotlin.reflect.KClass

/*
使用反射
1. KClass类型
KClass类型在反射API中代表Kotlin中的类。在程序中，可以通过类或对象来获得该类型的实例，这个操作相对于在java中“获得类对象”。


(1)通过类获得KClass对象。
【举例】在通过类获得KClass类型的实例时，需要使用“类名::class这样的语法。具体代码如下:
*/
//创建类Person
class Person
//通过类获得KClass类型的实例
var clazz: KClass<Person> = Person::class
/*
在这个例子中，clazz变量保存的就是对类Person的引用。


(2)通过对象获得KClass类型。
在通过对象获得KClass类型的实例时，需要先使用对象的javaClass属性获得Kotlin类对应的Java类，
然后再访问该java类的扩展属性，kotlin具体代码如下:
*/
val person = Person()
val clazz1: KClass<Person> = person.javaClass.kotlin
/*
KClass类型包含大量属性，下面列举了其中最常用的几个属性。
●qualifiedName:String————获得类的完整限定名。
●simpleName:String————获得类名。
●annotations: List<Annotation>————获得应用在类上的注解。
●members: Collection<KCallable<*>>————获得在类及其父类中定义的所有方法和属性。
●declaredMembers: Collection<KCallable<*>>————获得在类中定义的所有方法和属性。
●constructors: Collection<KFunction<T>>————获得 在类中定义的所有构造方法。
●memberProperties: Collection<KProperty1<T, *>>————获得在类及其父类中定义的所有属性(不包含扩展属性)。
●memberExtensionProperties: Collection<KProperty1<T, *>>————获得在类及其父类的所有扩展属性。
●declaredMemberProperties: Collection<KProperty1<T, *>>————获得在类中定义的所有属性(不包含扩展属性)。
●declaredMemberExtensionProperties:Collection<KProperty1<T, *>>————获得在类的所有扩展属性。
●memberFunctions: Collection<KFunction<*>>————获得在类及其父类中定义的所有方法(不包含扩展方法)。
●memberExtensionFunctions:Collection<KFunction<*>>————获得在类及其父类中定义的所有扩展方法。
●declaredMemberFunctions:Collection<KFunction<*>>————获得在类及其父类中定义的所有方法(不包含扩展方法)。
●declaredMemberExtensionFunctions: Collection<KFunction<*>>————获得在类的所有扩展方法。
*/
