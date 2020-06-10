import p3_advanced.p8_callWithJava.p2_javaCallKotlin.KotlinBean10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CallKotlinBean10 {
    public static void main(String[] args) {
        List<String> langs=new ArrayList<>();
        Collections.addAll(langs,"Java","Kotlin","Groovy");
        List<Integer> nums =new ArrayList<>();
        Collections.addAll(nums,1,2,3);

        KotlinBean10 kotlinBean10=new KotlinBean10();
        //来自Kotlin类型的扩展方法
        kotlinBean10.setDefaultStatus(10);
        //输出：2
        System.out.println(kotlinBean10.getOpenStatus());
        //输出：1
        System.out.println(kotlinBean10.getStatus());

    }
}
