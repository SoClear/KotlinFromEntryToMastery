package p3_advanced.p1_extensionAndDelegation.p2_delegation.p5_delegateFactory

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
从1.1版本开始，Kotlin开始支持使用委托工厂类。
委托工厂类主要基于provideDelegate()方法，该方法需要返回一个继承于ReadWriteProperty类的子类，该子类就是实际的委托类。
*/
//[举例]创建类Logger、委托工厂类LoggerDelegateFactory 和实际委托类LoggerDelegate, 具体代码如下:
class Logger {
    // target属性使用了属性委托
    var target: String by LoggerDelegateFactory()
}

//委托工厂类
class LoggerDelegateFactory {
    //返回实际的委托类
    operator fun provideDelegate(thisRef: Logger, prop: KProperty<*>):
            ReadWriteProperty<Logger, String> {
        return LoggerDelegate()
    }
}

//委托类
class LoggerDelegate : ReadWriteProperty<Logger, String> {

    private var value = "file"
    override fun getValue(thisRef: Logger, property: KProperty<*>): String {
        return value
    }

    override fun setValue(thisRef: Logger, property: KProperty<*>, value: String) {
        this.value = value
    }
}
//然后测试这段代码，具体代码如下:
fun main() {
    val logger = Logger()
    //输出: file
    println(logger.target)
    logger.target = "db"
    //输出: db
    println(logger.target)
}