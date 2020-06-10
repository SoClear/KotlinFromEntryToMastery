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
