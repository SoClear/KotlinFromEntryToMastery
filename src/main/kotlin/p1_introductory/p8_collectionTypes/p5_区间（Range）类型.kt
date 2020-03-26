package p1_introductory.p8_collectionTypes

fun main() {
    /*
    在Kotlin中区间一共有IntRange,LongRange,CharRange三种类型
     */
    //1.通过rangeTo()方法创建闭区间
    /*
    语法：
    开始值.rangeTo(末尾值)
     */
    for (i in 'a'.rangeTo('c')) {
        print("$i, ")
    }

    //2.通过区间操作符创建闭区间
    /*
    语法：
    开始值..末尾值
     */
    for (i in 1..3) {
        print("$i, ")
    }

    //3.通过until()方法创建左闭右开区间
    /*
    语法：
    开始值.until(末尾值)
     */
    for (i in 1.until(3)) {
        print("$i, ")
    }

    //4.用指定步长创建新的区间
    for (i in (1..5).step(2)) {
        print("$i, ")
    }

    //5.用倒序的方式创建新的区间
    for (i in (1..3).reversed()) {
        print("$i, ")
    }

    //通过downTo()方法直接指定步长递减的区间
    for (i in 3.downTo(1)) {
        print("$i, ")
    }

    //6.判断指定数据是否在区间范围内
    println((1..3).contains(2))
}