package p3_advanced.p3_annotationAndReflect.p2_reflect.p3_useReflection

/*
KCallable类型
KCallable类型是KFunction类型和KProperty类型的父类型，所以它既可以用于获得方法，也可以用于获得属性值。

(1)获得KCallable对象。
如果要获得KCallable类型的对象，
则可以在程序中通过KClass实例的members属性获得类中所有KCallable类型的成员，
也可以在获得KFunction类型和KProperty类型实例时将结果保存在KCallable类型的变量中。
*/
//[举例]获得KCallable类型的对象。这里采用第2种方式————
// 将KFunction类型的sayHello()方法和KProperty类型的age属性值都赋值给KCallable类型的变量。具体代码如下:
//首先创建Person3类
class Person3 {
    var age=25

    fun sayHello(message: String) {
        println("hello $message")
    }
}

//获得sayHello()方法的引用
//var sayHelloCallable= Person1::sayHello
//获得age属性的引用
//var ageCallable= Person3::age

//(2)用KCallable对象调用方法及获取属性。
//KCallable类型包含一个call()方法，可以用来调用方法或获取属性值，具体代码如下:

fun main() {
    //创建Person3类的对象person
    val person=Person3()

    //获得sayHello()方法的引用
    var sayHelloCallable= Person3::sayHello
    //调用sayHello()方法
    sayHelloCallable.call(person,"bye")

    //获得age属性的引用
    var ageCallable= Person3::age
    //获取age属性值
    val age= ageCallable.call(person)
    println(age)
}

/*
从这个例子中可以看到，上述获取属性时使用的是无参数的call()方法，
而在调用方法时，call()方法的第1个参数是拥有该方法的对象，从第2个参数开始是方法的参数列表。

提示:
KFunction的invoke()方法和KCallable的call()方法都可以调用被引用的目标方法，
但是两者还是存在本质区别:当所传实参的签名与方法不一致时，invoke()方法在编译期就会报错;
而call()方法只有运行时才会报错。
所以，在大多数情况下应尽量使用invoke()方法。
*/
