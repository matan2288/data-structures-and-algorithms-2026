/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: Collision Resolution — Chaining (Separate Chaining)
 * ─────────────────────────────────────────────────────────────────────────────
 * When two keys hash to the same index — a COLLISION — we need a strategy to
 * store both without losing data.
 *
 * Chaining solution:
 *   Each slot in the array does NOT hold a value directly.
 *   Instead, each slot holds the HEAD of a linked list.
 *   All keys that hash to the same index are stored in that chain.
 *
 *   Table structure:
 *     arr[0] → null
 *     arr[1] → [key=12, "Alice"] → [key=23, "Carol"] → null
 *     arr[2] → [key=35, "Bob"] → null
 *     ...
 *
 * ── Operations ───────────────────────────────────────────────────────────────
 *   put(key, value)  — hash to index, prepend to chain if new key    O(1) avg
 *   get(key)         — hash to index, walk chain to find key         O(1) avg
 *   remove(key)      — hash to index, bypass the matching node       O(1) avg
 *
 * Worst case: all n keys collide to the same slot → one chain of length n → O(n).
 * A good hash function and a load factor ≤ 1 keeps chains short.
 *
 * Load factor α = n / m  (n = stored keys, m = table size)
 *   Average chain length ≈ α, so keeping α small keeps operations fast.
 * ─────────────────────────────────────────────────────────────────────────────
 */
class ChainingExample {

    // Each node in a chain stores a key-value pair and a pointer to the next node.
    static class Entry {
        int    key;
        String value;
        Entry  next;

        Entry(int key, String value) {
            this.key   = key;
            this.value = value;
        }
    }

    static final int M = 7;        // table size (prime helps distribute evenly)
    static Entry[] table = new Entry[M];  // array of chain heads, all initially null

    // ── Hash function ─────────────────────────────────────────────────────────
    static int hash(int key) {
        return ((key % M) + M) % M;
    }

    // ── put ───────────────────────────────────────────────────────────────────
    // Walk the chain at arr[index]:
    //   if key exists → update its value
    //   if key is new → prepend a new Entry at the head (O(1), no need to walk to tail)
    static void put(int key, String value) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key == key) {
                current.value = value;  // key already exists — update
                return;
            }
            current = current.next;
        }

        // Prepend new entry at the head of the chain
        Entry newEntry = new Entry(key, value);
        newEntry.next  = table[index];
        table[index]   = newEntry;
    }

    // ── get ───────────────────────────────────────────────────────────────────
    // Hash to the correct index, then walk the chain comparing keys.
    static String get(int key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key == key) return current.value;
            current = current.next;
        }
        return null;  // key not found
    }

    // ── remove ────────────────────────────────────────────────────────────────
    // Walk with a 'prev' pointer so we can bypass the target node.
    static boolean remove(int key) {
        int index = hash(key);
        Entry current = table[index];
        Entry prev    = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null) table[index] = current.next;  // removing head of chain
                else              prev.next    = current.next;  // bypassing mid/tail node
                return true;
            }
            prev    = current;
            current = current.next;
        }
        return false;  // key not found
    }

    // ── printTable ────────────────────────────────────────────────────────────
    // Shows the full chain at every slot so collisions are visible.
    static void printTable() {
        System.out.println("Hash table (m=" + M + "):");
        for (int i = 0; i < M; i++) {
            System.out.printf("  [%d] ", i);
            Entry current = table[i];
            if (current == null) {
                System.out.print("—");
            }
            while (current != null) {
                System.out.printf("(%d→%s)", current.key, current.value);
                if (current.next != null) System.out.print(" → ");
                current = current.next;
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Chaining Demo ===\n");

        // 22 mod 7 = 1,  35 mod 7 = 0,  46 mod 7 = 4,  15 mod 7 = 1  ← collision with 22
        put(22, "Alice");
        put(35, "Bob");
        put(46, "Carol");
        put(15, "Dave");   // collides with Alice at index 1 → both stored in same chain
        put(8,  "Eve");    // 8 mod 7 = 1  → another collision at index 1
        printTable();

        System.out.println("get(22) = " + get(22));   // Alice  (walks chain at index 1)
        System.out.println("get(15) = " + get(15));   // Dave
        System.out.println("get(99) = " + get(99));   // null — not found
        System.out.println();

        remove(15);
        System.out.println("After remove(15):");
        printTable();
    }
}
