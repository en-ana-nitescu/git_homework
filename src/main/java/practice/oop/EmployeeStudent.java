package practice.oop;

public class EmployeeStudent extends Person implements EmployeeInt, StudentInt{

    private String company;
    private int experience;
    private int vacationDays;
    private String university;
    private int year;
    private boolean hasScholarship;

    public EmployeeStudent(String name, String surname, int age, String company, int experience, int vacationDays, String university, int year, boolean hasScholarship) {
        super(name, surname, age);
        this.company = company;
        this.experience = experience;
        this.vacationDays = vacationDays;
        this.university = university;
        this.year = year;
        this.hasScholarship = hasScholarship;
    }

    @Override
    public void shouldWork() {

    }

    @Override
    public void shouldHaveABreak() {

    }

    @Override
    public void shouldReceiveASalary() {

    }

    @Override
    public void canResign() {

    }

    @Override
    public void attendCourses() {

    }

    @Override
    public void takeExams() {

    }
}
