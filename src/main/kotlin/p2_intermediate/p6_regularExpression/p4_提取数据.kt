package p2_intermediate.p6_regularExpression

/*
15.2.3 提取数据
使用正则表达式对象的find()方法或findAll()方法，可以提取给定文本中符合正则规则的子串。
find()方法，会返回匹配的第1个子串。
findA1l()方法，会返回匹配的所有子串。
匹配的子串会被包装为MatchResult类的实例进行返回。该类有一个value属性，这个属性的值就是匹配的子串。
[举例]从给定文本中提取所有以数字开头且以非单词结尾的子串。具体代码如下:
 */
fun main() {
    //给定文本
    val input="99 bottles, 98 bottles"
    //正则表达式
    val regex="""[0-9]+\W""".toRegex()
    //匹配结果
    val matchResultSeq=regex.findAll(input)

    //遍历匹配的结果
    for (matchResult in matchResultSeq){
        //value存储了匹配的子串
        println("find all ${matchResult.value}")
    }
}
/*
输出结果如下。注意，匹配的是“99加空格”
find all 99
find all 98

 */