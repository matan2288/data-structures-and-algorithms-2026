import java.util.Arrays;

// Merge sort — divide array, sort halves, merge results.
// Time:  O(n log n) worst | O(n log n) average
// Space: O(n) auxiliary array for merging
class MergeSort {

    // O(n log n) time, O(n) extra space for aux[]
    static void mergeSort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        int[] aux = new int[a.length];
        mergeSortRange(a, aux, 0, a.length - 1);
    }

    private static void mergeSortRange(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSortRange(a, aux, lo, mid);
        mergeSortRange(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi - lo + 1);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {7, 2, 5, 3, 7, 1, 4};
        mergeSort(a);
        System.out.println("Merge sort: " + Arrays.toString(a));
    }
}
