public class Main {

    // Q9a: Complete the method to raise x to integer power pow in O(log n) time.
    // Remember: x^0 = 1, x^(-pow) = 1 / x^pow
    // Hint: x^(2n) = (x^n)^2, x^(n+1) = x^n * x
    // This solution must be NON-RECURSIVE (iterative).
    public static double power(double x, int pow) {
        if (pow < 0) {
            return 1.0 / power(x, -pow);
        }
        double result = 1;
        while (pow > 0) {
            if (pow % 2 == 1) {
                result *= x;
            }
            x *= x;
            pow /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
}
