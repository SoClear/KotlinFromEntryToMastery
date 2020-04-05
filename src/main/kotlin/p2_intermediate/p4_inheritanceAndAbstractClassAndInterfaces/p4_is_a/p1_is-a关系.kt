package p2_intermediate.p4_inheritanceAndAbstractClassAndInterfaces.p4_is_a

/*

is-a关系

is-a是面向对象语言中的一种描述类和类之间关系的术语。
它是指:如果一种类型继承自另一种类型，则这种类型般化后的个体也都属于该类型。
通俗地来讲就是，子类的对象也属于父类类型。
*/
//[举例]演示“is-a”关系。首先创建-一个子类C的对象，然后将该对象赋值给了父类类型的变量p，具体代码如下:
//创建父类和子类
open class P
class C: P()

fun main() {
    //变量p为父类型变量
    var p:P?=null
    //变量c为子类型变量
    var c:C?=C()
    //is-a关系，将子类型对象赋值给父类型变量
    p=c
}