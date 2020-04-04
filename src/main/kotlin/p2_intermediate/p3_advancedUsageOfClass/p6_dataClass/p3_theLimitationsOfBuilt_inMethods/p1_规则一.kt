package p2_intermediate.p3_advancedUsageOfClass.p6_dataClass.p3_theLimitationsOfBuilt_inMethods

/*
了解内置方法的限制规则
在使用数据类中的内置方法时，会有以下一些限制规则。
1.规则一
数据类的主构造方法中的所有属性都会用于生成内置方法，
所以，如果希望某些属性能够被排除在这些方法之外，则应该将属性声明在类体中。
*/
//[举例]创建Student类，该类包含3个属性，其中两个属性定义在主构造方法中，一个属性定义在类体中。具体代码如下:

data class Student(var name: String, var no: Int){
    var seat:String=""
}

fun main() {
    val s1=Student("Peter",1)
    println(s1)
}
/*
输出结果如下:
Student (name=name, no=1)
在这个例子中，seat 属性定义在Student类的类体中，所以内置方法toString()不会包含该属性，
因此最后的打印语句只输出了主构造方法中的name属性和no属性。
 */