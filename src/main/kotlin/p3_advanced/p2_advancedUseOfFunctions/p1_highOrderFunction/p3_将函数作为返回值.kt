package p3_advanced.p2_advancedUseOfFunctions.p1_highOrderFunction

import java.math.BigDecimal

/*
函数类型也可以作为一个函数的返回值类型，由此实现在调用一个函数后获得另一个函数的功能。
 */
//【举例】在handleOrder()函数中，通过不同业务类型返回不同的订单处理函数。
/**
 * 处理订单函数
 * @param bizType 业务类型，值为pay或者refund
 * @param orderPrice 订单价格
 *
 * @return payOrder()或者refundOrder()函数，该函数参数为BigDecimal类型，返回值为String类型
 */

fun handleOrder(bizType:String,orderPrice:BigDecimal):(BigDecimal) -> String{
    //支付订单函数
    fun payOrder(feeRate:BigDecimal):String{
        //手续费=订单价格 * 手续费率
        val fee=orderPrice.multiply(feeRate)
        return "支付了${orderPrice.plus(fee)},手续费$fee"
    }

    //退回订单
    fun refundOrder(feeRate:BigDecimal):String{
        //手续费 =订单价格 * 手续费率
        val fee=orderPrice.multiply(feeRate)
        return "退款手续费${fee}"
    }

    //根据业务类型返回指定函数
    return if("pay"==bizType) ::payOrder else ::refundOrder
}

fun main() {
    val payOrderFun= handleOrder("pay", BigDecimal(100))
    val refundOrderFun= handleOrder("refund", BigDecimal(100))
    println(payOrderFun(BigDecimal(0.01)))
    println(refundOrderFun(BigDecimal(0.02)))
}
//输出结果如下：
/*
支付了101.00000000000000002081668171172168513294309377670288085937500,手续费1.00000000000000002081668171172168513294309377670288085937500
退款手续费2.0000000000000000416333634234433702658861875534057617187500


在这个例子中，处理订单函数handleOrder()中包含支付订单函数payOrder()和退回订单函数refundOrder()。
· 如果该函数的业务类型bizType的值为“pay”，则返回payOrder()函数的引用，调用该函数会返回实际需要支付的金额和订单的手续费。
· 如果该函数的业务类型为其他值，则返回refundOrder的引用（在实际项目中如果碰到这种随意出入参数的情况应该抛出异常），
  调用该函数会返回退款所需要支付违约的手续费。
 */