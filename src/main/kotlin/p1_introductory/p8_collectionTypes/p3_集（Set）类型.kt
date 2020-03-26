package p1_introductory.p8_collectionTypes

fun main() {
    /*
    集——不重复的一组数据
    Kotlin中的Set类型，也可以按照是否支持修改操作分为不可变集合可变集。
    Set类型中的数据不可重复，也不能像List类型那样直接通过索引随机访问元素。
     */

    //1.不可变集
    /*
    不可变集只支持访问操作，不支持任何修改操作。
    语法：
    setOf<数据类型>(元素列表)
     */
    val set1 = setOf("java", "kotlin", "scala")
    println(set1)
    println(set1.javaClass)

    //2.可变集
    /*
    支持访问和修改。
     */
    //2.1在创建时指定元素
    /*
    语法：
    mutableSetOf<数据类型>(元素列表)
     */
    val set2 = mutableSetOf("java", "groovy", "scala")
    println(set2)
    println(set2.javaClass)

    //2.2创建底层为java.util.hashSet的可变集
    /*
    语法：
    hashSetOf<数据类型>(元素列表)
     */
    val set3 = hashSetOf("java", "groovy", "scala")
    println(set3)
    println(set3.javaClass)

    //2.3创建底层为java.util.LinkedHashSet的可变集
    /*
   语法：
   linkedSetOf<数据类型>(元素列表)
    */
    val set4 = linkedSetOf("java", "Kotlin", "scala")
    println(set4)
    println(set4.javaClass)

    //2.3创建底层为java.util.TreeSet的可变集
    /*
    TreeSet中的数据是按照数据的大小排序的
   语法：
   sortedSetOf<数据类型>(元素列表)
    */
    val set5 = sortedSetOf("java", "Kotlin", "Scala")
    println(set5)
    println(set5.javaClass)
}