package p2_intermediate.p6_regularExpression

/*
使用正则表达式对象的replaceFirst()方法或replace()方法，可以实现文本替换功能。
●replaceFirst()方法只会替换第1个匹配的结果。
●replace()方法会替换所有匹配结果。

这两个方法都包含两个参数:第1个参数为给定的文本，第2个参数为需要替换成的子串。
这两个方法会返回一个新的字符串对象，该字符串就是替换后的结果(原有字符串不会改变)。
*/
//[举例]在给定文本中替换所有以数字开头且以非单词字符(空格符等)结尾的所有子串。具体代码如下:

fun main() {
    //给定文本
    val input = "99 bottles, 98 bottles"
    //正则表达式
    val regex = """[0-9]+\W""". toRegex()
    //替换匹配的第1个结果
    val result = regex.replaceFirst (input, "xxx")
    //匹配了99，输出: xxxbottles, 98 bottles
    println (result)

}
