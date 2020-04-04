package p2_intermediate.p3_advancedUsageOfClass.p7_enumeration

/*
枚举类————常量集
枚举类（Enumeration）是一种使用“enum”关键字声明的特殊类，
它的主要功能是表示一组类型安全的常量。
这里的类型安全是指：在使用枚举类作为参数类型时，在方法调用处可以获知传递的实参是否在指定的范围内（枚举常量列表），
而一般数据类型则无法做到这点
 */
//【举例】用一般数据类型作为参数类型
fun isRunning(i: Int){
    if (i==1){
        println("系统运行中")
    }else if (i==0){
        println("系统停止中")
    }else{
        println("参数非法")
    }
}

/*
在这个例子中，isRunning()方法的参数为Int型，但是该方法实际只能处理数字1和数字0，
其余Int类型数据都被当做非法参数进行处理。
在调用该方法时是无法获得这个限制条件的，枚举类就是为了解决这个问题而诞生的。
 */