package practice.oop.session20.final_ex;

public class FinalAccessModifiers {

    /*
    final can be used for: outer/inner class, fields, methods
    final cannot be used for: interface, constructor, initialize blocks, enums
    final class cannot be extended
    final method cannot be overridden
    final variable must be initialized
    final variable cannot be modified
     */

    static final int a = 0;

    public static void main(String[] args) {
        System.out.println("a = " + a);
        //a = a +1 ; Cannot assign a value to final variable
    }
}
