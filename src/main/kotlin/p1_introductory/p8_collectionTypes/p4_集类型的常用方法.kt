package p1_introductory.p8_collectionTypes

fun main() {
    //1.获得集类型的长度
    val set1 = setOf("java", "kotlin")
    println(set1.size)

    //2.添加元素到可变集
    val set2 = mutableSetOf("java", "kotlin")
    set2.add("scala")
    println(set2)

    //3.删除可变集中的元素
    val set3 = mutableSetOf("java", "kotlin")
    set3.remove("java")
    println(set3)
    set3.remove("go")
    println(set3)

    //4.遍历集中的元素
    val set4 =
        setOf("java", "kotlin", "C++", "scala", "groovy", "C", "python", "go", "JavaScript", "TypeScript", "lua", "C#")
    for (lang in set4) {
        print("$lang ")
    }
}