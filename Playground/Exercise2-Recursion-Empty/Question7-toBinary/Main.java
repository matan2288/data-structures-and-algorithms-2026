public class Main {

    // Q7: Complete the method to convert an integer to its binary string
    // representation.
    // Example: toBinary(13) → "1101"
    // 13 / 2 = 6 remainder 1
    // 6 / 2 = 3 remainder 0
    // 3 / 2 = 1 remainder 1
    // 1 / 2 = 0 remainder 1
    // Remainders read bottom-to-top → "1101"
    // Your solution must be recursive.

    
    public static String toBinary(int x) {
        String str = Integer.toString(x % 2);

        if (x / 2 != 0) {
            return toBinary(x / 2) + str;
        }

        return str;
    }
 // 1 0 1 1
 
    public static void main(String[] args) {

        String print = toBinary(13);
        System.out.println(print);
    }
}
