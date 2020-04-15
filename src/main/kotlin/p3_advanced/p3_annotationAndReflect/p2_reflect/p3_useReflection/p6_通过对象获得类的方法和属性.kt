package p3_advanced.p3_annotationAndReflect.p2_reflect.p3_useReflection

/*
6.通过对象获得类的方法和属性
上面几种用法都是通过类的引用来获得类中定义的方法和属性。
从Kotlin版本1.1开始，反射API也支持通过对象获得类的方法和属性。
*/
//[举例]通过字符串对象获得replace()方法和length属性。
fun main() {
    val word="hello world"
    //获得replace()方法
    //必须显示声明replaceRef的类型才能获得对应的replace()方法
    val replaceRef:(String,String,Boolean) -> String=word::replace
    //输出：good world
    println(replaceRef("hello","good",false))


    //获得length属性
    val length=word::length
    //输出：11
    println(length.get())
}
