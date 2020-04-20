package p3_advanced.p4_exception.p2_exceptionHandling

/*
了解finally 代码块和返回值

除非在try代码块或catch代码块中强制调用了退出虚拟机的方法，
否则finally代块中的语句总是被执行。

那如果在try代码块或catch代码块中包含return 语句，程序又会如何运行呢?这里先来看一个例子。
*/
//[举例]在finally代码块中编写返回语句。具体代码如下:
fun test(): Int {
    try {
        return 1
    }finally {
        return 2
    }
}
fun main() {
    println(test())
}

/*
在这个例子中，调用test()方法后会获得返回值“2”，即try代码块中的返回值“1”会被直接抛弃。
实际上这段代码的底层执行逻辑是这样的:
●程序执行到try 代码块中的return 语句后发现还存在finally代码块，所以不立即返回，而是先执行finally代码块。
●程序执行到finally代码块中的return语句时返回调用处，方法终止，所以try代码块中的return语句的返回值没有返回到调用处就被抛弃了。

try代码块和catch代码块中的return语句或throw 语句都存在这种机制。
所以，为了避免代码逻辑混乱和由此可能造成的奇怪错误，一般不建议在finally语句中添加return语句或throw语句。
*/
