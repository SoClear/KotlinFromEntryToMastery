package p1_introductory.p7_arrayTypes

import java.util.*

/*
数组是一组相同类型的数据
引用型数组：数组中的所有数据都是引用类型。在kotlin中，任意创建一个引用型数组实际都是创建Kotlin包下Array类的实例。
基本数据类型数组：在系统底层是通过java中的包装类（Integer、Boolean)来实现的
在java中，每种基本数据类型数据都有对应的引用类型（包装类型）。基本类型数据在底层存储时更加高效，而包装类型由于是对象，所以它可以提供更多丰富的操作方法
 */

fun main() {
    //1.引用型数组
    //1.1创建指定长度的空数组
    /*
    语法：
    arrayOfNulls<数据类型>(数组长度)
    这种方式创建的数组允许包含可空类型的数据
     */
    var arr= arrayOfNulls<Int>(3)

    //1.2在创建数组时指定元素
    /*
    语法；
    arrayOf<数据类型>(元素列表)
    如果指定了元素列表，则可以省略数据类型声明
     */
    val arr1= arrayOf(1,2,3)

    //1.3使用Array类的构造方法
    /*
    语法：
    Array<数据类型>(数组长度){
        lambda表达式
    }
     */
    val arr2=Array<Int>(3){
        it+1
    }

    //1.4为数组指定不同数据类型元素（都是Any类型）
    val arr3= arrayOf(1,"2",true)



    //2.基本数据类型数组
    /*
    包括：IntArray,LongArray,FloatArray,DoubleArray,BooleanArray,ShortArray,ByteArray,CharArray
     */
    //2.1用构造方法创建指定长度的空数组
    /*
    语法：
    数组类型（数组长度）
     */
    val arr4=IntArray(3)

    //2.2在用构造方法创建数组的同时指定其包含的元素
    /*
    语法：
    数组类型(数组长度){
        lambda表达式
    }
     */
    val arr5=Array<Int>(3){
        it
    }

    //2.3在用内置函数创建数组的同时指定其包含的元素
    /*
    intArrayOf()：创建底层存储int类型数据的数组
    longArrayOf()：创建底层存储long类型数据的数组
    shortArrayOf()：创建底层存储short类型数据的数组
    byteArrayOf()：创建底层存储byte类型数据的数组
    doubleArrayOf()：创建底层存储double类型数据的数组
    floatArrayOf()：创建底层存储float类型数据的数组
    booleanArrayOf()：创建底层存储boolean类型数据的数组
    charArrayOf()：创建底层存储char类型数据的数组
    这些内置函数都带有一个参数，用来表示数组中包含的元素。
    函数的返回结果就是创建好的数组对象
     */
    val intArray= intArrayOf(1,2,3)
    val charArray= charArrayOf('h','e','l','l','o')



    //3.数组的常用操作
    //3.1获得数组的长度
    val arr6= intArrayOf(1,2,3)
    val size=arr6.size

    //3.2访问数组的某一个位置的元素
    val arr7=intArrayOf(1,2,3)
    val m1=arr7[0]
    println(m1)

    //3.3修改数组中的某一个位置的元素
    val arr8=intArrayOf(1,2,3)
    arr8[1]=20
    println(arr8.contentToString())

    //3.4遍历数组
    //3.4.1遍历数组中的元素
    val arr9=intArrayOf(1,2,3)
    for (n in arr9){
        println("element is $n")
    }

    //3.4.2遍历数组中的索引
    val arr10=intArrayOf(1,2,3)
    for (i in arr10.indices){
        println("index is $i,element is ${arr10[i]}")
    }

    //3.4.3同时遍历索引和值
    val arr11=intArrayOf(1,2,3)
    for (indexedValue in arr11.withIndex()){
        //indexedValue中保存着索引和对应的值
        println("index is ${indexedValue.index},element is ${indexedValue.value}")
    }
}