class RecursionBasicsExample {

    /** Classic example: n! = n * (n-1)!, with 0! = 1 */
    static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n <= 1) {
            return 1; // base case
        }
        return n * factorial(n - 1); // recursive step
    }

    /** Sum 1 + 2 + ... + n without a loop */
    static int sumUpTo(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumUpTo(n - 1);
    }

    /** Is s a palindrome? Compare ends and recurse on the middle */
    static boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length() - 1);
    }

    private static boolean isPalindromeHelper(String s, int left, int right) {
        if (left >= right) {
            return true; // base: 0 or 1 character in the middle
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindromeHelper(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        System.out.println("=== factorial ===");
        System.out.println("factorial(5) = " + factorial(5)); // 120

        System.out.println("\n=== sumUpTo ===");
        System.out.println("sumUpTo(10) = " + sumUpTo(10)); // 55

        System.out.println("\n=== isPalindrome ===");
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindrome("java")); // false
    }
}
