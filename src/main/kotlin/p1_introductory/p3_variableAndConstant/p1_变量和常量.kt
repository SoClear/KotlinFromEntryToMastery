package p1_introductory.p3_variableAndConstant

fun main() {
    //var:variable          val:value

    //变量
    //定义
    var moneyInPocket:Int

    //赋值
    moneyInPocket=100

    //定义并赋值
    var moneyInAlipay=100

    //常量
    val phone=123456789

    val os="IOS"
    val payChannel=when(os){
        "IOS"->"APP STORE"
        "Android"->"Google Play"
        else->"Offline"
    }
}