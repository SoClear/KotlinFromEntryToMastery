package p3_advanced.p2_advancedUseOfFunctions.p3_lambdaExpressions

/*
Lambda表达式
Lambda表达式是一种语法简洁，可以被执行的代码块。在现代编程语言中，Lambda 表达
式的地位越来越重要，就连Java8中也加入了该语言特性，所以这种编程表达式应该掌握。

1.使用 Lambda表达式
[语法]
{参数列表->
    任意行执行语句
}


Lambda表达式的最后一行语句的执行结果是该Lambda表达式的返回值。
*/
//[举例]创建一个 Lambda表达式，将两个参数的值进行相加。具体代码如下:
//val sum={x:Int,y:Int->x+y}
//调用Lambda表达式和调用函数一样，需要在小括号中传入实参。下面将数字1和数字2作为实参传入该Lambda表达式中，具体代码如下:
//val result=sum(1， 2)
//输出: 3
//println (result)

/*
从这个例子中可以看到，创建及调用Lambda表达式的过程与创建及调用函数的过程非常类似。
这是因为Lambda表达式其实是匿名函数的语法糖，所以Lambda表达式的类型也是函数的类型。
*/
//[举例]将Lambda表达式作为函数类型的参数和返回值。具体代码如下:
//参数为函数类型,返回值为Int类型
fun applyLambda(f: (Int, Int) -> Int): Int {
    return f(10, 20)
}

fun returnLambda(): (Int, Int)-> Int {
    return { x: Int, y: Int ->
        x + y
    }
}

fun main() {
    val func= returnLambda()
    val result = applyLambda(func)
    //输出：30
    println(result)
}

/*
在实际使用时，Lambda 表达式和匿名函数还有以下几个区别:
●Lambda 表达式中最后-行语句的执行结果会自动返回，而匿名函数需加入return语句。
●Lambda 表达式无法声明返回值类型，而匿名函数需要声明返回值类型。
●如果可以从当前上下文推断出参数类型，则Lambda表达式的参数类型可以被省略。而匿名函数不支持这种写法。
●Kotlin 支持自执行的Lambda表达式(在定义的同时进行调用)，但是不支持自执行的匿名函数。
●Lambda表达式支持在参数上使用结构语法，而匿名函数不支持这样做。
除以上限制外，大部分情况下这两者都可以直接进行互换。
*/
