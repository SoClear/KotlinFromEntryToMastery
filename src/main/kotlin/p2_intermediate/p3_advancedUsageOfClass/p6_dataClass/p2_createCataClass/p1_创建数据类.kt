package p2_intermediate.p3_advancedUsageOfClass.p6_dataClass.p2_createCataClass

/*
创建数据类
创建一个数据类必须遵守以下几个原则:
●主构造方法至少需要包含一个属性。
●主构造方法只能包含属性，不能包含参数，即必须用var或val修饰。
●在声明数据类时，不能添加abstract、open、 sealed 或inner修饰符。


[举例]创建一个用于表示学生的数据类。具体代码如下:
data class Student (var name: String, var no: Int)
编译器会根据在数据类的主构造方法中定义的属性自动创建以下几个方法:
●equals()- 用于对象间的比较。
●hashCode()-用于计算对象的哈希值。
●toString() 用于计算表示对象的字符串。
●componentN()-用于对对象进行解构操作。
●copy()用于基于当前对象复制-个新的对象。
 */