/*
 * ─────────────────────────────────────────────────────────────────────────────
 * Topic: Java HashMap — hashCode, equals, Load Factor, and Resizing
 * ─────────────────────────────────────────────────────────────────────────────
 * Java's HashMap is the standard library's hash table implementation.
 * It uses CHAINING internally (each bucket is a linked list; from Java 8,
 * long chains are converted to a balanced tree for O(log n) worst-case).
 *
 * ── The hashCode() / equals() Contract ───────────────────────────────────────
 * Every object inherits these from java.lang.Object:
 *   • equals(obj)    — by default compares REFERENCES (identity), not content
 *   • hashCode()     — by default returns a number based on memory address
 *
 * Rule (critical!):
 *   If two objects are EQUAL by equals() they MUST return the same hashCode().
 *   Otherwise HashMap will hash them to different buckets and treat them as
 *   different keys — even though your logic considers them equal.
 *
 * If you override equals(), you MUST also override hashCode().
 *
 * ── Load Factor and Resizing ──────────────────────────────────────────────────
 * Default initial capacity: 16 buckets
 * Default load factor:      0.75  (75% full triggers resize)
 *
 * When size > capacity × loadFactor:
 *   1. Create a new internal array of size ≈ 2 × old capacity
 *   2. Rehash every existing entry into its new position
 *   → This keeps the average chain length short → O(1) operations maintained
 *
 * This rehashing is O(n) but happens rarely enough that the amortised cost
 * per insertion remains O(1).
 * ─────────────────────────────────────────────────────────────────────────────
 */

import java.util.HashMap;
import java.util.Objects;

class JavaHashMapExample {

    // ── Example 1: basic HashMap usage ───────────────────────────────────────
    static void basicUsage() {
        System.out.println("=== Basic HashMap Usage ===");

        HashMap<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob",   87);
        scores.put("Carol", 92);
        scores.put("Bob",   90);  // updates Bob's score — same key, no duplicate

        System.out.println("Bob's score: "   + scores.get("Bob"));    // 90 (updated)
        System.out.println("Dave's score: "  + scores.get("Dave"));   // null — not found
        System.out.println("Contains Alice: " + scores.containsKey("Alice")); // true
        scores.remove("Carol");
        System.out.println("After removing Carol: " + scores);
        System.out.println();
    }

    // ── Example 2: incorrect equals without hashCode override ────────────────
    // BadKey overrides equals() but NOT hashCode() — breaks the contract.
    static class BadKey {
        int id;
        BadKey(int id) { this.id = id; }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof BadKey)) return false;
            return this.id == ((BadKey) o).id;
        }
        // hashCode() NOT overridden → uses Object's default (memory address)
    }

    static void brokenContract() {
        System.out.println("=== Broken hashCode Contract (BAD — don't do this) ===");

        HashMap<BadKey, String> map = new HashMap<>();
        BadKey k1 = new BadKey(42);
        map.put(k1, "hello");

        BadKey k2 = new BadKey(42);  // logically equal to k1 (same id)
        System.out.println("k1.equals(k2): " + k1.equals(k2));  // true
        System.out.println("get(k2): " + map.get(k2));           // null! — different hashCode
        System.out.println("^ Should have found 'hello' but got null because");
        System.out.println("  hashCode() was not overridden — k1 and k2 hash to different buckets.\n");
    }

    // ── Example 3: correct equals + hashCode override ────────────────────────
    static class GoodKey {
        int id;
        GoodKey(int id) { this.id = id; }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof GoodKey)) return false;
            return this.id == ((GoodKey) o).id;
        }

        // hashCode() consistent with equals(): same id → same hash
        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    static void correctContract() {
        System.out.println("=== Correct hashCode Contract (GOOD) ===");

        HashMap<GoodKey, String> map = new HashMap<>();
        GoodKey k1 = new GoodKey(42);
        map.put(k1, "hello");

        GoodKey k2 = new GoodKey(42);  // logically equal to k1
        System.out.println("k1.equals(k2): " + k1.equals(k2));         // true
        System.out.println("k1.hashCode() == k2.hashCode(): "
                + (k1.hashCode() == k2.hashCode()));                    // true
        System.out.println("get(k2): " + map.get(k2));                  // "hello" ✓
        System.out.println();
    }

    // ── Example 4: load factor and resizing ──────────────────────────────────
    static void loadFactorDemo() {
        System.out.println("=== Load Factor and Resizing ===");

        // initialCapacity=4, loadFactor=0.75 → resize triggers when size > 3
        HashMap<Integer, String> map = new HashMap<>(4, 0.75f);

        for (int i = 1; i <= 10; i++) {
            map.put(i, "value" + i);
            System.out.printf("  Added key %2d · size=%2d%n", i, map.size());
            // HashMap resizes internally at size 4 (4 * 0.75 = 3), 8, 16 etc.
            // We can't observe the internal capacity directly, but resizing
            // keeps performance O(1) amortised by keeping chains short.
        }
        System.out.println("Final map size: " + map.size());
    }

    public static void main(String[] args) {
        basicUsage();
        brokenContract();
        correctContract();
        loadFactorDemo();
    }
}
