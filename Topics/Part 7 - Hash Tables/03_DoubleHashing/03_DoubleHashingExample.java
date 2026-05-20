/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: Collision Resolution — Double Hashing (Open Addressing)
 * ─────────────────────────────────────────────────────────────────────────────
 * Instead of linked lists (chaining), this approach stores everything directly
 * in the array. On a collision, we PROBE — search for the next available slot.
 *
 * Double Hashing uses TWO independent hash functions:
 *   h1(key) = key mod m             ← initial slot
 *   h2(key) = 1 + (key mod (m-1))  ← step size for probing
 *
 * Probe sequence for attempt i (i = 0, 1, 2, ...):
 *   index = (h1(key) + i * h2(key)) mod m
 *
 * Why double hashing vs. linear probing (step = 1)?
 *   Linear probing creates "clusters" — long runs of filled slots that slow
 *   down future insertions. Using an independent step size breaks up clusters.
 *
 * Why must h2 never return 0?
 *   If step = 0, every probe lands on the same index — infinite loop.
 *   Using 1 + (key mod (m-1)) guarantees step is always ≥ 1.
 *
 * Deletion note:
 *   Simple removal leaves a gap that breaks the probe chain for other keys.
 *   The standard fix is to mark deleted slots as "DELETED" (a tombstone) rather
 *   than truly emptying them — get() skips tombstones, put() can reuse them.
 *
 * Load factor constraint: keep α = n/m < 0.7 to avoid long probe sequences.
 *
 * Time complexity: O(1) average · O(n) worst case (table nearly full)
 * ─────────────────────────────────────────────────────────────────────────────
 */
class DoubleHashingExample {

    // Sentinel values for slot states
    static final int EMPTY   = Integer.MIN_VALUE;      // slot was never used
    static final int DELETED = Integer.MIN_VALUE + 1;  // slot was deleted (tombstone)

    static final int M = 11;               // table size — prime number recommended
    static int[]    keys   = new int[M];
    static String[] values = new String[M];

    static {
        java.util.Arrays.fill(keys, EMPTY);  // initialise all slots as empty
    }

    // ── Hash functions ────────────────────────────────────────────────────────
    // h1: determines the starting slot
    static int h1(int key) { return ((key % M) + M) % M; }

    // h2: determines the probe step — must NEVER return 0
    static int h2(int key) { return 1 + (((key % (M - 1)) + (M - 1)) % (M - 1)); }

    // ── put ───────────────────────────────────────────────────────────────────
    static void put(int key, String value) {
        int index     = h1(key);
        int step      = h2(key);
        int firstDead = -1;   // tracks first tombstone we can reuse

        for (int i = 0; i < M; i++) {
            if (keys[index] == EMPTY) {
                // Empty slot — place here (or reuse the first tombstone we passed)
                int target = (firstDead != -1) ? firstDead : index;
                keys[target]   = key;
                values[target] = value;
                System.out.printf("  put(%3d, %-8s)  h1=%d step=%d  →  slot %d%n",
                        key, value, h1(key), step, target);
                return;
            }
            if (keys[index] == key) {
                values[index] = value;  // update existing key
                return;
            }
            if (keys[index] == DELETED && firstDead == -1) {
                firstDead = index;  // remember first tombstone for potential reuse
            }
            index = (index + step) % M;
        }
        // If we only found tombstones and no empty slot, reuse the first tombstone
        if (firstDead != -1) {
            keys[firstDead]   = key;
            values[firstDead] = value;
            return;
        }
        throw new RuntimeException("Hash table is full");
    }

    // ── get ───────────────────────────────────────────────────────────────────
    // Follow the same probe sequence used during insert.
    // Stop only at a truly EMPTY slot (not a tombstone).
    static String get(int key) {
        int index = h1(key);
        int step  = h2(key);

        for (int i = 0; i < M; i++) {
            if (keys[index] == EMPTY) return null;       // genuine empty gap → key absent
            if (keys[index] == key)   return values[index]; // found
            // DELETED slots are skipped — the key may still be further along the chain
            index = (index + step) % M;
        }
        return null;
    }

    // ── remove ────────────────────────────────────────────────────────────────
    // Mark as DELETED (tombstone) rather than EMPTY to preserve probe chains
    // for other keys that were inserted past this slot.
    static boolean remove(int key) {
        int index = h1(key);
        int step  = h2(key);

        for (int i = 0; i < M; i++) {
            if (keys[index] == EMPTY)  return false;
            if (keys[index] == key) {
                keys[index]   = DELETED;  // tombstone — do NOT set to EMPTY
                values[index] = null;
                return true;
            }
            index = (index + step) % M;
        }
        return false;
    }

    static void printTable() {
        System.out.println("Hash table (m=" + M + "):");
        for (int i = 0; i < M; i++) {
            String state;
            if      (keys[i] == EMPTY)   state = "—";
            else if (keys[i] == DELETED) state = "[DELETED]";
            else                          state = keys[i] + " → " + values[i];
            System.out.printf("  [%2d] %s%n", i, state);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Double Hashing Demo ===\n");

        put(10, "Alice");
        put(21, "Bob");    // h1(21)=10, same as Alice → collision → probes forward
        put(32, "Carol");  // h1(32)=10, collision again → probes further
        put(5,  "Dave");
        put(16, "Eve");
        System.out.println();
        printTable();

        System.out.println("get(21) = " + get(21));  // Bob
        System.out.println("get(32) = " + get(32));  // Carol
        System.out.println("get(99) = " + get(99));  // null
        System.out.println();

        remove(21);
        System.out.println("After remove(21):");
        printTable();

        // get(32) still works because tombstone is skipped, not treated as EMPTY
        System.out.println("get(32) after removing 21 = " + get(32));  // still Carol
    }
}
