import java.util.Arrays;

class SortingSimpleExample {

    static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // already sorted — best case O(n) passes
            }
        }
    }

    static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            int t = a[i];
            a[i] = a[minIdx];
            a[minIdx] = t;
        }
    }

    public static void main(String[] args) {
        int[] b1 = {5, 1, 4, 2, 8};
        bubbleSort(b1);
        System.out.println("bubbleSort:   " + Arrays.toString(b1));

        int[] b2 = {5, 1, 4, 2, 8};
        selectionSort(b2);
        System.out.println("selectionSort:" + Arrays.toString(b2));
    }
}
