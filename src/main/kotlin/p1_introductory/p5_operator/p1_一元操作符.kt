package p1_introductory.p5_operator

fun main() {
    //1.自增自减操作符
    var a=10
    var b=++a
    println("a=$a,b=$b")

    a=10
    b=a++
    println("a=$a,b=$b")

    //2.否定操作符
    /*
    否定操作符属于逻辑操作符，对布尔类型的操作数进行取反操作
     */
    var exist=true
    println(!exist)

}