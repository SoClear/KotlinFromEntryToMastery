package p3_advanced.p1_extensionAndDelegation.p2_delegation.p4_built_inPropertyDelegation

/*
5.使用映射属性委托
映射属性委托允许将类中的属性值全部保存在Map对象中，于是访问属性就变成了访问改Map对象中对应的键值对。
使用映射属性委托，只需要在构造方法中定义一个Map类型的参数，然后将任意属性的委托对象设置为该参数即可。
*/
//[举例]创建Person类并使用映射属性委托。
//(1)在Person类的name属性和age属性上使用映射属性委托，具体代码如下:
class Person (map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}
//(2)创建一个该类的对象，
fun main() {
    //访问该对象属性的方式还是和访问普通属性的方式一样， 具体代码如下:
    val person=Person (mapOf (
        "name" to "John",
        "age" to 25
    ))

    //相当于调用person .map["name"]
    println (person.name)
    //相当于调用person ,map["age"]
    println (person.age)
}
/*
如果需更修改属性的值，则只需要将构造方法中的参数修改为MutableMap类型即可。
*/

