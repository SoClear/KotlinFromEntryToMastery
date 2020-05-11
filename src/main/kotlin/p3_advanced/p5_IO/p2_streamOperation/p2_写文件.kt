package p3_advanced.p5_IO.p2_streamOperation

import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

/*
写数据到文件中 ，一般可以用字节输出流OutputStream的子类FileOutputStream（文件字节输出流）来实现。
 */
//【举例】向文本文件写入字符串

/*
fun main() {
    val source="./test.txt"
    var out:OutputStream?=null
    try {
        //创建文件字节输入流
        out=FileOutputStream(source)
        val byteArray="hello world".toByteArray()
        //输出字节数组
        out.write(byteArray)
    }catch (e:IOException){
        e.printStackTrace()
    }finally {
        out?.close()
    }
}
*/

/*
在写文件后，为了释放资源需要主动调用close()方法。
为了确保异常发生后该操作也能被正常执行，通常都需要将close()方法放在finally代码块中。
在kotlin中，为了简化这个过程，通过调用扩展自File类的outputStream()方法获得输出流，通过调用use()方法完成资源文件的自动释放。
 */
//【举例】用kotlin通过的扩展方法向文本文件写入字符串，其功能与上面的例子完全一致
/*
fun main() {
    var source=File("./test.txt")
    source.outputStream().use {
        //在use代码块中，可以通过it获得输出流对象
        val byteArray="hello world".toByteArray()
        it.write(byteArray)
    }
}
*/

/*
在这个例子中，use代码块中的的语句全部执行完毕后资源就会被自动释放，这个功能相当于java7中的try...resources语句。
在kotlin中，这个过程被再次简化，扩展自File类的WriteBytes()方法和appendByte()方法可以直接向文件中写入和追加字节数据。
 */
//【举例】用最简单的语法向文本文件中写入字符串。其功能与上面两个例子完全一致，但是代码量减少很多。
fun main() {
    var source=File("./test.txt")
    source.writeBytes("hello world".toByteArray())
}