package p2_intermediate.p6_regularExpression

/*
5.2.5 正则分组
正则分组就是将一个正则规则划分为多个组，位于后面的分组可以引用前面分组已经匹配过的结果。
在某些场景下，分组功能会非常有用。在正则规则中，小括号包含的部分会自动创建为一个分组(Group) 。
分组号从1开始，使用“\分组号”可以引用对应的分组结果。
*/

/*[举例]创建两个正则分组:“(d({)” 和“(d{2})”，并且引用了第2个分组“2”的匹配结果。
即:如果第2个分组的匹配结果是“10”，则必须匹配 “10-10” 。具体代码如下:
*/
fun main() {
    //包含了两个分组的正则表达式对象
    val regex = """(\d{4})-(\d{2})-\2""".toRegex()
    val matchResultSeq = regex.findAll("2015-10-10 11:22:33")
    for (matchResult in matchResultSeq) {
        //获得分组对象为MatchGroupCollection的实例
        val groups = matchResult.groups
        //遍历分组结果
        for (i in groups.indices) {
            println("$i ${groups[i]?.value}")
        }
    }
}

/*
输出结果如下：
0 2015-10-10
1 2015
2 10
 */

