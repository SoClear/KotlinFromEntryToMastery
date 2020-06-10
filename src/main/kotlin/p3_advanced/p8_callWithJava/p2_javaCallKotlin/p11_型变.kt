package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
型变



Java只支持在使用处型变，且在使用处型变是通过通配符来实现的。
而在Kotlin中，型变分为“在声明处型变”和“在使用处型变”两种，
所以，如果需要在lava中使用Kotlin中的泛型类型，
则需变将Kotlin中的“在声明处型变”映射为“在使用处型变”。


在Kotlin，这种映射关系由编译器自动实现，具体的映射规则如下:
●对于协变类型Foo<out T>,如果方法的类型参数为Foo<Base>,，则导出的Java映射为Bar<?extends Base>类型。
●对于逆变类型Bar<in T>,如果方法的类型参数为Bar<Sub>，则导出的Java映射为Foo<?super Sub>类型。
●映射关系默认只发生在方法参数中，与方法的返回值无关。


除以上自动映射关系外，还可以在Kotlin源码中通过注解手动指定通配符的生成规则，具体规则如下:
●如果方法的类型参数添加了@JvmWildcard注解，则在Kotlin的编译结果中会强制生成类型参数的通配符。
例如协变类型Foo<out T>，如果方法的类型参数为Foo<@JvmWildcard Base>,
则导出的Java映射为Bar<?extends Base>类型。

●如果方法的类型参数添加了@JvmSuppressWildcards注解，则在Kotlin的编译结果中不会生成通配符。
例如协变类型Foo<out T>，
如果方法的类型参数为Foo<@JvmSuppressWildcards Base>，
则导出的Java映射为Bar<Base>类型。
*/
