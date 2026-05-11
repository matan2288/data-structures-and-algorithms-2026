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

    public static void main(String[] args) {
        int n = 8;
        System.out.println("n = " + n);
        System.out.println("constantWork(n)   steps ~ O(1):  " + constantWork(n));
        System.out.println("linearSteps(n)    steps ~ O(n): " + linearSteps(n));
        System.out.println("quadraticSteps(n) steps ~ O(n^2): " + quadraticSteps(n));

        System.out.println("\nCompare n = 4 vs n = 40 (quadratic explodes):");
        System.out.println("quadraticSteps(4)  = " + quadraticSteps(4));
        System.out.println("quadraticSteps(40) = " + quadraticSteps(40));
    }
}
