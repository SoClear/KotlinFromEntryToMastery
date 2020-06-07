package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p6_staticMember
import JavaBean4
/*

静态成员
Java类中的静态成员在导入Kotlin时会被映射为伴生对象的成员，所以，可以通过访问伴生对象来访问Java中的静态成员。
[举例]创建一个包含静态变量、静态常量和静态方法的Java类。具体代码如下:
public class JavaBean4 extends Object {
    //静态变量
    public static String path="/foo/bar";

    //静态常量
    public static final String baseUrl="http://localhost";

    //静态方法
    public static String getUrl(){
        return baseUrl+path;
    }
}
在kotlin代码中访问上面创建的Java类的静态成员
 */
fun main() {
    //输出：http://localhost
    println(JavaBean4.baseUrl)
    //输出：/foo/bar
    println(JavaBean4.path)
    //输出：http://localhost/foo/bar
    println(JavaBean4.getUrl())
}