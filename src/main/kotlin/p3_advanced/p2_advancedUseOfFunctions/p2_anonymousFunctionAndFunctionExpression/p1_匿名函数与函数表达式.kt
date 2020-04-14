package p3_advanced.p2_advancedUseOfFunctions.p2_anonymousFunctionAndFunctionExpression

/*
匿名函数是指没有名字的函数。在某些情况下，如果没有必要为一个函数进行命名，则可以创建匿名函数。
*/
//[举例]创建一个作为高阶函数的返回值的匿名函数。具体代码如下:
fun getAnonymousFunction() : (Int,Int) -> Int {
    return fun(x: Int, y : Int) : Int{
        return x + y
    }
}
/*
在这个例子中，匿名函数用于将参数x和参数y的值相加，结果为该函数的返回值。
由于匿名函数将直接作为getAnonymousFunction()的返回值，所以没有必要为它起一个名字。
Kotlin不支持自执行函数，所以在程序中无法直接调用匿名函数，
而是应该将匿名函数赋值给变量形成函数表达式，然后通过函数表达式调用匿名函数。
*/
fun main() {
    //[举例] 通过函数表达式调用匿名函数。具体代码如下:
    var sum = getAnonymousFunction ()
    //输出: 3
    println(sum(1,2))
}
/*
这个例子中的getAnonymousFunction()函数返回了一个匿名函数，
该匿名函数被赋值给了变量sum,最后通过变量sum调用该匿名函数。
 */