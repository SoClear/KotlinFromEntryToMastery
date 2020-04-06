package p2_intermediate.p5_packageManagementAndAccessController

/*
除访问控制符外，Kotlin中还提供了其他几种控制符。

1.open控制符和final控制符
open控制符和final控制符是互斥的一对控制符。 这两个控制符的使用方法如下:

open控制符修饰在类上表示该类可以被继承，
final控制符修饰在类上表示该类不能被继承。
普通类默认都是隐式被final控制符修饰的，
而抽象类则默认是被open控制符修饰的。


open控制符可以修饰在接口上，final控制符不能修饰在接口上。
接口和其中的成员默认都是被open控制符隐式修饰的，所以没有必要显式添加open控制符。


open控制符添加在方法/属性上，表示该方法/属性可以被重写: final控制符添加在方法/属性上，
表示该方法/属性不能被覆写。
普通方法/属性默认都是被final 控制符修饰的，
而抽象方法/属性默认则是被open控制符修饰的。





2.override控制符
override控制符只能用在子类重写的方法或属性上。override修饰的方法和属性默认都是隐式被open控制符修饰的。
 */