package p2_intermediate.p2_classAndObject.p3_parametersOfFunction

 /*
 1.命名参数的概念
在调用函数时，通常形参和实参是一-对应的，
第1个实参赋值给第1个形参，第2个实参赋值给第2个形参，依此类推。
这种绑定实参的方式在Kotlin中被称为位置参数绑定。

位置参数在使用时比较不直观:如果一一个函数有多个同样类型的参数，则调用方很难得知传递的参数值是否正确。
为此，Kotlin还提供了命名参数的绑定方式。
命名参数是指，按照参数的名字来绑定参数。
命名参数的语法非常简单:在调用函数时，在实参前加上形参的参数名和等号。


2.使用命名参数
*/
//[举例]
//(1) 创建greeting()函数，该函数通过不同的问候语句对不同的人进行问候。具体代码如下:
fun greeting (name: String, word: String) {
     println("$word $name")
 }

//(2)使用位置参数调用该函数时，第1个参数是姓名，第2个参数是问候语句。具体代码如下:
//输出Hello, Peter
//greeting("Peter", "Hello,")

/*
(3)使用命名参数来改写上面这段代码。
这里需要注意，位置参数和命名参数虽然绑定参数的方式不同，
但它们的调用方式的输出结果是一模一样的。 具体代码如下:
 */
//输出Hel1o, Peter
//greeting(word = "Hello,", name = "Peter")

/*
3.混合使用命名参数和位置参数
除单独使用位置参数或命名参数外，Kotlin也允许同时使用位置参数和命名参数来调用函数。
但这种使用方式有一一个限制条件: 所有命名参数都必须位于位置参数后面。
*/
//[举例]同时使用位置参数和命名参数调用 greeting()函数。具体代码如下:
//定义一个函数
fun greeting1 (name: String, word: String, prefix: String, suffix: String){
    println("$prefix $word $name $suffix")
}

fun main() {
    //混合使用位置参数和命名参数，命名参数suffix和prefix都在位置参数后面
    greeting1("Peter","Hello",suffix = ")",prefix = "[")
}