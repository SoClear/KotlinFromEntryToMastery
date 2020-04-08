package p2_intermediate.p7_genericParadigm.p3_typeParameterConstraint

/*
3 指定多个上界
如果需要在泛型类或泛型函数上同时声明多个上界，则需要采用不同的语法————where语句。
where语句需要放在类头或函数头的尾部，多个上界类型声明以逗号进行分隔，每个声明都应该包含类型参数和上界类型。
另外，由于是单继承，所以这些上界类型中只能有一个类型是类。
*/
//[举例]分别创建包含多个上界的函数remove()和包含多个上界的类MyList。具体代码如下:
//包含多个上界的函数
fun <T> remove(collection: T, item: T)
        where T : MutableIterable<T>, T : Collection<T> {
    val iterator = collection.iterator()
    while (iterator.hasNext()) {
        if (iterator.next() == item)
            iterator.remove()
    }
}
