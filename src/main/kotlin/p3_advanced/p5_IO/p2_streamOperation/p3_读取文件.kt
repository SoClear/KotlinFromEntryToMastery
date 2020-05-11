package p3_advanced.p5_IO.p2_streamOperation

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.lang.StringBuilder

/*
从文件中读取数据，一般通过字节输入流InputStream的子类FileInputStream（文件字节输入流）来实现。
 */
//【举例】从文本文件中读取字符串
/*
fun main() {
    //创建文件字节输入流
    var input:InputStream?=FileInputStream("./test.txt")
    val sb=StringBuilder()
    try {

        input=FileInputStream("./test.txt")
        //创建字节缓冲
        val byteArray=ByteArray(1024)
        while (true){
            val size=input.read(byteArray)
            if (size==-1){
                break
            }
            //将字节缓冲转换为字符串
            sb.append(String(byteArray,0,size))
        }
    }catch (e:IOException){
        e.printStackTrace()
    }finally {
        input?.close()
    }

    println(sb)

}
*/

/*
和写文件一样，在读取文件后也需要调用finally代码块中的close()方法释放资源。
另外，Kotlin也提供了扩展自File类的inputStream()方法来获得输入流，
use()方法用来完成资源文件的自动释放。
 */
//【举例】从文本文件中读取字符串
/*
fun main() {
    var sb=StringBuilder()
    var source=File("./test.txt")
    val byteArray=ByteArray(1024)
    source.inputStream().use {
        val size=it.read(byteArray)
        sb.append(String(byteArray,0,size))
    }
    println(sb)
}

 */
/*
和写文件一样，可以直接调用扩展自File类的readBytes()方法获得字节数组，调用readText()方法获得字符串
 */
//【举例】用最简洁的语法从文件中读取字符串
fun main() {
    var source=File("./test.txt")
    val text=source.readText()
    println(text)
}