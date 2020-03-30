package p2_intermediate.p2_classAndObject.p7_property

/*
声明属性有两个关键字：
· 用var关键字声明的属性是可写属性，在声明后可以对其进行修改。
· 用val关键字声明的属性是只读属性，在完成第一次初始化操作后就不能对其进行修改。

属性可以是空类型，也可以是非空类型。
 */
//【举例】创建包含属性的Computer类。该类的主构造方法只的disk和类体中的cpus都是Computer类的属性。前者为可写属性，后者为只读属性。
class Computer(val disk:String){
    var cpus=0
}

fun main() {
    /*
    在创建对象后，可以通过点操作符（.）来访问对象的属性
     */
    //创建对象
    val computer=Computer("200GB")
    //修改属性值，实际调用了Setter访问器
    computer.cpus=2
    //读取属性值，实际调用了Getter访问器
    println(computer.disk)
}

/*
访问对象的属性，在底层是通过调用该属性对应的访问器来实现的。
在kotlin中，每定义一个属性时都会自动创建一个默认的访问器：
如果是只读属性，则会自动创建Getter访问器；如果是可写属性，则会自动创建Getter和Setter访问器。
 */