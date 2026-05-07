public class Main {

    // Q7: Complete the method to convert an integer to its binary string representation.
    // Example: toBinary(13) → "1101"
    //   13 / 2 = 6  remainder 1
    //    6 / 2 = 3  remainder 0
    //    3 / 2 = 1  remainder 1
    //    1 / 2 = 0  remainder 1
    // Remainders read bottom-to-top → "1101"
    // Your solution must be recursive.
    public static String toBinary(int x) {
        if (x <= 1) {
            return "" + x;
        }
        return toBinary(x / 2) + (x % 2);
    }

    public static void main(String[] args) {
        System.out.println(toBinary(13));
    }
}
