package practice.oop;

public class Employee extends Person {
    private String company;
    private int experience;
    private int vacationDays;

    public Employee(String name, String surname, int age, String company, int experience, int vacationDays) {
        super(name, surname, age);
        this.company = company;
        this.experience = experience;
        this.vacationDays = vacationDays;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    public void employeeInfo() {
        personInfo();
        System.out.println("Company: " + company);
        System.out.println("Experience: " + experience);
        System.out.println("Vacation days: " + vacationDays);
    }

    //dynamic polymorphism - overriding the method in parent class
    public void eat() {
        System.out.println("Employee is eating during launch break");
    }

    public void raise() {
        System.out.println("No budget");
    }

    public void raise(int percentage) {
        System.out.println("Employee receives a raise of " + percentage + "%");
    }

    public void raise(String grade){
        System.out.println("Employee receives the new grade: " + grade);
    }
}
