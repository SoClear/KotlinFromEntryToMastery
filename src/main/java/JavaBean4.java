public class JavaBean4 extends Object {
    //静态变量
    public static String path="/foo/bar";

    //静态常量
    public static final String baseUrl="http://localhost";

    //静态方法
    public static String getUrl(){
        return baseUrl+path;
    }
}
