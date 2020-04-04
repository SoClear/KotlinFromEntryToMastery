package p2_intermediate.p3_advancedUsageOfClass.p6_dataClass.p3_theLimitationsOfBuilt_inMethods

/*
如果在数据类中手动定义了equals()、hashCode()和toString()方法，或者在数据类的父类中定义了这些方法的final实现（用final修饰），
则编译器就不会自动创建这些方法。
 */
//【举例】创建父类Item和继承该类的数据类RedBottle
//父类
open class Item(val price:Int){
    final override fun toString(): String {
        return "toString() from Item"
    }
}

//子类
data class RedBottle(val _price:Int,val hp:Int):Item(_price){
    override fun equals(other: Any?): Boolean {
        return if (other is RedBottle) other.hp==hp else false
    }
}

fun main() {
    val cheapBottle=RedBottle(100,10)
    val expensiveBottle=RedBottle(500,10)
    //调用了子类自定义的equals()方法
    println(cheapBottle==expensiveBottle)
    //调用了父类自定义的toString()方法
    println(cheapBottle)
}

/*
在这个例子中，父类Item包含了一个自定义的、用final修饰的toString()方法，
而子类RedBottle则包含了一个自定义的equals()方法。
根据这条规则，RedBottle类的实例就不会再自动创建toString()方法和equals()方法了，
而例子中最后的输出语句也证明了这一点。
 */