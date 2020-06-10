package p3_advanced.p8_callWithJava.p2_javaCallKotlin

/*
将Kotlin中的访问控制符映射到Java 中时，映射关系如下:
●private成员————被编译为Java的private成员。
●protected成员————被编译为Java的protected成员(Java的protected权限可以访问父类和同包的成员，
                而Kotlin不行，所以Java类有更大的访问权限)。
●internal成员————被编译为 Java的public成员。
●public成员————被编译为Java的public成员。
*/
