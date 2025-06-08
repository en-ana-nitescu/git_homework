package practice.oop.session20.static_ex;

public class InitializeBlockTest {

    private String name = "Ana";

    {
        System.out.println("setting field");
        name = "test";
    }

    public InitializeBlockTest() {
        name = "Maria";
        System.out.println("setting constructor");
    }

    public static void main(String[] args) {
        InitializeBlockTest test = new InitializeBlockTest();
        System.out.println(test.name);

    }
}
