package p3_advanced.p7_asynchronousProgramming.p4_coroutineUsage.p1_configureDependency

/*
Kotlin从1.3版本开始正式引入协程库。协程库位于Kotlin的控制类库kotlinx-coroutines-core中，所以在使用前需要先修改工程的配置文件。
基于Maven构建的项目需要修改pom.xml，添加以下依赖：
<dependency>
    <groupId>org.jetbrains.kotlinx<groupId>
    <artifactId>kotlinx-coroutines-core<artifactId>
    <version>1.3.7>
</dependency>

基于Gradle构建的项目需要修改build.gradle文件，添加以下依赖：
dependencies{
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.7"
}
 */