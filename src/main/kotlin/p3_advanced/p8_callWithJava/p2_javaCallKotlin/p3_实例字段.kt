package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
实例字段
如果需要在Java中访问隐藏在Kotlin属性背后的幕后字段，则需要用@JvmField注解对该属性进行标记。导出的字段和属性具有相同的可见性。
在导出字段时需要遵守以下几个限制条件:
●该属性必须拥有幕后字段。
●该属性不能是私有属性。
●该属性不能是被open、 override或const修饰的属性。
●该属性不能是委托属性。

如果一个属性是延迟初始化属性，则其会自动导出为字段，且该字段的可见性与属性一致。
*/
//【举例】在Kotlin代码中，用@JvmField 注解标记username属性，具体代码如下:
class KotlinBean3(name: String) {
    @JvmField
    val username = name
}
/*
在Java代码中，访问该属性导出的字段，具体代码如下:
KotlinBean kotlinBean = new KotlinBean("Peter");
KotlinBean.username = "Jane"
 */