import java.util.Arrays;

// Bubble sort — one pass bubbles the largest unsorted element to the end,
// then recurse on the remaining n-1 elements.
// Time:  O(n^2) worst | O(n^2) average
// Space: O(n) recursion stack
class BubbleSort {

    // O(n^2) — n passes of decreasing length
    static void bubbleSort(int[] a, int n) {
        if (n <= 1) {
            return;  // base case: single element is sorted
        }
        for (int i = 0; i < n - 1; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
            }
        }
        // a[n-1] is now the largest — sort the rest
        bubbleSort(a, n - 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};
        bubbleSort(a, a.length);
        System.out.println("Bubble sort: " + Arrays.toString(a));
    }
}
