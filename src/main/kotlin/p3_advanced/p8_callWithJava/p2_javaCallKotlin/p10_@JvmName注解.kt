package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
@JvmName 注解
@JmName有一个重要作用————修改JVM层面的导出名。
这样即使在类中有多个签名完全相同的成员(如:扩展子泛型类的方法)，
只要它们的JVM导出名是不一一样的，代码就能够正常编译和工作。
@JvmName注解可以应用到函数、Setter/Getter 访问器或属性上。

[举例]在Kotlin程序中创建两个基于List类型的扩展方法，具体代码如下:
fun List<String>.accumlate():String{
    return joinToString(",")
}

@JvmName ("accumlateInt")
fun List<Int>.accumlate(): Int {
    return sum()
}

这两个方法的签名是完全一样的， 如果不加t@JvmName注解，则只能同时声明一个方法。
然后在Java程序中调用这两个方法，
具体代码如下:
public class JavaCallKotlin{

    public static void main (tring[] args){
        //构建List类型对象
        List<String> langs = new Arraylist<>();
        Collection.addAll(langs,"java","Groovy","kotlin");
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums,1,2,3);

        //调用List<String>.accumlate()方法
        String langResult =GlobalUtils.accumlate(langs);
        //调用List<Integer>.accumlate()方法
        int numsResult =GlobalUtils.accumlateInt(nums);

        //输出：Java,Groovy,Kotlin
        System.out.println(langResult);
        //输出：6
        System.out.println(numsResult);
    }
}

【举例】在Java程序中创建使用注解修饰的Getter访问器与status属性
*/
class KotlinBean10{
    //没有显式地Setter访问器
    @set:JvmName("setDefaultStatus")
    var status:Int=0
        @JvmName("getOpenStatus")
        get() = 2

    fun getStatus():Int{
        return 1
    }
}
/*
从这段代码可以看到，@JvmName注解也可以被用在没有显式声明的Setter访问器上。
接下来在Java代码中访问这些属性，代码如下

public c
 */
