package p3_advanced.p2_advancedUseOfFunctions.p3_lambdaExpressions

/*
4 在Lambda表达式中返回数据
在Lambda表达式中返回数据主要有两种方式:一种是 自动返回，Lambda 表达式的最后一行语句的执行结果会自动作为返回值;
另一种是手动返回，即使用return语句。
*/
//[举例]判断参数是偶数还是奇数，并自动返回对应的字符串。具体代码如下:
val judge = { x: Int ->
    if (x % 2 == 0) {
        "偶数"
    } else {
        "奇数"
    }
}

//输出:偶数
//println (judge (4) )
/*
在这个例子中，
如果传入的参数可以被2整除,则Lambda表达式中最后执行的为if分支，所以返回字符串“偶数”。
如果传入的参数不可以被2整除，则Lambda表达式中else分支为最后执行的语句，返回字符串“奇数”。

如果需要手动返回值，则应该编写return 语句。但由于Lambda 表达式的上下文环境非常不直观，
所以为了避免混淆，从Lambda表达式中进行手动返回时需要明确指定需要返回的作用域。
*/
//[举例]用return语句指定Lambda表达式返回的作用域。具体代码如下:
fun traverse(list: List<Int>, f: (Int) -> String) {
    for (item in list) {
        println("应用$item,结果为${f(item)}")
    }
}

fun main() {
    traverse(listOf(1, 2, 3)) {
        if (it % 2 == 0) {
            return@traverse "偶数"
        }
        return@traverse "奇数"
    }
}
/*
输出结果如下:
应用1,结果为奇数
应用2，结果为偶数
应用3,结果为奇数
在这个例子中，return 语句退出了Lambda 表达式返回了traverse()函数。
*/


