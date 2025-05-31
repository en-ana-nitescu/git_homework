package practice.design_patterns;

public class SingleObject {

    private static SingleObject instance;
    private String info = "Initial info class";

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        if (instance == null) {
            instance = new SingleObject();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println(info);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
