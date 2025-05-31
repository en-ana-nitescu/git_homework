package practice.design_patterns;


import org.testng.annotations.Test;

public class SingletonDemo {

    @Test
    public void test() {
        SingleObject myObject = SingleObject.getInstance();
        myObject.showMessage();

        SingleObject myObject2 = SingleObject.getInstance();
        myObject2.setInfo("new info");
        myObject.showMessage();
        myObject2.showMessage();
    }
}
