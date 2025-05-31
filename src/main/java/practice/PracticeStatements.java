package practice;

import org.testng.annotations.Test;

import java.util.Scanner;

public class PracticeStatements {


    @Test
    public void testMethod() {
       /* checkNumber(7);
        checkNumber(3);
        checkNumber(5);

        dayOfTheWeek(2);
        dayOfTheWeek(8);

        checkEvenPositiveNumber(6);
        checkEvenPositiveNumber(7);
        checkEvenPositiveNumber(-6);
        checkEvenPositiveNumber(-7);
        checkEvenPositiveNumber(0);
*/
        readNumber();
    }

    public void checkNumber(int value) {
        if (value > 5) {
            System.out.println("number " + value + " is greater than 5");
        } else if (value < 5) {
            System.out.println("number " + value + " is less than 5");
        } else {
            System.out.println("Number is 5");
        }
    }

    public void checkEvenPositiveNumber(int value) {
        if (value > 0) {
            if (value % 2 == 0) {
                System.out.println("Number " + value + " is even and positive");
            } else {
                System.out.println("Number " + value + " is odd and positive");
            }
        } else if (value < 0) {
            if (value % 2 == 0) {
                System.out.println("Number " + value + " is even and negative");
            } else {
                System.out.println("Number " + value + " is odd and negative");
            }
        } else {
            System.out.println("Number is 0");
        }

    }

    public void dayOfTheWeek(int day) {
        switch (day) {
            case 1:
                System.out.println("Today is Monday");
                break;
            case 2:
                System.out.println("Today is Tuesday");
                break;
            case 3:
                System.out.println("Today is Wednesday");
                break;
            case 4:
                System.out.println("Today is Thursday");
                break;
            case 5:
                System.out.println("Today is Friday");
                break;
            case 6:
                System.out.println("Today is Saturday");
                break;
            case 7:
                System.out.println("Today is Sunday");
                break;
            default:
                System.out.println("Incorrect day");
        }
    }

    public void readNumber() {
        System.out.println("Enter number");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        while (number < 0 || number > 10) {
            System.out.println("Incorrect, number must be between 0 and 10");
            number = scanner.nextInt();
        }
        System.out.println("Number is " + number);
    }

    public void printValue() {
        int value = 1;
        while (value <= 5) {
            System.out.println("Value is " + value);
            value++;
        }
    }

    public void printValueDoWhile() {
        int value = 6;
        do {
            System.out.println("Value is " + value);
            value++;
        }
        while (value <= 5);
    }


}
