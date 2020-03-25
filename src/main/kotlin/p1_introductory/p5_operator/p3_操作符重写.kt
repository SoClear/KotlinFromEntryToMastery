package p1_introductory.p5_operator


/*
kotlin中的各种操作符实际是调用了在类中定义的操作符方法，所以只要为类添加这些方法，即使是开发者自定义的类型也可以用操作符进行运算。
操作符方法，是使用operator修饰的方法。
 */
//例：用四则操作符中的“+”号（相当于plus()方法）实现蓝色加黄色等于绿色。
class Yellow
class Green

class Blue{
    operator fun plus(y:Yellow):Green{
        return Green()
    }
}

fun main() {
    val blue=Blue()
    val yellow=Yellow()
    val green=blue+yellow
}