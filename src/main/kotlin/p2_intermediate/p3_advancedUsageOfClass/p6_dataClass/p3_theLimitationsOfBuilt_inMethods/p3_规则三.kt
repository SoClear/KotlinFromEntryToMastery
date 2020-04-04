package p2_intermediate.p3_advancedUsageOfClass.p6_dataClass.p3_theLimitationsOfBuilt_inMethods

/*
如果在父类型中声明了final 修饰的componentN()方法，或者该方法的签名与子类中的签名不兼容，则编译器会直接报错。
 */
//[举例]创建父类Parent 和继承该类的数据类Child, 并在Parent 类中创建一个自定义的component1()方法
open class Parent(val name:String){
    //用final修饰的componentN()方法
    final operator fun component1():String{
        return name
    }
}

//编译器报错
//data class Child(val aname:String):Parent(aname){}

/*
在这个例子中，由于父类的component1()方法是用final修饰的，所以编译过程会直接报错。
如果将final 修饰符替换成open修饰符，并将返回值类型由String修改为Int,
那么由于Int与子类构造方法中属性name的类型String并不兼容，编译器仍然会报错。
 */