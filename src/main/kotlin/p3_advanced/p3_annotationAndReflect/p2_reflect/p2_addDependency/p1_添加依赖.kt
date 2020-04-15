package p3_advanced.p3_annotationAndReflect.p2_reflect.p2_addDependency

/*
添加依赖
为了尽可能减少基础类库的大小，Kotlin将大部分反射API都封装在kotlin-reflect 库中，
而不是基础的kotlin-stdlib库中。
所以，在使用反射前需要先确保项目引用了该库。

基于Maven构建的工程需要修改pom.xml文件，添加以下依赖:
<dependency>
    <groupId>org.jetbrains. kotlin</groupId>
    <artifactId>kotlin-reflect</artifactId>
    <version>$ {kotlin.version}</version>
</dependency>


基于Gradle构建的工程需要修改build.grade文件，添加以下依赖:
compile "4org. jetbrains.kotlin;kotlin-reflect:${kotlin. version}"

*/
