import org.jetbrains.annotations.NotNull;

public class JavaBean1 {
    private String name;

    public JavaBean1(String name) {
        this.name = name;
    }

    public boolean is(String name) {
        return this.name.equals(name);
    }

    public void hello() {
        System.out.println("hello");
    }

}