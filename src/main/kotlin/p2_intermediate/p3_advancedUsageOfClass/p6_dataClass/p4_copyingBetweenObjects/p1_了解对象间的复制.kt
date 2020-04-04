package p2_intermediate.p3_advancedUsageOfClass.p6_dataClass.p4_copyingBetweenObjects

/*
在设计模式中存在这样一种原型模式：通过复制原有对象来生成一个新对象。
数据类的copy()方法就可以用来实现这种原型模式，
但是需要注意的是：为了保证复制的效率，采用的是“浅拷贝的方式”
 */
//【举例】创建并复制Student类的对象。
// （1）创建一个数据类Student
data class Student(var name:String,var no:Int,var friends:MutableList<Student> = mutableListOf())
//(1)下面这段代码就是数据类自动生成的copy()方法，当前对象的属性值会作为copy()方法的参数列表的默认值
/*
fun copy(name: String=this.name,no:Int=this.age,friends:MutableList<Students>=this.friends)=Students(name,no,friends)
 */
//(3)创建一个Student类的对象peter,并调用该对象的copy()方法来创建tom和jane两个对象
fun main() {
    val peter=Student("Peter",3)
    val mary=Student("Mary",4)

    //用copy()方法创建两个新对象
    val tom=peter.copy()
    val jane=peter.copy(name = "")
    peter.friends.add(mary)

    println(peter)
    println(tom)
    println(jane)
}
/*
输出结果如下：
Student(name=Peter, no=3, friends=[Student(name=Mary, no=4, friends=[])])
Student(name=Peter, no=3, friends=[Student(name=Mary, no=4, friends=[])])
Student(name=, no=3, friends=[Student(name=Mary, no=4, friends=[])])

从这个例子中可以看到，通过copy()方法可以很容易的创建多个完全一致的对象。
但是由于采用的是浅拷贝的方式，所以当调用peter.friends.add()方法改变peter对象中的friends属性时，
tom和jane对象中的friends属性也会发生改变，因为这三者其实都是同一个引用。
 */
