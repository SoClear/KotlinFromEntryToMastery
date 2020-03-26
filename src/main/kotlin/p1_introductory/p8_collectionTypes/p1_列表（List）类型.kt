package p1_introductory.p8_collectionTypes

fun main() {
    /*
列表——一组有序的数据
按是否支持修改分为不可变列表和可变列表
特点：
数据有序
数据可以重复
支持随机访问
 */

    //1.不可变列表
    /*
    支持访问，不支持修改
     */

    //1.1在创建时指定元素
    /*
    语法；
    listOf<数据类型>(元素列表)
     */
    val list1 = listOf("java", "kotlin", "scala")
    println(list1)
    println(list1.javaClass)

    //1.2在创建列表时指定各元素的同时忽略空元素
    /*
    语法：
    listOfNotNull<数据类型>(元素列表)
     */
    val list2 = listOfNotNull("java", "kotlin", null)
    println(list2)
    println(list2.javaClass)

    //1.3使用构造方法
    /*
    语法：
    List(列表长度){
        Lambda表达式
    }
     */
    val list3 = List(3) {
        'a' + it
    }
    println(list3)
    println(list3.javaClass)


    //2.可变列表
    /*
    可变列表允许对列表元素进行修改
     */

    //2.1在创建列表时指定元素
    /*
    语法：
    mutableListOf<数据类型>(元素列表)
     */
    val list4 = mutableListOf("java", "groovy", "scala")
    println(list4)
    println(list4.javaClass)

    //2.2使用构造方法
    /*
    语法：
    MutableList(列表长度){
        lambda表达式
    }
     */
    val list5 = MutableList(3) {
        'a' + it
    }
    println(list5)
    println(list5.javaClass)


    //2.3创建基于ArrayList的列表
    /*
    用该方法会创建底层实现为java.util.ArrayList的kotlin列表
     */
    val list6 = arrayListOf("java", "kotlin", "scala")
    println(list6)
    println(list6.javaClass)


    //3.空列表
    /*
    空列表是一种不包含任何元素的不可变列表
    语法：
    emptyList<数据类型>()
     */
    val intEmptyList = emptyList<Int>()

    /*
    空列表的最主要应用场景就是作为返回值返回给调用方，使调用方法不需要额外做空值判断。
     */
    fun selectItems(): List<String> {
        val resultList = listOf("java", "kotlin")
        return if (resultList == null) emptyList() else resultList
    }

    fun doSomething() {
        val item = selectItems()
        for (it in item) {
            println(it)
        }
    }

    doSomething()


}
