package p2_intermediate.p2_classAndObject.p8_method

/*
“this”关键字可以用在构造方法、属性和方法上，其作用是引用类中的成员。
当“this”关键字在方法中引用属性时，如果方法的参数和属性重名，则必须明确使用“this”关键字，
在其他场合下可以省略“this” 关键字。
(1)指向其他构造方法的语法如下:
this ()
(2)指向其他方法的语法如下：
this.foo()
(3)指向其他属性的语法如下：
this.bar
*/
//【举例】当属性名和参数名相同时，显示调用属性。
class Button7 constructor(var text:String,val width:Int,height:Int){
    //属性和参数同名
    val height:Int
    init {
        this.height= if (height<0) 0 else height
    }
}