package p3_advanced.p4_exception.p2_exceptionHandling

import java.lang.NumberFormatException

/*
处理 try表达式中的异常

try语句也可以作为表达式来使用，该表达式中最后一行语句的执行结果就是表达式的值。
*/
//[举例]将字符串转换为整数，如果转换失败则返回数字0。具体代码如下:
fun parseNumber(s:String):Int{
    if (s==""){
        return 0
    }

    //try表达式
    return try {
        //这一行就是表达式的返回值
        Integer.parseInt(s)
    }catch (e:NumberFormatException){
        0
    }
}
    /*
try表达式也可以结合finally代码块来使用。
但是与上节使用return语句不同的是，这种情况下的finally代码块不会影响到实际的返回值。
*/
//[举例]在try表达式的finally代码块返回值。具体代码如下:
    fun parseNumber1(s:String):Int{
        if (s==""){
            return 0
        }

        //try表达式
        return try {
            //这一行就是表达式的返回值
            Integer.parseInt(s)
        }catch (e:NumberFormatException){
            0
        }finally {
            -1
        }
    }

/*
在这个例子中，虽然finally代码块中最后行执行结果是数字“一1”，
但是由于使用了try表达式，所以“-1” 这个值会被抛弃。
当转换失败时，result变量会被赋值为0。
*/
