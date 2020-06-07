package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p8_genericity

/*
在Java中使用泛型时，可以用通配符指定类型参数的上下界。而Kotlin不支持通配符语法，所以需要用“在使用处型变”的语法来替代通配符。
除此之外，两者之间还存在一些不同的语法， 在使用时需要进行转换。下表列举了这些转换关系。
Java 泛型语法与Kotlin语法的转换关系
-------------------------------------------
java泛型语法        |     kotlin替代语法
-------------------------------------------
Foo<? extends Bar> |Foo<out Bar!>!
-------------------------------------------
Foo<? super Bar>   |Foo<in Bar!>!
-------------------------------------------
Foo                |Foo<*>
-------------------------------------------
*/
