package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p3_nullableTypeAndPlatformMapping
import JavaBean2
/*
在Java中所有数据都可以为空，所以将Java数据类型引入Kotlin后，Kotlin 不能使用自身的类型安全机制来检查Java数据类型。
为此，Kotlin 使用平台类型这个特殊类型来标记导入的Java数据类型。
平台类型的表示方法是:在实际数据类型后加上感叹号。
平台类型“T!”是指数据类型可能是T,也可能是“T?”，即该数据可能是可空类型也可能是非空类型。
Kotlin 对平台类型放宽了类型检查机制，不会在编译期进行报错处理。
 */
//[举例]创建包含一个name属性的Java类。具体代码如下:\
/*
public class JavaBean2 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
在kotlin代码中，既可以将JavaBean对象的name属性设置为字符串，也可以将其设置为空值

 */
fun main() {
    val jb2=JavaBean2()
    jb2.name="Peter"
    jb2.name=null

    //将平台类型赋值给非空类型
    var name:String = jb2.name
    //下面这段代码会报错，因为name非空
//    name = null
}

/*
直接使用平台类型是不能保证类型安全的，最简单的解决方法是————将平台类型数据赋值给可空或非空类型的变量。
这样Kotlin的安全检查机制就能发挥作用。具体代码如下:
//将平台类型赋值给非空类型
var name:String = javaBean. name
//下面这段代码会报错，因为name非空
name = null

*/
