package practice.oop;

import org.junit.jupiter.api.Test;

public class OopTest {

    @Test
    public void testMethod() {
        Student John = new Student("Doe", "John", 21, "Harvard", 3, true);
        John.studentInfo();

        Employee Jane = new Employee("Doe", "Jane", 31, "Endava", 10, 23);
        Jane.employeeInfo();
    }
}
