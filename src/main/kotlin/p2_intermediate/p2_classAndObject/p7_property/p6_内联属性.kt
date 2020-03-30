package p2_intermediate.p2_classAndObject.p7_property

/*
从1.1版本开始，Kotlin 支持了内联属性。
内联属性要求:数据只有访问器没有幕后字段。
在使用内联属性时，需要用“inline”关键字修饰属性或访问器。
如果修饰在属性上，则表示对Setter访问器和Getter访问器都有效。
内联属性在编译后，属性对应的访问器代码会被复制到调用处，相当于节省了一次方法调用过程。
*/
//[举例]创建一个包含内联属性的类Student,该类中的username属性为内联属性。具体代码如下:
class Student {
    var loginName = ""

    inline var username: String
        get() = loginName
        set(value) {
            this.loginName = value
        }
}