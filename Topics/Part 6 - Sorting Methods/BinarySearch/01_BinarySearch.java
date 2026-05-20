// Binary search — requires a sorted array.
// Time:  O(log n) worst | O(1) best (target at middle)
// Space: O(1)
class BinarySearch {

    // O(log n) — halve the search range each iteration
    static int binarySearch(int[] sorted, int target) {
        int lo = 0;
        int hi = sorted.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sorted[mid] == target) {
                return mid;
            }
            if (sorted[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sorted = {1, 2, 3, 5, 8, 13};
        int index = binarySearch(sorted, 8);
        System.out.println("Binary search for 8 at index: " + index);
    }
}
