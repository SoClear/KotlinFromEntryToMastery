package p1_introductory.p6_processControl

/*
跳转语句分为三种类型：continue,break,return
 */

fun main() {
    //1.continue语句
    /*
    跳过当前循环，即中断当前循环，不执行continue后的语句，进入下一次循环
     */
    for (i in 1..5){
        if (i==3){
            continue
        }
        println("Continue $i")
    }

    /*
    在嵌套循环中跳过当前循环。注意，此时中断的是continue语句所在的内层循环体，而不是整个循环体。
     */
    for (i in 1..3){
        for (j in 11..13){
            if (j%2==0){
                continue
            }
            println("i=$i j=$j")
        }
    }

    /*
    如果希望直接跳过外层循环，则可以使用标签语法。标签定义在代码块前，标签名由标识符和符号“@”组成，相当于为该代码块起了一个名字
     */
    outer@
    for (i in 1..3){
        for (j in 11..13){
            if (j%2==0){
                continue@outer
            }
            println("outer i=$i j=$j")
        }
    }


    //2.break语句
    /*
    立即停止循环
     */
    for (i in 1..5){
        if (i==3){
            break
        }

        println("break $i")
    }

    outer1@
    for (i in 1..3){
        for (j in 11..13){
            if (j%2==0){
                break@outer1
            }
            println("i=$i j=$j")
        }
    }

    
}