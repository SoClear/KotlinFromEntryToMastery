package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
在java调用kotlin程序时，kotlin中的属性会被转换为私有字段、Getter访问器或者Setter访问器。
在转换时，如果属性名前缀为字符串“is”，比如“isXXX”，则生成的Setter访问器名为“setXXX()”，Getter访问器的名字是“isXXX”。
注意这里的转换关系只和属性名有关，和属性的类型无关。
【举例】举例在java中访问kotlin类的属性。
 */
class KotlinBean1(var name:String){
    var isAdult:Boolean=false
}
/*
import p3_advanced.p8_callWithJava.p2_javaCallKotlin.KotlinBean1;

public class CallKotlinBean1 {
    public static void main(String[] args) {
        //创建Kotlin对象
        KotlinBean1 kotlinBean1= new KotlinBean1("Peter");

        //读写name属性
        kotlinBean1.setName("Peter Park");
        System.out.println(kotlinBean1.getName());

        //读写isAdult属性
        kotlinBean1.setAdult(true);
        System.out.println(kotlinBean1.isAdult());
    }
}

输出：
Peter Park
true
 */