package p2_intermediate.p5_packageManagementAndAccessController

/*
访问控制符(Access Modifiers) 又被称为可见性修饰符(Visibility Modifiers) ，
主要用于控制被修饰的成员的可见性(该成员是否可以被访问)。

1.访问控制符的分类
访问控制符主要可以用在类、接口、构造方法、方法、属性、
setter访问器(getter 访问器的访问控制符无法被单独设置，它会自动和属性的访问控制符保持一致) 上。

Kotlin中的访问控制符主要分为以下四种。
●public: 默认的访问控制符，使用时可以被省略。修饰的成员总是可见。
●private:修饰的成员只在类内部可见。
●protected:修饰的成员只在类内部或该类的子类中可见。
●internal:修饰的成员只在类所在的模块中可见。
这里出现了一个新的概念————模块。
模块是Kotlin中的一个编译单元，表示放在一起编译的源文件。
一般而言，实际项目打包后输出的一个jar文件就是一个模块。

提示:
在java中，包与包之间不存在父子关系，即包a.b和包a.b.c是没有任何关系的。
所以，在a.b包中调用ab.c包中的方法时，必须将a.b.c包中的方法声明为public方法，
这使得在Java中编写SDK程序时无法保证程序的封装性(集成SDK的系统也能调用a.b.c包中的pubic方法)。
而在Kotlin中，模块级别的访问控制符很好地解决了这个问题。







2.构造方法上的访问控制符
构造方法默认都是由public修饰的，即:只要可以访问类就可以访问该类的构造方法。
如要修改构造方法的默认访问级别，则首先需要显式地为构造方法添加“constructor关键字，然后再添加对应的访问控制符。
*/
//[举例]创建一个带有私有主构造方法和私有副构造方法的类。具体代码如下:
//构造方法都是私有的， 外部无法进行访问
class A private constructor (desc: String) {
    private constructor() : this("default")

    companion object {
        //通过伴生对象创建实例
        fun create(): A = A()
    }
}





/*
3.类成员上的访问控制符
在类成员上添加的访问控制符具有传递性，即:
如果被重写的成员是由public修饰的，则重写后的成员也默认由public修饰
如果被重写的成员是由protected修饰的，则重写后的成员也默认由protected修饰
*/
//[举例]创建一个Parent类，在该类的子类Child和无继承关系的类Other中尝试访问Parent类的各种成员。具体代码如下:
//父类
open class Parent {
    //分别定义了4种访问级别的属性
    private var a ="private property"
    protected var b = "protected property"
    internal var c = "internal property"
    public var d = "public property"
    //属性被public修饰，Setter访问器被private修饰
    public var e:String=""
        private set(value) {
            field="private setter"
        }

    protected fun print(){
        println("protected setter")
    }
}


//子类
class Child:Parent(){
    fun test(){
        //子类中可以分为protected、internal、public的成员
        println(b)
        println(c)
        println(d)
    }
}

//与Parent类没有直接关系的类
class Other(val parent: Parent){
    fun test(){
        //同模块中的无关的类可以访问internal、public的成员
        println(parent.c)
        println(parent.d)

        //属性是public的，所以可以访问它的值
        println(parent.e)

        //下面这句会报错，因为Setter访问器是private修饰的成员
        //parent.e="other"
    }
}
