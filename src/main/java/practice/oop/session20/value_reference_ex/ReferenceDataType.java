package practice.oop.session20.value_reference_ex;

public class ReferenceDataType {

    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println("strings 1 and 2: " + compareStrings(str1, str2));

        String str3 = str1;
        System.out.println("strings 1 and 3: " + compareStrings(str1, str3));

        String str4 = "hello";
        System.out.println("strings 1 and 4: " + compareStrings(str1, str4));
    }

    public static String compareStrings(String str1, String str2) {
        if (str1 == str2) {
            return "equals";
        }
        else
            return "not equals";
    }


}
