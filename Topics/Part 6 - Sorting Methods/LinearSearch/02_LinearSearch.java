// Linear search — scan until found or end of array.
// Time:  O(n) worst | O(n) average | O(1) best (target at index 0)
// Space: O(1)
class LinearSearch {

    // O(n) — one pass through the array
    static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 1, 4, 1, 5};
        int index = linearSearch(a, 4);
        System.out.println("Linear search for 4 at index: " + index);
    }
}
