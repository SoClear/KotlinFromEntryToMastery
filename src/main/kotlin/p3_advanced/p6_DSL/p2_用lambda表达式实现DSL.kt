package p3_advanced.p6_DSL

/*
1.普通API风格
（1）创建一个Cpu类，该类有两个属性，属性core代表CPU的核数，属性arch代表CPU的架构
 */
data class Cpu1(val core:Int,val arch:String)
/*
(2)创建一个Cpu1类的对象
 */
val cpu1=Cpu1(8,"64 bits")
/*
这段代码是通过创建类的方法来创建对象。在大部分的编程语言中，这都是最普通的API。
 */



/*
2.DSL API风格
（1）创建一个Cpu2类，由于数据类的构造方法必须包含所有参数，而DSL API风格的类一般在创建后才根据实际情况添加不同数量的参数，
所以这里采用了普通类来创建Cpu2类。
 */
class Cpu2{
    var core:Int=0
    var arch:String="32 bits"
    fun core(core:Int){
        this.core=core
    }

    fun arch(arch:String){
        this.arch=arch
    }
}

/*
该类包含core和arch两个属性外，还包含两个和属性同名的方法，这些方法可以为属性进行赋值。
（2）创建一个方法，该方法的参数为匿名函数，返回值为Cpu2类型。
 */
//参数为匿名函数类型
fun cpu1(block: (Cpu2) -> Unit):Cpu2{
    val cpu=Cpu2()
    block(cpu)
    return cpu
}

/*
这个cpu()方法的参数就是构建DSL的核心,它使调用方在构建实参时获得一个可控的上下文
（3）用这个cpu()方法创建一个Cpu2类的对象

fun main() {
    cpu1 {
        it.core(2)
        it.arch("64 bits")
    }
}
从这段代码中可以看到，使用DSL API风格创建Cpu2类的对象的方式和使用普通API创建的方式完全不同。
在cpu()方法lambda表达式参数中，程序获得了一个基于Cpu2类的上下文，在该上下文中可以通过直接调用隐式参数it引用未创建完毕的Cpu2对象。
这就是DSL的一个优点：可以获得一个重用不同方法的上下文，而不是显式使用类似“cpu.core(2)”这种每次都必须明确指定上下文的语句。

（4）这种写法还不够简洁，用扩展方法替代匿名函数作为函数类型可以进一步减少代码数量。
 */
//参数类型为Cpu类的扩展方法类型
fun cpu2(init: Cpu2.() -> Unit):Cpu2{
    val cpu=Cpu2()
    cpu.init()
    return cpu
}
/*
在使用该方法创建对象时，Lambda表达式自带接收者，所以可以不需要隐式参数it直接访问上下文中的成员
 */
fun main() {
    val c1= cpu2 {
        core(2)
        arch("64 bits")
    }

    //在这种内置DSL中也可以嵌入任何编程语句
    val c2= cpu2 {
        core(2)
        println("hello world")
        arch("64 bits")
        println("end task")
    }
}

/*
这种用法在基于DSL的构建构建（如Gradle）中非常常见。
虽然本实例对比了两种实现方式。但是实际上内部DSL更像是一种编程理念，所以并不存在一个标准能判断一个API是普通API还是DSL API。
 */