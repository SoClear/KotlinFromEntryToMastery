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
