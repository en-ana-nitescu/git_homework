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
}
