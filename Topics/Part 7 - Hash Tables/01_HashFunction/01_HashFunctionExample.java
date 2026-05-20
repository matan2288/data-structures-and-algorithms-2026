/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: Hash Function — Mapping Keys to Array Indices
 * ─────────────────────────────────────────────────────────────────────────────
 * Problem with direct addressing:
 *   If the universe of possible keys (U) is huge (e.g. all integers), allocating
 *   one array slot per possible key wastes an enormous amount of memory — most
 *   slots would remain empty.
 *
 * Solution — Hash Function h(key):
 *   Maps any key from the large universe U to a small range [0..m-1].
 *   We only allocate an array of size m (the hash table).
 *
 *   Most common: h(key) = key mod m
 *   Best practice: choose m as a prime number to distribute keys more evenly.
 *
 * Limitation demonstrated here:
 *   Without collision handling, two keys that map to the same index will
 *   overwrite each other. This file shows the raw concept only.
 *   See 02_Chaining and 03_DoubleHashing for full collision resolution.
 *
 * Average time complexity (with a good hash function):
 *   Insert / Search / Delete → O(1)
 * ─────────────────────────────────────────────────────────────────────────────
 */
class HashFunctionExample {

    // Table size — choosing a prime number reduces clustering
    static final int M = 11;
    static String[] table = new String[M];

    // ── Hash function: h(key) = key mod m ────────────────────────────────────
    // Maps any integer key to an index in [0..M-1].
    // The extra +M and mod handles negative keys gracefully.
    static int hash(int key) {
        return ((key % M) + M) % M;
    }

    // ── Insert ────────────────────────────────────────────────────────────────
    // Stores a value at the slot determined by the hash.
    // WARNING: overwrites any existing entry — no collision handling here.
    static void put(int key, String value) {
        int index = hash(key);
        System.out.printf("  put(%3d, %-8s)  →  h(%d) = %d%n", key, value, key, index);
        table[index] = value;
    }

    // ── Search ────────────────────────────────────────────────────────────────
    static String get(int key) {
        return table[hash(key)];
    }

    static void printTable() {
        System.out.println("\nHash table (size " + M + "):");
        for (int i = 0; i < M; i++) {
            System.out.printf("  [%2d] %s%n", i, table[i] != null ? table[i] : "—");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Hash Function Demo (no collision handling) ===\n");

        put(22,  "Alice");   // 22 mod 11 = 0
        put(35,  "Bob");     // 35 mod 11 = 2
        put(100, "Carol");   // 100 mod 11 = 1
        put(46,  "Dave");    // 46 mod 11 = 2  ← COLLISION with Bob! Bob gets overwritten
        printTable();

        System.out.println("get(35) = " + get(35));  // returns Dave, NOT Bob — collision lost Bob
        System.out.println("get(22) = " + get(22));  // Alice — no collision here

        System.out.println("\n→ Collision at index 2 caused Bob to be overwritten.");
        System.out.println("  See 02_ChainingExample.java to handle this correctly.");
    }
}
