package practice.oop.session20;

import practice.oop.session20.static_ex.Employee;

public class TestAccessModifiers {

    public static void main(String[] args) {
        /*StaticAccessModifiers staticAccessModifiers1 = new StaticAccessModifiers();
        System.out.println(staticAccessModifiers1.name);
        StaticAccessModifiers.name = "new endava";
        System.out.println(staticAccessModifiers1.name);

        StaticAccessModifiers staticAccessModifiers2 = new StaticAccessModifiers();
        System.out.println(staticAccessModifiers2.name);

        StaticAccessModifiers.printMessage();*/

        Employee e1 = new Employee();
        e1.noOfEmployees();
        Employee e2 = new Employee();
        e2.noOfEmployees();

    }
}
