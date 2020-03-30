package p2_intermediate.p2_classAndObject.p7_property

/*
在kotlin中不能直接访问字段（因为字段隐藏在属性背后），只能在访问器中访问字段，所以这种字段被称为“幕后字段（backing field）”。
在访问器中，可以通过读取或者修改隐式参数field的值访问隐藏在该属性背后字段的值
 */
//【举例】在访问器中，通过修饰幕后字段来修改属性的值。
class Computer2{
    var price=0
    set(value) {
        field= if (value<0) 0 else value
    }
}