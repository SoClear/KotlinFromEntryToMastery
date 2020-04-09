package p3_advanced.p1_extensionAndDelegation.p1_extension

/*
扩展伴生对象

扩展功能也可以应用在伴生对象上。
如果在声明伴生对象时省略了该伴生对象的类名，
则在添加扩展功能时需要使用默认的类名Companion作为接收者类型。
*/
//[举例]创建一个Dialog类，在该类内部创建一个使用默认类名的伴生对象。具体代码如下:
class Dialog(val title: String) {
    //使用默认类名的伴生对象
    companion object {
        fun createDialog(title: String): Dialog {
            return Dialog(title)
        }
    }
}
//接下来为伴生对象添加一个扩展方法并进行测试，具体代码如下:
//为伴生对象添加扩展方法
fun Dialog.Companion.createWarningDialog():Dialog {
    return Dialog("warning")
}
//测试扩展方法
fun main() {
    Dialog. createWarningDialog()
}
