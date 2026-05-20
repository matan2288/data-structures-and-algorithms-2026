import java.util.Arrays;

// Insertion Sort — sort the first n-1 elements recursively,
// then insert the nth element into its correct place.
// Time:  O(n^2) worst | O(n) best (already sorted)
// Space: O(n) recursion stack
class InsertionSort {

    // O(n^2) worst — each insert may shift up to n elements
    static void insertionSort(int[] a, int n) {
        if (n <= 1) {
            return;  // base case: single element is sorted
        }
        insertionSort(a, n - 1);  // sort first n-1

        // insert a[n-1] into the sorted prefix
        int key = a[n - 1];
        int j = n - 2;
        while (j >= 0 && a[j] > key) {
            a[j + 1] = a[j];
            j--;
        }
        a[j + 1] = key;
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};
        insertionSort(a, a.length);
        System.out.println("Insertion Sort: " + Arrays.toString(a));
    }
}
