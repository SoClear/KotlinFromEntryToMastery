package p2_intermediate.p1_mappingType

fun main() {
    //1.获得映射的长度
    val map1 = mapOf("name" to "Peter", "nation" to "USA")
    println(map1.size)

    //2.通过键访问值
    val map2 = mapOf("name" to "Peter", "nation" to "USA")
    //2.1.访问映射
    println(map2["name"])

    //2.2.访问映射，键不存在时抛出异常
    /*
    语法：
    映射.getValue("键")
     */
    //因为没有键"phone",下面这句会抛出异常
//    println(map2.getValue("phone"))

    //2.3.访问映射，键不存在时返回默认值
    /*
    getOrDefault()方法和getOrElse()方法可以实现在指定的键不存在时返回的默认值
    getOrDefault()方法包含两个参数，第一个参数是指定的键，第二个参数是要返回的默认值
    getOrElse()方法包含两个参数，第一个参数是指定的键，第二个参数是用于创建默认值的Lambda表达式
     */
    var phone = map2.getOrDefault("phone", "13800000000")
    println(phone)
    phone = map2.getOrElse("phone") {
        "138" + "0000" + "0000"
    }
    println(phone)


    //3.修改可变映射
    val map3 = mutableMapOf("name" to "Peter", "nation" to "USA")
    //映射在键中，所以直接修改指定的键的值
    map3["name"] = "Tina"
    println(map3)
    //映射不在键中，所以新键值对会被追加到映射中
    map3["phone"] = "13300000000"
    println(map3)

    /*除了上述方法，kotlin还提供了putIfAbsent()方法。
    在使用putIfAbsent()方法时，如果键不在映射中，则新元素会被添加到映射中；
    如果键在映射中，则不执行任何修改
     */
    //姓名已经在映射中了，所以什么都不做
    map3.putIfAbsent("name", "Jane")
    println(map3)

    //4.删除可变映射中的元素
    val map4 = mutableMapOf("name" to "Peter", "nation" to "USA")
    //删除在映射中的键
    map4.remove("nation")
    println(map4)
    //删除不在映射中的键
    map4.remove("phone")
    println(map4)

    //5.遍历映射
    val map5 = mutableMapOf("name" to "Peter", "nation" to "USA")
    /*
    用for循环遍历映射，实际上是由Entry对象构成的Set集合。Entry类型包括key和value两个表示键值对的属性
     */
    for (entry in map5) {
        println("Traverse ${entry.key} is ${entry.value}")
    }

    /*
    kotlin还支持解构语法来获取Entry对象的key和value，这种方法使代码更加简洁
     */
    for ((k, v) in map5) {
        println("Traverse $k is $v")
    }
}