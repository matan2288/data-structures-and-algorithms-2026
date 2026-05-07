public class Main {

    // Q5: Complete the method to compute the last (check) digit of a credit card
    // or ID number using Luhn's algorithm.
    // The number (excluding the last digit) is passed as a string n of digits '0'-'9'.
    // Returns a character in the range '0'-'9'.
    //
    // Algorithm (example with "3823"):
    //   1. Number digits from the right starting at 1.
    //   2. Double every odd-numbered digit.
    //   3. If the doubled value >= 10, subtract 9.
    //   4. Sum all resulting digits.
    //   5. The check digit is what makes the total a multiple of 10.
    //      e.g. sum=18 → check digit is 2 (since 18+2=20)
    public static char getCheckDigit(String n) {

    }

    public static void main(String[] args) {

    }
}
