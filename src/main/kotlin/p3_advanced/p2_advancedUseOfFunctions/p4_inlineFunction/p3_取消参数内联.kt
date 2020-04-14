package p3_advanced.p2_advancedUseOfFunctions.p4_inlineFunction
/*
取消参数内联
默认情况下，内联函数中的函数类型参数也会被内联到函数调用处。
如果希望某些参数不被内联，则可以用noinline修饰该参数。
*/
//[举例]修饰reduce1()函数，禁止第2个参数被内联。具体代码如下:
inline fun reduce1 (list: List<Int>, noinline f: (Int, Int) -> Int): Int {
    var result = 0
    for (i in list) {
        result = f(i, result)
    }
    return result
}
