package p3_advanced.p1_extensionAndDelegation.p2_delegation.p4_built_inPropertyDelegation

/*
1.使用延迟加载属性委托

延迟加载是相对于立即加载而言的。
在类中为属性设置初始值就是一种立即加载方式，当对象创建完成后该属性的值就确定了。
而延迟加载是指，“为属性设置初始值”这个过程从创建对象时被延迟到了第一次使用该属性时。
在Kotlin中实现延迟加载需要使用Lazy类的实例作为委托对象，并且只有只读属性可以进行延迟加载。
Lazy类的实例可以通过lazy()函数来创建，
该函数接受一个 Lambda表达式作为参数，并返回Lazy<T>的实例。
当第1次访问延迟加载属性时， Lambada表达式会被执行， 其计算结果会被保存起来，
之后再次访问该属性时只会获得已经被保存的值，而不会重新执行计算过程。
*/
//[举例]创建-个包含延迟加载属性aLazyProperty 的类。具体代码如F:
class A {
    val aLazyProperty: Long by lazy {
        println("Compute...")
        Thread.sleep(3000)
        System.currentTimeMillis()
    }
}
/*
在这段代码中，Lambda 表达式的最后一行会作为aLazyProperty属性的值进行保存。下面运行以下测试代码:
*/
fun main() {
    val a=A()
    println("Hello 1, ${a.aLazyProperty}")
    println("Hello 2, ${a.aLazyProperty}")
}
/*
输出结果如下:
Compute...
Hello 1, 1545987167601
He11o 2, 1545987167601

观察输出结果可以看到，两次访问该属性的时间尽管相隔了3s,但是这两次访间的输出结果还是相同的。
由此可以验证在延迟加载时只有第一次的计算结果会被进行保存。


除以上用法外，lazy()函数还有一个包含两个参数的版本，其参数含义如下:
●LazyThreadSafetyMode枚举类型————该参数表示线程安全模式，线程安全模式可以用来控制延迟加载是否需要保证线程安全。
    该枚举类包含以下3个枚举常量:
    SYNCHRONIZED--采用同步方式(默认值)同一时刻只能有一个线程进行修改
    PUBLICATION-支持多线程进行计算，但只保存第1个完成计算的线程结果。
    NONE-没有任何限制，效率最高，适合单线程执行计算的程序。

●Lambda表达式一 用于计算属性值，第一次计算的结 果会被保存。


*/

//[举例]在延迟属性上应用线程安全模式。具体代码如下:
class A1 {
    //设置线程安全模式为LazyThreadsSafetyMode.SYNCHRONIZED
    val aLazyProperty: Long by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        println("Compute..。")
        Thread.sleep(3000)
        System.currentTimeMillis()
    }
}
