package practice;

import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

public class TemaSession3 {

    //1. Scrieti o functie in care sa folositi break, skip (folosind continue), si return.
    @Test
    public void printNumbers() {
        for (int i = 0; i <= 10; i++) {
            if (i == 5) {
                System.out.println("Skipping number: " + i);
                continue;
            }
            if (i == 8) {
                System.out.println("Breaking at number: " + i);
                break;
            }
            System.out.println("Current number: " + i);
        }

    }


   /*
   2. Creati cate un array si un array list pentru 3 tipuri de date diferite (ex: int, String, double).
   3. Parcurgeti fiecare array si array list folosind:
        un for-each loop,
        un for clasic.
     */

    @Test
    public void printArrays() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] workdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        double[] doubles = {3.5, 1.2, 4.7, 2.1, 5.0};

        System.out.println("Print array of int classic: ");
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        System.out.println("Print array of int for each: ");
        for (int i : ints) {
            System.out.println(i);
        }

        System.out.println("Print array of strings classic: ");
        for (int i = 0; i < workdays.length; i++) {
            System.out.println(workdays[i]);
        }

        System.out.println("Print array of strings for each: ");
        for (String d : workdays) {
            System.out.println(d);
        }

        System.out.println("Print array of double classic: ");
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }

        System.out.println("Print array of double for each: ");
        for (double d : doubles) {
            System.out.println(d);
        }

    }

    @Test
    public void printArrayList() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);

        List<String> workdays = new ArrayList<>();
        workdays.add("Monday");
        workdays.add("Tuesday");
        workdays.add("Wednesday");
        workdays.add("Thursday");
        workdays.add("Friday");

        List<Double> doubles = new ArrayList<>();
        doubles.add(3.5);
        doubles.add(1.2);
        doubles.add(4.7);
        doubles.add(2.1);
        doubles.add(5.0);

        System.out.println("Print array list of integer classic: ");
        for (int i = 0; i < ints.size(); i++) {
            System.out.println(ints.get(i));
        }

        System.out.println("Print array list of int for each: ");
        for (int i : ints) {
            System.out.println(i);
        }

        System.out.println("Print array list of integers: " + ints);

        System.out.println("Print array list of strings classic: ");
        for (int i = 0; i < workdays.size(); i++) {
            System.out.println(workdays.get(i));
        }

        System.out.println("Print array list of strings for each: ");
        for (String d : workdays) {
            System.out.println(d);
        }

        System.out.println("Print array list of double classic: ");
        for (int i = 0; i < doubles.size(); i++) {
            System.out.println(doubles.get(i));
        }

        System.out.println("Print array list of double for each: ");
        for (double d : doubles) {
            System.out.println(d);
        }

    }

}
