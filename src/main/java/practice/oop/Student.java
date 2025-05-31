package practice.oop;

public class Student extends Person {
    private String university;
    private int year;
    private boolean hasScholarship;

    public Student(String name, String surname, int age, String university, int year, boolean hasScholarship) {
        super(name, surname, age);
        this.university = university;
        this.year = year;
        this.hasScholarship = hasScholarship;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean getScholarship() {
        return hasScholarship;
    }

    public void setScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    public void studentInfo() {
        personInfo();
        System.out.println("University: " + university);
        System.out.println("Year: " + year);
        System.out.println("Has scholarship: " + hasScholarship);
    }

    public void eat() {
        System.out.println("Student is eating when he wants");
        super.eat();
    }


}
