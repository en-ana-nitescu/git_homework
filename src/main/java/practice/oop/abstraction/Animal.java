package practice.oop.abstraction;

public interface Animal {

    /*
    Interface:
    - it is used to achieve abstraction and multiple inheritance in Java
    - defines a set of behaviors that a class can implement, usually representing an IS-A relationship
    - primarily define methods that other classes must implement
    - variables in an interface are public, static, and final
     */

    public static final String type = "mammal";

    void makeSound();

    void eat();
}
