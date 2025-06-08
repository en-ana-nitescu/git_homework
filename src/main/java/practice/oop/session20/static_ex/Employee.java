package practice.oop.session20.static_ex;

public class Employee {

    static int staticNumber = 0;
    int nonStaticNumber = 0;

    public void noOfEmployees() {
        staticNumber++;
        nonStaticNumber++;
        System.out.println("static no of employees: " + staticNumber);
        System.out.println("non static no of employees: " + nonStaticNumber);
    }
}
