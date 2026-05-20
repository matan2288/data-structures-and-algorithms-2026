/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: Min-Heap — Almost Complete Binary Tree stored as an Array
 * ─────────────────────────────────────────────────────────────────────────────
 * An almost complete binary tree is filled level by level from left to right.
 * Because its shape is fully predictable, we can store it in a flat ARRAY
 * with no pointers — saving memory and improving cache performance.
 *
 * ── Array index formulas (1-indexed) ─────────────────────────────────────────
 *   Node at index i:
 *     Parent      → i / 2
 *     Left child  → 2 * i
 *     Right child → 2 * i + 1
 *
 * ── Min-Heap property ─────────────────────────────────────────────────────────
 *   Every parent is SMALLER THAN OR EQUAL TO both its children.
 *   The minimum value is always at the root (index 1).
 *
 * ── Core operations ──────────────────────────────────────────────────────────
 *   insert(value)
 *     1. Place the new value at the next free slot (end of array).
 *     2. BubbleUp: swap with parent while the value is smaller than its parent.
 *        This restores the heap property in O(log n) steps.
 *
 *   extractMin()
 *     1. Save the root (minimum).
 *     2. Move the last element to the root, shrink size by 1.
 *     3. BubbleDown: swap with the smaller child while larger than a child.
 *        This restores the heap property in O(log n) steps.
 *
 * Time complexity:
 *   insert      → O(log n)
 *   extractMin  → O(log n)
 *   peek min    → O(1)   (just read heap[1])
 * Space complexity: O(n) for the array
 * ─────────────────────────────────────────────────────────────────────────────
 */
class HeapExample {

    // 1-indexed array: heap[1] is the root, heap[0] is unused.
    static int[] heap = new int[100];
    static int size = 0;

    // ── Insert ────────────────────────────────────────────────────────────────
    static void insert(int value) {
        heap[++size] = value;  // append at the next free position
        bubbleUp(size);        // restore heap property upward
    }

    // ── BubbleUp ──────────────────────────────────────────────────────────────
    // Swap the node at index i with its parent (i/2) while it is smaller.
    // Stops when it reaches the root (i == 1) or the parent is already smaller.
    static void bubbleUp(int i) {
        while (i > 1 && heap[i] < heap[i / 2]) {
            swap(i, i / 2);
            i /= 2;  // move up to the parent's index
        }
    }

    // ── ExtractMin ────────────────────────────────────────────────────────────
    static int extractMin() {
        int min = heap[1];        // root always holds the minimum
        heap[1] = heap[size--];   // overwrite root with last element, shrink size
        bubbleDown(1);            // restore heap property downward
        return min;
    }

    // ── BubbleDown ────────────────────────────────────────────────────────────
    // Compare the node at index i with its two children.
    // Swap with the SMALLER child if it is smaller than the current node.
    // Repeat until the node is smaller than both children or is a leaf.
    static void bubbleDown(int i) {
        int smallest = i;
        int left     = 2 * i;      // left  child index
        int right    = 2 * i + 1;  // right child index

        if (left  <= size && heap[left]  < heap[smallest]) smallest = left;
        if (right <= size && heap[right] < heap[smallest]) smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            bubbleDown(smallest);  // continue bubbling down the displaced element
        }
    }

    static void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    static void printArray() {
        System.out.print("Heap array [1.." + size + "]: ");
        for (int i = 1; i <= size; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        // Insert 6 values — each insert maintains the min-heap property
        for (int v : new int[]{5, 3, 8, 1, 9, 6}) insert(v);

        // After all inserts the array represents the heap tree level by level:
        //         1          ← root (minimum)
        //        / \
        //       3   6
        //      / \ /
        //     5  9 8
        printArray();  // 1 3 6 5 9 8  (or similar valid heap arrangement)

        // extractMin repeatedly removes the smallest element each time → sorted output
        System.out.print("Extract min in order: ");
        while (size > 0) System.out.print(extractMin() + " ");  // 1 3 5 6 8 9
        System.out.println();
    }
}
