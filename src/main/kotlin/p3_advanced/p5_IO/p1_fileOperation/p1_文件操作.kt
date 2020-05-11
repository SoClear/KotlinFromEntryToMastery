package p3_advanced.p5_IO.p1_fileOperation

/*
Kotlin并没有为文件操作提供语法糖，所以，在使用时只需直接调用Java中的相关类库即可。
在Java中，File 类既表示文件，也表示目录。
操作File类的对象，就是操作实际磁盘上的文件和目录。

1 创建一个文件
创建文件需要使用creatNewFile()方法。
在执行该方法前，可以先通过exists()方法判断该文件是否已经存在:若返回true则表示文件存在;若返回false则表示文件不存在。
如果需要创建的文件所在的目录不存在，则该创建操作会失败。
[举例]在文件不存在时创建文件。具体代码如下:
var source=File (filepath)
//检测文件是否存在
if (!source.exists () ){
    source . createNewFile ()
}
一般来说，在通过流写文件时，如果指定的文件不存在，则Java类库会自动创建该文件。
但如果该文件没有后缀名，或文件名是以点(.)开头的，则Java类库不会自动创建该文件。
所以，为避免这种情况引起bug,建议在通过流写文件时也先手动调用创建操作。

2.删除一个文件
删除文件需要使用delete()方法。如果返回true，表示删除成功；如果返回false，表示删除失败。
【举例】如果文件存在，则进行删除操作，具体代码如下：
var source =File(path)
//检测文件是否存在

if(source.exists()){
    source.delete()
}

3.创建一个目录
创建目录需要使用mkdir()方法或者mkdirs()，前者只能创建一级目录（包含一个目录分隔符），后者可以同时创建多级目录（包含多个目录分隔符）
【举例】创建一个目录
var source=File(dirPath)
dir.mkdirs()

4.删除一个目录
java中并没有直接删除目录的功能，所以，在删除目录前需要先删除目录中的所有文件，然后执行删除目录操作。
而kotlin通过扩展函数为File类提供了deleteRecursively()方法，可以用它来直接删除目录和该目录下的所有文件

【举例】递归删除一个指定目录
var source=File(dirPath)
source.deleteRecursively()
*/