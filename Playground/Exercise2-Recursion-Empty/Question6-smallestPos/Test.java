import java.util.Scanner;

public class Test {

    // Q6: Read a sequence of positive integers until 0 or a negative number.
    // Set 'smallest' to the smallest value in the sequence.
    // Set 'pos' to the number of values between the LAST occurrence of smallest
    // and the end of the sequence.
    // Example: input = 12, 7, 5, 9, 5, 15, 18, 0
    //          smallest = 5, pos = 2 (two numbers after last 5 before 0)
    public static void main(String[] args) {
        int smallest = 0;
        int pos = 0;

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n > 0) {



            n = scan.nextInt();
        }

        System.out.println("The smallest value was " + smallest);
        System.out.println("The last occurrence was " + pos + " numbers before the end");
    }
}
