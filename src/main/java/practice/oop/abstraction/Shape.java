package practice.oop.abstraction;

public abstract class Shape {

       /* Abstraction
    OOP concept that focuses on hiding the complex implementation details and showing only the essential features of an object
    abstract classes or interfaces

    abstract class:
    - cannot be instantiated
    - can be extended
    - can have both abstract and non-abstract methods (methods with bodies)
    - we can have an abstract class without any abstract method
    - if a class contains at least one abstract method, then it should be declared abstract
     */

    public String color;

    public abstract void calculateArea();

    public void draw() {
        System.out.println("Drawing a shape");
    }
}
