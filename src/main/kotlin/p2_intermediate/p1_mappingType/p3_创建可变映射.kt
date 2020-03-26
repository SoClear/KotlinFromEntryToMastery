package p2_intermediate.p1_mappingType

fun main() {
    /*
    可变映射支持访问和对映射元素的修改
     */
    //1.在创建映射类型时指定各元素
    /*
    语法：
    mutableMapOf<键类型，值类型>(键值对列表)
     */
    val mutableMap1 = mutableMapOf("name" to "Peter", "nation" to "USA")
    println(mutableMap1.javaClass)

    //2.创建底层为java.util.HashMap类的可变映射
    /*
    语法：
    hashMapOf<键类型，值类型>(键值对列表)
     */
    val hashMap1 = hashMapOf("name" to "Peter", "nation" to "USA")
    println(hashMap1.javaClass)

    //3.创建底层为java.util.LinkedHashMap类的可变映射
    /*
    语法：
    LinkedMapOf<键类型，值类型>(键值对列表)
     */
    val linkedHashMap1 = linkedMapOf("name" to "Peter", "nation" to "USA")
    println(linkedHashMap1.javaClass)

    //4.创建底层为java.util.TreeMap类的可变映射
    /*
    语法：
    sortedMapOf<键类型，值类型>(键值对列表)
     */
    val treeMap = sortedMapOf("name" to "Peter", "nation" to "USA")
    println(treeMap.javaClass)
}