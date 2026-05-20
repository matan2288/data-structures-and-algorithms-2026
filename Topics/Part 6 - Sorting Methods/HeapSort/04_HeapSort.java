import java.util.Arrays;
import java.util.PriorityQueue;

// Heap sort — insert all elements into a min-heap, then poll them out in order.
// Time:  O(n log n) — n insertions + n extractions, each O(log n)
// Space: O(n) for the heap
class HeapSort {

    // O(n log n) — PriorityQueue is a min-heap under the hood
    static void heapSort(int[] a) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : a) {
            heap.add(x);         // O(log n) each
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = heap.poll();  // O(log n) each — smallest out first
        }
    }

    public static void main(String[] args) {
        int[] a = {4, 10, 3, 5, 1};
        heapSort(a);
        System.out.println("Heap sort: " + Arrays.toString(a));
    }
}
