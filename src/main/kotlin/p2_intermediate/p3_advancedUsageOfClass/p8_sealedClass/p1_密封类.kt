package p2_intermediate.p3_advancedUsageOfClass.p8_sealedClass

/*
密时类是使用sealed修饰的特殊类，密封类类似于抽象类，是种专门被设计用来作为父类的类。
但是和抽象类不同，密封类的构造方法是私有的，只能由其密封类内部的类或单例对象来继承。
外部类试图继承时会报编译错误。
*/

//[举例]继承密封类。具体代码如下:
//密封类Parent
sealed class Parent {
    //嵌套类Child继承密封类
    open class Child : Parent() {
    }
}
/*
密封类的继承规则只作用在直接继承上。如果是间接继承，则无这样的限制。
*/
//[举例]在密封类外部间接继承密封类。具体代码如下:
//密封类Parent
sealed class Parent1 {
    //嵌套类Child继承密封类
    open class Child : Parent1() {
    }

    class Grandson : Parent.Child() {
    }
}