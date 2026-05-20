import java.util.Arrays;

// Selection sort — find the minimum in a[start..end], swap it to a[start],
// then recurse on the rest.
// Time:  O(n^2) worst | O(n^2) average
// Space: O(n) recursion stack
class SelectionSort {

    // O(n^2) — linear scan for min at each level of recursion
    static void selectionSort(int[] a, int start) {
        if (start >= a.length - 1) {
            return;  // base case: one element left
        }
        int minIdx = start;
        for (int j = start + 1; j < a.length; j++) {
            if (a[j] < a[minIdx]) {
                minIdx = j;
            }
        }
        // swap minimum into position
        int t = a[start];
        a[start] = a[minIdx];
        a[minIdx] = t;

        selectionSort(a, start + 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};
        selectionSort(a, 0);
        System.out.println("Selection sort: " + Arrays.toString(a));
    }
}
