public class JavaBean3 {
    private String name;
    private boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    //非字段的Getter/Setter方法
    public String getA(){
        return "A";
    }

    public void setA(String a){
        //什么都不做
    }
}
