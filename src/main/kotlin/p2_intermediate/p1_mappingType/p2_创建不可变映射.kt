package p2_intermediate.p1_mappingType

fun main() {
    /*
    不可变映射只支持访问操作，不支持任何修改操作。
    不可变映射位于kotlin.collections包中，底层实现为java中的LinkedHashMap类，这是一种按照数据的插入顺序进行排序的有序集合。
    语法：
    mapOf<键类型,值类型>(键值对列表)
     */

    /*
    在kotlin中，键值对为Pair类。Pair类的构造方法接受两个参数，第一个表示键，第二个表示值。
     */
    val namePair = Pair("name", "Peter")
    /*
    可以用to()方法来简化上面的操作
     */
    val namePair1 = "name" to "Peter"


    //创建不可变映射
    val immutableMap1 = mapOf(Pair("name", "Peter"), Pair("nation", "USA"))
    val immutableMap2 = mapOf("name" to "Peter", "nation" to "USA")
    println(immutableMap1)
    println(immutableMap1.javaClass)
}