package p1_introductory.p7_arrayTypes
/*
包含一维数组的数组是二维数组
包含二位数组的数组是三维数组
以此类推
 */
fun main() {
    //定义两个一维数组
    val langs= arrayOf("java","kotlin")
    val platforms= arrayOf("android","ios")
    //定义二位数组
    val multi= arrayOf(langs,platforms)

    //打印K
    val dots= arrayOf(
        arrayOf(1,0,0,0,0,1),
        arrayOf(1,0,0,0,0,1),
        arrayOf(1,0,0,0,1,0),
        arrayOf(1,0,0,1,0,0),
        arrayOf(1,0,1,0,0,0),
        arrayOf(1,1,0,0,0,0),
        arrayOf(1,0,1,0,0,0),
        arrayOf(1,0,0,1,0,0),
        arrayOf(1,0,0,0,1,0),
        arrayOf(1,0,0,0,0,1),
        arrayOf(1,0,0,0,0,1)
    )

    for (row in dots){
        for (n in row){
            print(if (n==1) "*" else " ")
        }
        println()
    }
}