package p2_intermediate.p7_genericParadigm.p4_genericVariances

/*
在声明处协变

如果C类是P类的子类，那么C类的类型参数可以看作是P类的类型参数的子类型，
这种特性被称为“协变”（Covariant) 。
协变保留了子类型的关系，将协变应用在类上被称为“在声明处协变”。

在使用协变功能时，需要在类型参数前面加上“out”关键字。
*/
//[举例]创建并使用在声明处协变的CovariantHolder类。
//(1)创建一个使用了在声明处协变的CovariantHolder类，该类包含协变类型参数工， 具体 代码如下:
class CovariantHolder<out T>(val obj: T)
//(2)使用该类创建几个对象，具体代码如下:
var strCovariant = CovariantHolder<String> ("hello")
//基于协变定义
var anyCovariant: CovariantHolder<Any> =strCovariant
val any: Any = anyCovariant.obj
/*
在这个例子中，首先创建了两个CovariantHolder类的对象，
其中一个类型参数为String,另一个类型参数为Any。
按照协变的定义，由于String类型是Any类型的子类型，类型参数String可以看作是类型参数Any的子类型，
所以这里可以直接将变量strCovariant 赋值给变量anyCovariant。
在完成赋值操作后，变量anyCovariant中保存的是字符串"Hello" 。

(3)从变量anyCovariant中取出刚刚保存的数据，由于该变量的类型参数为Any类型，所以取出的值已经转换成了Any类型。
那么此时是否可以修改变量anyCovariant的值呢?
这里假设将CovariantHolder类的构造方法中的val修改为var(实际上该操作并不合法)。
此时由于变量anyCovariant的泛型参数为Any类型，所以可以将一个 Date类型对象保存到该变量中， 具体代码如下:
anyCovariant.obj = Date
//这里出现了问题: Date 对象并不是String类型
val str: String = strCovariant. obj
由于变量strCovariant 的值已经赋给了变量anyCovariant, 所以这两个变量在底层都引用自同个对象。
那么理论上通过anyCovariant变量存放的值也能由strCovariant变量来取出。

但是由于anyCovariant变量存储的数据为Date类型，而strCovariant 变量的类型参数是与Date类型不兼容的String类型，
如果允许该操作则会出现“类型参数为String 类型，但取出的数据为Date类型”这样自相矛盾的结果。

所以，如果类型参数是协变的，则该类型参数只能用于输出类型。
即:协变类型只能作为方法的返回值类型和只读属性类型( 因为可写属性包含Setter访问器，所以类型不安全)。
*/

