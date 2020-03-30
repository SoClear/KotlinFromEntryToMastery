package p2_intermediate.p2_classAndObject.p7_property

/*在kotlin，创建默认的访问器的语法如下：
var cpus=0
    set
    get

在某些情况下，这种默认的访问器并不能满足我们的要求，此时可以手动自定义属性访问器。
要自定义属性访问器，必须遵守以下几个规则。
· 定义Getter访问器和Setter访问器应紧跟在属性名后面。
· 定义Getter访问器和Setter访问器没有顺序要求：可以先定义Getter访问器，也可以先定义Setter访问器。
· 在Getter访问器中需要返回当前属性值。
· 在Setter访问器中的参数列表中包含一个参数，该参数用来保存传递过来的实参值。
 */
//【举例】为Computer1类添加两个自定义的访问器
class Computer1(val disk: Int) {
    //属性
    var availableSpace = disk

    //自定义Getter和Setter访问器
    var usedSpace: Int
        get() {
            return disk - availableSpace
        }
        set(value)  {
            availableSpace -= value
        }
}

/*
在这个例子中，availableSpace属性代表电脑的可用空间，usedSpace属性代表电脑的已用空间
usedSpace属性的Getter访问器，会动态返回最新的硬盘已使用空间大小。
usedSpace属性的Setter访问器，会根据传递过来的值动态修改可用硬盘空间的大小。
 */

fun main() {
    val c=Computer1(100)
    println(c.availableSpace)
    println(c.usedSpace)
    c.usedSpace=10
    println(c.availableSpace)
    println(c.usedSpace)
    c.usedSpace=10
    println(c.availableSpace)
    println(c.usedSpace)
}
/*
我们再看一个例子。假设电脑类有一个价格属性，那么按照常识，价格肯定不能是负数的。
要实现这个功能，有人可能会写出下面这样的代码：
var price=0
    set(value){
        if(value<0){
            price=0
        }else{
            price=value
        }
    }

这段代码粗看没有什么大问，但是只要回想一下访问属性的底层实现方式就可以知道“price=0”语句实际调用了Setter访问器。
所以，这段代码的运行情况就是在Setter访问器中不停地调用Setter访问器，直到最后栈溢出，程序崩溃。
为了实现在访问器中为属性赋值操作，需要使用幕后字段。
 */