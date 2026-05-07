public class Main {

    // Q9b: Complete the method to raise x to integer power pow in O(log n) time.
    // Remember: x^0 = 1, x^(-pow) = 1 / x^pow
    // Hint: x^(2n) = (x^n)^2, x^(n+1) = x^n * x
    // This solution must be RECURSIVE.
    public static double power(double x, int pow) {
        if (pow == 0) {
            return 1;
        }
        if (pow < 0) {
            return 1.0 / power(x, -pow);
        }
        if (pow % 2 == 0) {
            double half = power(x, pow / 2);
            return half * half;
        }
        return x * power(x, pow - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(2, 10));
    }
}
