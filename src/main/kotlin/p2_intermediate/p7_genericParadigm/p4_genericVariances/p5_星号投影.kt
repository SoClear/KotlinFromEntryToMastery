package p2_intermediate.p7_genericParadigm.p4_genericVariances

/*
16.4.5星号投影
在使用处进行协变和逆变，可保障泛型函数的类型安全。
但是，无论是协变还是逆变，在使用时都需要指定一个确定的类型 (符号T也是一个确定的类型) ，
那如果完全不知道类型参数是何种类型，该如何保障类型安全呢?
Kotlin 对此的答案就足使用星号投影，
星号投影实际就是使用星号“*”作为类型参数。
*/
//[举例]在函数的类型参数上使用星号投影。具体代码如下:
//普通泛型类，隐式上界为“Any?”，即Holder<T:Any?>
class Holder1<T>(val obj:T)

//使用星号投影的函数
fun extract(holder1: Holder1<*>){
    var any:Any?=holder1.obj
}
/*
星号投影之所以可以保证泛型的类型安全是因为: 在使用星号投影时，会自动将类型限制为Any类型或Nothing 类型。
其对应的转换规则如下:

1.对于普通泛型类Holder<T:U>,Holder<*>在读取时相当于Holder<out U>,
  在写入时相当于Holder<in Nothing>,即不能进行写入操作。
2.对于声明式协变类Holder<out T>, Holder<*>等价于Holder<out Any?>,取值时返回的是“Any?”类型。
3.对于声明式逆变类 Holder<in T>, Holder<*>等价于 Holder<in Noting>,无法进行任何写入操作。
*/