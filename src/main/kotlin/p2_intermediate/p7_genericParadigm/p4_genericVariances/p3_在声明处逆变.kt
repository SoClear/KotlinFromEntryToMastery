package p2_intermediate.p7_genericParadigm.p4_genericVariances

/*
16.4.3
在声明处逆变
如果C类是P类的子类，那么C类的类型参数可以被看作是P类的类型参数的父类型，这种特性被称为逆变(Contravariant) 。
逆变反转了子类型的关系，将逆变应用在类上称为在声明处逆变。
在使用逆变时，需要在类型参数前面加上“in”关键字。
*/
//[举例](1)创建一个使用声明处逆变的ContravariantHolder类，该类包含了逆变类型参数T， 具体代码如下:
class ContravariantHolder<in T>(obj: T) {
    fun test(param: T) {
        println(param)
    }
}

fun main() {
    //(2) 使用该类型创建对象，具体代码如下 :
    var anyContravariant=ContravariantHolder<Any>(10)
    //基于逆变定义
    var strContravariant: ContravariantHolder<String> = anyContravariant
    strContravariant.test("hello")
}
/*
在这个例子中，首先创建了两个ContravariantHolder类的对象：
一个类型参数为String，另一个类型参数为Any。
按照逆变的定义，由于String类型是Any类型的子类型，类型参数String可以看作是类型参数Any的父类型，
所以可以将变量anyContravariant赋值给变量strContravariant。

和协变的类型参数相反，逆变的类型参数只能用于输入类型，
即：协变类型只能作为方法的参数类型
*/
