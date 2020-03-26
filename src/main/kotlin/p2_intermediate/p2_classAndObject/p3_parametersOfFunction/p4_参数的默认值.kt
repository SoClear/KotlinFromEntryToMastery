package p2_intermediate.p2_classAndObject.p3_parametersOfFunction

/*
在Kotlin 中声明函数时，可以通过等号(=) 为参数设置一个默认值。
通过这种方式可以很容易实现Java中的方法重载功能。
所谓方法重载是指，多个方法虽然拥有相同的方法名，但是它们的参数列表是不同的。
[举例]为函数greeting()的参数word设置默认值“hello”。
如果在调用该函数时没有传递word参数，则会自动绑定默认值"Hello"。具体代码如下:
*/
//包含一个参数为默认值的函数
fun greeting1 (name: String, word: String = "Hello,") {
    println("$word $name")
}
fun main() {
    //在调用函数时省略了最后一个参数，所以输出“Hello, Peter’
    greeting1("Peter")
}
/*
而在Java中，同样的功能必须用两个重载方法来实现，具体代码如下:
public void greeting(String name, String word){
    System. out .println(word +" "+ name);
}
public void greeting (String name) {
    greeting (name, "Hello,");
}
从上面代码可以看出，用Kotlin替代Java可以少写一些代码。
 */