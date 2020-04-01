package p2_intermediate.p3_advancedUsageOfClass.p4_commpanionObject

/*
伴生对象可以任意访问外部类的私有成员，而外部类也可以任意访问伴生对象的私有成员，
所以在实际应用中，伴生对象可以为外部类提供类似Java那样的静态成员。
*/
//[举例]修改12.4.1 节中的例子，在外部类AlertDialog1和伴生对象Factory中都添加一个私有属性。具体代码如下:
class AlertDialog1(var title: String, var message: String) {
    //外部类中的私有属性
    private var shown: Boolean = false

    fun copy(): AlertDialog {
        //外部类访问伴生对象中的私有属性
        countOfInstance++
        return AlertDialog(title, message)
    }

    companion object Factory {
        //伴生对象中的私有属性
        private var countOfInstance: Int = 0

        fun create(message: String): AlertDialog1 {
            countOfInstance++
            return AlertDialog1("Default", message)
        }

        fun show(message: String) {
            val dialog = create(message)
            //伴生对象访问外部类中的私有属性
            dialog.shown = true
        }
    }
}

/*
从这个例子中可以看到:外部类的copy()方法通过修改伴生对象的countOfInstance属性来实现统计创建的实例的个数的功能，
而伴生对象中的show()方法通过修改外部类的shown属性来控制对话框是否显示。
这种外部类和伴生对象间的无缝访问，正是伴生对象的最大优点。
 */