package practice;

public class Exception1 {

    public static void main(String[] args) throws CustomException {

/*
        try{
            System.out.println(12/0);
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic exception thrown " + e.getMessage());
        }
*/

        try {
            int[] numbers = new int[10];
            numbers[11] = 5;
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            //System.out.println(e.getMessage());
            throw new CustomException("My exception");
        }
        finally {
            System.out.println("always executed");
        }

    }
}
