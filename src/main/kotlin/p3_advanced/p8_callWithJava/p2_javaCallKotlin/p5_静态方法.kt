package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
在kotlin中，可以将单例对象和伴生对象中的方法标记为@JvmStatic。
此时，kotlin既可以以该方法导出为实例方法，也可以将该方法导出为静态方法。
 */

//【举例】在单例对象Singleton5和Kotlin5类的伴生对象中，创建用@JvmStatic注解标记的方法。
//单例对象
object Singleton5{
    @JvmStatic
    fun fooByAnno(){
        println("使用@JvmStatic修饰的单例对象方法")
    }

    fun foo(){
        println("单例对象方法")
    }
}

class KotlinBean5(){
    //伴生对象
    companion object{
        @JvmStatic
        fun fooByAnno(){
            println("使用@JvmStatic修饰的伴生对象方法")
        }

        fun foo(){
            println("伴生对象方法")
        }
    }
}
/*
然后在Java程序中调用这些方法

import p3_advanced.p8_callWithJava.p2_javaCallKotlin.KotlinBean5;
import p3_advanced.p8_callWithJava.p2_javaCallKotlin.Singleton5;



public class CallKotlinBean5 {
    public static void main(String[] args) {
        KotlinBean5 kotlinBean5=new KotlinBean5();

        //伴生对象
        //导出的实例方法
        KotlinBean5.Companion.foo();
        //导出的静态方法
        KotlinBean5.fooByAnno();
        //导出的实例方法
        KotlinBean5.Companion.fooByAnno();

        //单例对象
        //导出的实例方法
        Singleton5.INSTANCE.foo();
        //导出的静态方法
        Singleton5.fooByAnno();
        //导出的实例方法
        Singleton5.INSTANCE.fooByAnno();
    }
}

 */