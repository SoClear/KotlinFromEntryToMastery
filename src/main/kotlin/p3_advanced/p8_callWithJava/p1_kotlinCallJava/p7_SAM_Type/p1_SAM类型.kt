package p3_advanced.p8_callWithJava.p1_kotlinCallJava.p7_SAM_Type
import JavaBean5
/*
SAM (Single Abstract Method)类型是指只包含一个抽象方法的类型。在Java中，这种接口也被称作函数式接口。
从Java 8开始，可以用Lambda表达式作为函数式接口的参数，而Kotlin 也支持该功能。
[举例]在Java程序中创建一个函数式接口onClickListener()，并使用该接口的JavaBean 类。
具体代码如下:
//函数式接口，包含一个默认方法onTouch()和一个抽象方法onClick()
public interface onClickListener {
    default void onTouch(){
        System.out.println("onTouch");
    }

    void onClick();
}

public class JavaBean5 {
    //用函数式接口作为参数
    public void setOnclickListener(onClickListener onClickListener){
        onClickListener.onClick();
    }
}

然后，在Java中用Lambda表达式作为setOnClickListener()方法的参数，具体代码如下:
public static void main (String[] args){
    JavaBean javaBean = new JavaBean ("");
    javaBean.setOnClickListener(() -> {
        System.out.println("单击按钮");
    });
}
在kotlin代码中，同样可以使用Lambda表达式最为setOnClickListener()方法的参数，
 */

fun main() {
    val jb5=JavaBean5();
    jb5.setOnclickListener {
        println("点击按钮")
    }
}
