package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
KClass
Java的Class类型与Kotlin的KClass类型不支持自动转换功能，
所以，如果在Java中需要获得KClass的实例，
除直接调用对象的扩展属性外，也可以调用JvmClassMappingKt.getKotlinClass。

在获得KClass的实例时，需要调用有KClass类型参数的Kotlin方法。
因为没有从Class到KClass的自动转换，所以必须通过调用Class<T>.kotlin扩展属性的等价形式来手动进行转换。

[举例]获得类的KClass对象。具体代码如下:
//获得Java中的Class对象
Class<KotlinBean7) clazz = KotlinBean7.class;
KClass<KotlinBean7> KotlinBean7KClassOther = kotlin.jvm.JvmClassMappingKt.getKotlinClass(clazz);
*/
