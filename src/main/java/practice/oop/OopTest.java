package practice.oop;

import org.testng.annotations.Test;
import practice.oop.abstraction.*;

public class OopTest {

    @Test
    public void testMethod() {
        Student John = new Student("Doe", "John", 21, "Harvard", 3, true);
        //John.studentInfo();
        //John.eat();

        Employee Jane = new Employee("Doe", "Jane", 31, "Endava", 10, 23);
        //Jane.employeeInfo();
        //Jane.eat();
        Jane.raise(10);
        Jane.raise("Engineer");
    }

    @Test
    public void abstractionClassTest() {
        Circle circle = new Circle();
        circle.setR(5);

        Square square = new Square();
        square.setSide(5);

        circle.calculateArea();
        square.calculateArea();
    }

    @Test
    public void abstractionInterfaceTest() {
        Dog dog = new Dog();
        dog.makeSound();
        System.out.println(Dog.type);

        Cat cat = new Cat();
        cat.makeSound();
    }
}
