package p2_intermediate.p2_classAndObject.p7_property

/*
在Java中，在类中定义的所有没有被初始化的字段都会在对象创建时被赋予默认值。
而在Kotlin中，在类中定义的所有属性都必须显式地被初始化。
这个规定虽然可以提醒开发者及时注意属性是否被正确初始化，
但是在很多场景下，却会造成开发者必须编写不少额外代码，
比如在强制类型转换或者做非空判断时。
尤其对于Android应用程序开发者来说，所有组件在构造方法执行时都为空，
只有onCreate()方法被执行后组件才能被初始化，比如下面这段代码:
class MainActivity : Activity() {
    //由于必须在onCreate()后初始化，所以只能声明为可空类型
    var btnOk: Button? = null
    var btnCancel: Button? = null
    var txtTitle: TextView? = null

    override fun onCreate (savedInstanceState: Bundle?){
        super.onCreate (savedInstanceState)
        setContentView (R.layout.activity_main)
        //初始化属性
        btnOK=findViewById(R.id.ok)
        btnCancel=findViewById(R.id.cancel)
        txtTitle=findViewById(R.id.title)

        //由于声明为可空属性，每次使用前还必须手动转换或者做非空判断。
        txtTitle!!.text="手动强制转换"
    }
}

对于这些能够保证在使用前会被初始化的属性来说，其必须声明为可空类型无疑会造成使用上的不便。
针对这种情况，kotlin提供了延迟初始化属性的功能，允许类中的非空属性在构造方法之外进行初始化工作。

如要使用延迟初始化功能，则需要在属性的声明语句前加上“lateinit” 关键字。
除此之外，在使用延迟初始化属性时还有以下几个限制条件:
●延迟初始化属性必须定义在类中，不能定义在主构造方法中。
●延迟初始化属性必须使用默认的访问器，不支持自定义访问器。
●延迟初始化属性必须声明为var (即可写属性)。
●延迟初始化属性必须是非空类型。
●延迟初始化属性必须是非基本数据类型。

如果在属性被初始化之前进行访问，则程序会抛出“kotlin.UninitializedProperty AccessException”异常。
 */