class BigONotationExample {

    /** O(1): work does not depend on n */
    static int constantWork(int n) {
        int steps = 0;
        steps++; // one assignment
        int x = n * n + 42; // still O(1) — fixed number of ops
        steps++;
        return x + steps;
    }

    /** O(n): one pass over n items */
    static int linearSteps(int n) {
        int steps = 0;
        for (int i = 0; i < n; i++) {
            steps++;
        }
        return steps;
    }

    /** O(n^2): nested loops over n */
    static int quadraticSteps(int n) {
        int steps = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                steps++;
            }
        }
        return steps;
    }

    /** O(log n): halve n each iteration (like binary search) */
    static int logarithmicSteps(int n) {
        int steps = 0;
        int i = n;
        while (i > 1) {
            steps++;
            i /= 2;
        }
        return steps;
    }

    /** O(n log n): n passes, each halving (like merge sort's merge level) */
    static int linearithmicSteps(int n) {
        int steps = 0;
        for (int i = 0; i < n; i++) {
            int j = n;
            while (j > 1) {
                steps++;
                j /= 2;
            }
        }
        return steps;
    }

    /** O(2^n): work proportional to 2^n (like enumerating all subsets) */
    static int exponentialSteps(int n) {
        int steps = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            count *= 2;
        }
        for (int i = 0; i < count; i++) {
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("n = " + n);
        System.out.println("constantWork(n)     steps ~ O(1):       " + constantWork(n));
        System.out.println("logarithmicSteps(n) steps ~ O(log n):   " + logarithmicSteps(n));
        System.out.println("linearSteps(n)      steps ~ O(n):       " + linearSteps(n));
        System.out.println("linearithmicSteps(n) steps ~ O(n log n): " + linearithmicSteps(n));
        System.out.println("quadraticSteps(n)   steps ~ O(n^2):     " + quadraticSteps(n));
        System.out.println("exponentialSteps(n) steps ~ O(2^n):     " + exponentialSteps(n));

        System.out.println("\nCompare n = 4 vs n = 40 (quadratic explodes):");
        System.out.println("quadraticSteps(4)  = " + quadraticSteps(4));
        System.out.println("quadraticSteps(40) = " + quadraticSteps(40));

        System.out.println("\nCompare n = 10 vs n = 20 (exponential explodes):");
        System.out.println("exponentialSteps(10) = " + exponentialSteps(10));
        System.out.println("exponentialSteps(20) = " + exponentialSteps(20));
    }
}
