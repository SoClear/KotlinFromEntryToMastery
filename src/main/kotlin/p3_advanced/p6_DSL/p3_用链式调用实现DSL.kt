package p3_advanced.p6_DSL

/*
内置 DSL 的另一一种实现方式是使用链式调用。
链式调用是指,在一个对象上连续调用多个方法。
所以,这些方法都需要将当前对象作为方法的返回值。下面看一个链式调用的例子。
(1) 创建一个表示对话框的 AlertDialog类,该类包含标题(title)和消息(message)两个属性,
每个属性都有一个对应的修改其值的方法,这些方法最后都会将当前对象(this)返回,代码如下
 */

class AlertDialog{
    var title:String=""
    var message:String=""
    fun title(title:String):AlertDialog{
        this.title=title
        return this
    }

    fun message(message:String):AlertDialog{
        this.message=message
        return this
    }
}
/*
(2)用链式调用创建该类的-个对象，具体代码如下:
*/
val dialog=AlertDialog().title("Info").message("hello world")

/*
(3)用中缀表达式重新定义AlertDialog,以进一步简化调用方式，具体代码如下:
*/
class AlertDialog1{
    var title:String=""
    var message:String=""
    infix fun title(title:String):AlertDialog1{
        this.title=title
        return this
    }

    infix fun message(message:String):AlertDialog1{
        this.message=message
        return this
    }
}
/*
(4)重新创建AlertDialog1类的对象，具体代码如下:
*/
val dialog1=AlertDialog1() title "Info" message "hello world"
/*
从这个例子中可以看到，省略点操作符(.) 后的这段文字与人类的语言习惯非常相近。
这种用法常被用来编写测试框架中的各种场景描述(在某种场景下运行代码后应该产生某种结果)。

 */