package p2_intermediate.p7_genericParadigm.p3_typeParameterConstraint

/*

类型参数约束
本节将介绍类型参数约束的概念和使用方法。


1.上界的概念
泛型类或泛型函数可以同时处理不同类型的数据。
但针对下面这种需求，单纯使用类型参数还是无能为力的。
fun <T> sum(first: T，second: T) : T
该函数需要将两个参数进行相加后才能返回计算结果。
很容易可以想到，如果参数是整型或浮点型，则加法是成立的。
但如果参数是字符串、文件等其他类型的数据，则参数是不能进行相加的。


如果能将类型参数的实际类型限制在数值类型的范围内，则上面这个问题就能迎刃而解。
为解决这类问题，Kotlin 提供了类型参数的上界。
上界限定了该类型参数必须是某一个具体类型的子类型，所以，在该泛型的作用域内可以直接访间上界类型的任何成员。

*/