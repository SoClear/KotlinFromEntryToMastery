package p1_introductory.p8_collectionTypes

fun main() {
    //1.获取列表的长度
    val list1 = listOf("java", "kotlin")
    println(list1.size)

    //2.通过索引访问列表中的元素
    val list2 = listOf("java", "kotlin", "scala")
    println(list2[1])

    //3.添加元素到可变列表中
    val list3 = mutableListOf("java", "kotlin")
    list3.add("C++")
    println(list3)

    //4.修改可变列表中的元素
    val list4 = mutableListOf("java", "kotlin")
    list4[0] = "C++"
    println(list4)

    //5.删除可变列表中的元素
    val list5 = mutableListOf("java", "kotlin", "groovy", "scala")
    list5.remove("java")
    println(list5)
    list5.remove("go")
    println(list5)

    //6.根据索引删除可变列表中的元素
    val list6 = mutableListOf("java", "kotlin", "groovy", "scala")
    list6.removeAt(2)
    println(list6)

    //7.遍历列表
    //7.1遍历列表中的元素
    val list7 = mutableListOf("java", "kotlin", "groovy", "scala")
    for (lang in list7) {
        println("element is $lang")
    }

    //7.2遍历列表中的索引
    val list8 = mutableListOf("java", "kotlin", "groovy", "scala")
    for (i in list8.indices) {
        println("index is $i,element is ${list8[i]}")
    }
}