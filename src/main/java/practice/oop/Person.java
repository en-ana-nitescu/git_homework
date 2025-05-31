package practice.oop;

public class Person {

    //encapsulation - getter/setter

    /*polymorphism - multiple implementations for the same method
    dynamic (override) - inheritance (overriding method implementation in child class)
    static (overload) - same method name, different implementations based on the number of parameters or type
     */


    private String name;
    private String surname;
    private int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void personInfo() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + age);
    }

    public void eat() {
        System.out.println("Person is eating");
    }
}
