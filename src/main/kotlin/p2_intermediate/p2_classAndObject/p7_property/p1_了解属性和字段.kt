package p2_intermediate.p2_classAndObject.p7_property

/*
学过java的都知道：在java Bean规范中，类的状态数据都保存在私有字段（Filed）中，
并对外暴露该字段的公有访问器方法（Getter/Setter）；
在程序中不能直接通过访问字段来读取或者修改字段的值，而应该通过访问器来进行操作。

这里的字段和访问器的组合也被称为属性（Property）。
在java中，一般不会严格区分字段和属性这两个概念。

在kotlin中，类只能定义属性，不能定义字段。
属性既可以定义在类中，也可以定义在主构造方法中。
属性在定义之后就必须进行初始化操作。
 */