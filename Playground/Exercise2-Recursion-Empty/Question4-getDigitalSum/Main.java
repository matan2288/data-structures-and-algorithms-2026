public class Main {

    // Q4: Complete the method to compute the digital sum of a number.
    // The digital sum is obtained by adding all digits together, then repeating
    // until the result is a single digit.
    // Example: getDigitalSum(1857) → 1+8+5+7 = 21 → 2+1 = 3
    // Your solution must be recursive.
    public static int getDigitalSum(int number) {

        if (number >= 10) {
            int dig = number % 10;
            int new_num = (number - dig) / 10;

            return getDigitalSum(dig + (new_num));
        }

        return number;
    }

    public static void main(String[] args) {
        int print = getDigitalSum(1857);

        System.out.println(print);
    }
}
