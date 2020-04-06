package p2_intermediate.p6_regularExpression

/*
使用正则表达式对象的machs()方法，可以检测给定的文本是否与规则相匹配。
该方法的返回值为布尔类型。若返回true,，则表示文本匹配;若返回false, 则表示文本不匹配。
*/
//[举例]检测给定的文本是否包含由大写字母和任意小写字母构成的子串。具体代码如下:

fun main() {
    //创建正则表达式对象
    val regex1 = "[A-Z] [a-z]+".toRegex()
//检查是否匹配
    if (regex.matches("Hello")) {
        println("匹配大写字母和小写字母的组合")
    }
}

