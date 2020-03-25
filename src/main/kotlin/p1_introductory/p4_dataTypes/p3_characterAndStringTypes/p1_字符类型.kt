package p1_introductory.p4_dataTypes.p3_characterAndStringTypes

/*
字符（char）类型，是一种表示单个字符（如数字、字母、四则运算符、下划线等）的数据类型。
kotlin采用16位的Unicode字符集作为编码集，所以，字符类型可以表示所有语言中的字符。

语法：
'字符'
 */
//【举例】定义一个存储字符类型数据的变量
var aChar: Char='a'
//作为字符，而非数字
var anotherChar='1'

/*
如果想声明特殊类型字符，则需要在字符前加时转义符“\”。
下标给出了常用的特殊类型字符。
\n      换行符
\t      制表符
\\      \
\u0061  Unicode字符以\u开头。“\u0061”代表字符“a”。
 */