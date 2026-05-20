# Part 7 — Hash Tables

---

## Overview

A **Hash Table** is a data structure used to implement dictionaries (key → value mappings).

| Case | Search / Insert / Delete |
|------|--------------------------|
| Average | **O(1)** |
| Worst case | O(n) — all keys collide into one chain |

The O(1) average is achieved by using a **hash function** to map keys directly to array indices, combined with a good collision-resolution strategy.

---

## 1. Hash Function

### The Problem — Direct Addressing

If you create one array slot for every possible key (e.g. all integers), the array would be enormous — mostly empty wasted memory.

### The Solution — Hash Function h(key)

Maps any key from the large universe **U** to a small range **[0..m-1]**:

```
h(key) = key mod m
```

- Choose **m as a prime number** to spread keys more evenly.
- Same key → always same index (deterministic).
- Cheap to compute: O(1).

### What is a Hash Collision?

When two different keys produce the same index: `h(k1) == h(k2)`.
Since m < |U|, collisions are unavoidable — we need strategies to handle them.

### Mermaid Chart
- [`01_HashFunction/HashFunction.mmd`](01_HashFunction/HashFunction.mmd)

### Java Example
- [`01_HashFunction/01_HashFunctionExample.java`](01_HashFunction/01_HashFunctionExample.java) — demonstrates a raw hash function and shows what happens without collision handling

---

## 2. Collision Resolution — Chaining

### How it works

Each array slot does **not** hold a value directly — it holds the **head of a linked list**. All keys that hash to the same index are stored in that chain.

```
arr[0] → null
arr[1] → [key=22,"Alice"] → [key=15,"Dave"] → null
arr[2] → [key=35,"Bob"]   → null
arr[3] → null
```

### Operations

| Operation | Average | Worst case |
|-----------|---------|------------|
| put(key, value) | O(1) — prepend to head | O(n) — all keys in one chain |
| get(key) | O(1) — walk short chain | O(n) |
| remove(key) | O(1) — bypass node | O(n) |

**Load factor** α = n/m (n = stored keys, m = table size).
Average chain length ≈ α — keep α ≤ 1 for fast operations.

### Mermaid Chart
- [`02_Chaining/Chaining.mmd`](02_Chaining/Chaining.mmd) — put · get · remove

### Java Example
- [`02_Chaining/02_ChainingExample.java`](02_Chaining/02_ChainingExample.java) — full chaining hash table with visual chain printout

---

## 3. Collision Resolution — Double Hashing

### How it works

All entries are stored **directly in the array** (no linked lists — open addressing).
On a collision, a **second hash function** computes a step size, and the algorithm probes until an empty slot is found:

```
Probe sequence:  index = (h1(key) + i × h2(key)) mod m   for i = 0, 1, 2, ...

h1(key) = key mod m
h2(key) = 1 + (key mod (m-1))   ← must never return 0
```

### Why double hashing vs. linear probing?

Linear probing (step=1) creates **primary clustering** — long runs of filled slots that slow future insertions. An independent step size breaks up clusters.

### Deletion — Tombstones

You cannot simply clear a removed slot (EMPTY) — that would break probe chains for keys inserted past it. Instead, mark deleted slots as **DELETED** (tombstone):
- `get()` skips tombstones and keeps probing.
- `put()` can reuse tombstone slots.

### Mermaid Chart
- [`03_DoubleHashing/DoubleHashing.mmd`](03_DoubleHashing/DoubleHashing.mmd) — insert · search · tombstone concept

### Java Example
- [`03_DoubleHashing/03_DoubleHashingExample.java`](03_DoubleHashing/03_DoubleHashingExample.java) — full double-hashing table with tombstone deletion

---

## 4. Hash Tables in Java — HashMap

### hashCode() and equals()

Every Java object inherits both from `Object`. The contract:

> If `a.equals(b)` is `true`, then `a.hashCode()` **must equal** `b.hashCode()`.

If you override `equals()` you **must** also override `hashCode()`. Breaking this rule causes `HashMap` to silently lose or duplicate entries.

```java
@Override
public boolean equals(Object o) { ... }

@Override
public int hashCode() {
    return Objects.hash(field1, field2);  // use all fields that equals() uses
}
```

### Internal structure

Java's `HashMap` uses an **array of Entry objects** — each Entry holds key, value, and a `next` pointer (chaining). From Java 8, chains longer than 8 are converted to a balanced tree (O(log n) worst case).

### Load Factor and Resizing

| Setting | Default |
|---------|---------|
| Initial capacity | 16 |
| Load factor threshold | 0.75 |

When `size > capacity × 0.75`:
1. Allocate a new array of size ≈ `2 × capacity`
2. **Rehash** every existing entry into its new position (O(n) one-time cost)

This keeps chains short and average operations at O(1).

### Mermaid Chart
- [`04_JavaHashMap/JavaHashMap.mmd`](04_JavaHashMap/JavaHashMap.mmd) — hashCode contract · put internals · load factor & resize

### Java Example
- [`04_JavaHashMap/04_JavaHashMapExample.java`](04_JavaHashMap/04_JavaHashMapExample.java) — basic usage · broken contract demo · correct override · load factor demo

---

## Summary — Chaining vs. Double Hashing

| | Chaining | Double Hashing |
|-|----------|----------------|
| Storage | Array + linked lists | Array only |
| On collision | Add to chain | Probe to next slot |
| Load factor | Can exceed 1 (chains grow) | Must stay < 1 (array is finite) |
| Deletion | Simple node removal | Requires tombstones |
| Cache friendliness | Poor (pointer chasing) | Better (array is contiguous) |
| Used by Java | Yes (HashMap) | Less common in standard libs |

| Operation | Average | Worst case |
|-----------|---------|------------|
| Search | O(1) | O(n) |
| Insert | O(1) | O(n) |
| Delete | O(1) | O(n) |
