package p3_advanced.p2_advancedUseOfFunctions.p4_inlineFunction

/*
4 内联函数介绍
程序在执行普通函数时会先进行现场保护(记录当前函数的执行信息)，
然后跳转到函数定义处，执行完该函数后程序会返回到原米的调用处并恢可现场。
这个调用过程会产生一定的时间和空间损耗。

而编译器在编译内联函数时，
会将内联函数的整个函数体复制到调用处，
此时其实并不存在内联函教了，因此也就没有程序期转的消耗。
所以，使用内联函数在一定程度上可以提高程序的运行速度。
*/
