package p3_advanced.p3_annotationAndReflect.p2_reflect.p3_useReflection

/*
5.构造方法
(1)获得构造方法。
构造方法在反射API中也属于KFunction类型，使用“::类名”这样的语法就可以获得一个类的构造方法。
*/
//[举例]获得了Person4类的构造方法。具体代码如下:
class Person4
val personConstructor = ::Person4
/*
按照KFunction类型的定义，如果在构造方法中包含属性，则需要使用对应的编译器生成类型存储该引用。
*/
//[举例]获得包含一个属性的User类的构造方法，其编译器生成类型为KFunction1。具体代码如下:
class User (val name:String)
var userConstructor=::User


/*
(2) 调用构造方法。
既可以像普通KFunction类型实例那样调用invoke()方法创建对象，也可以直接用小括号形式(构造方法)创建对象。
在获得构造方法的引用后，

[举例]在获得构造方法后，用构造方法和invoke()方法创建对象。具体代码如下:
*/
fun main() {
    //方式一：用构造方法创建User类的对象
    val user1= userConstructor("Peter")
    //方式二：用invoke()方法创建User类的对象
    val user2= userConstructor.invoke("Peter")
}

