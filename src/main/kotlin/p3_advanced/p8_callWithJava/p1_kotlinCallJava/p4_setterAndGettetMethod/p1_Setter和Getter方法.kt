package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p4_setterAndGettetMethod
import JavaBean3
/*
Setter 与Getter方法
Kotlin会将Java中单独的Getter方法当作只读属性来对待，会将一对Setter/Setter访问器当作可写属性来对待。
所以在Kotlin中，可以通过访问属性的方式访问Java中的Setter/Setter访问器。
[举例]在Kotlin代码中访问Java中的Setter/Setter访问器。
(1)创建一个Java类，具体代码如下:
public class JavaBean3 {
    private String name;
    private boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //非字段的Getter/Setter方法
    public String getA(){
        return "A";
    }

    public void setA(String a){
        //什么都不做
    }
}


（2）编写kotlin代码调用这两组方法
 */
fun main() {
    val jb3=JavaBean3()
    //调用setName()方法
    jb3.name="foo"
    //调用getName()方法
    println(jb3.name)

    //调用setEnabled()方法
    jb3.isEnabled=true
    //调用isEnabled()方法
    println(jb3.isEnabled)

    //调用setA()方法
    jb3.a="B"
    //调用getA()方法
    println(jb3.a)
}
/*
从这个例子中可以看到，只要在Java中创建了Setter/Setter 方法(即使方法没有对应的字段)，Kotlin就会以方法名为基准创建对应的属性。
如果Getter方法返回的是布尔值，且方法名为"“isXxx”形式，则Kotlin生成的属性也是“isXX”形式。

提示:
由于Kotlin中只有“只读”属性和“可写”属性，没有“只写”属性，所以，如果在Java类中只定义了Setter 方法而没有定义Getter方法，
那么Kotlin并不会为其创建属性，此时只能通过方法名来调用它。
 */