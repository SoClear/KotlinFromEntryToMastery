package p3_advanced.p6_DSL

/*
内置 DSL
用Lambda表达式构建上下文在Kotlin 编程中非常常见，
所以，Kotlin在语言层面直按提供了两个内置函数来简化创建过程，
这两个函数分别为，with()和apply()。
1. with()函数
with()函数包含两个参数，第1个参数是任意类型的对象，
第2个参数是使用第1个参数作为接收者的Lambda表达式。
[举例]用with()函数设置Cpu 对象的属性。 具体代码如下:
*/
fun main() {
    val cpu2=Cpu2()
    with(cpu2){
        core(2)
        arch("64 bits")
    }
}
/*
从这个例子中可以看到，Lambda表达式的上下文环境为cpu2对象，所以访问cpu2对象的任何成员时都无须先引用cpu对象。


2. apply()函数
apply()函数在Kotlin 中是作为所有类的扩展方法而存在的，该函数包含一个使用当前对象作为接收者的Lambda表达式。
[举例]用apply()函数为cpu对象设置属性。具体代码如下:
val cpu = Cpu()
cpu.apply {
    core (2)
    arch("64 bits")
}
 */