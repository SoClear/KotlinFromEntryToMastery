package p2_intermediate.p1_mappingType

fun main() {
    /*
    空映射是一种不包含任何元素的不可变映射
    语法：
    emptyMap<键类型,值类型>()
    因为没有元素，编译器不能自动推断类型，所以这里的数据类型声明不能被省略。
    和空列表一样，空映射的主要场景是作为返回值返回给调用方，使得调用方不在额外再做空值判断。
     */
    val emptyMap = emptyMap<String, String>()
}