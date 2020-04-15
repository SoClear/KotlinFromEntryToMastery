package p3_advanced.p3_annotationAndReflect.p2_reflect.p3_useReflection

/*
KProperty类型

(1)获得KProperty对象。
KProperty在反射API中代表Kotlin中的属性，
在程序中可以通过“类名::属性名”这样的语法获得一个KProperty实例。
*/
//[举例]获得KPropery类型的对象。
//首先，创建一个类Person2，该类包含一个属性age, 具体代码如下:
class Person2 {
    var age: Int = 0
}
//然后，通过反射API获得age属性对应的KProperty实例，具休代码如下:
//nameRef的类型为
var nameRef= Person2::age
/*
在这个例子中，反射name 属性后获得的是KMutableProperty1类型的返回值，
该类型和KFunction不同，它是类库中真实存在的类型，而不是由编译器合成的类型，
这是因为属性和方法不一样，属性不会包含数量不定的参数。

反射属性后可以获得KProperty类型或KMutableProperty类型的对象，这两者的区别如下:
●KProperty类型对象对应于由val声明的属性，
 而KMutableProperty类型对象对应于由var声明的属性。
●KProperty类型对象包含一个表示数据类型的泛型参数。
 KMutableProperty 类型对象包含两个泛型参数，一个是拥有该属性的对象，另一个是该属性的类型。
●KProperty类型对象拥有一个get()方法可以获得属性的值，
 而KMutableProperty类型对象除拥有get()方法外，还拥有一个修改属性值的set()方法，
 该方法的第 1个参数是拥有该属性的对象，第2个参数是修改后的新值。




(2)通过KProperty对象修改属性。
[举例]通过反射API修改person 对象的name属性，井输出该属性的值。具体代码如下:
*/
/*
fun main() {
    val person = Person2()
    var ageRef= Person2::age
    //修改属性值
    ageRef.set(person,20)
    //获取属性值
    println(ageRef.get(person))

}
*/
/*
(3)顶层属性。
KProperty类型也可以用于顶层属性。由于顶层属性不属于任何类，所以在引用顶层属性时也无须添加类名。
*/
//[举例]获得顶层属性的KProperty对象。具体代码如下:
//顶层属性
var x= 2
fun main() {
//获取顶层属性的引用
    val xRef = ::x
    xRef.set(3)
    println(xRef.get())
}
