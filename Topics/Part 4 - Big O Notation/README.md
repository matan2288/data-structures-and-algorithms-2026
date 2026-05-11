# Part 4 - Big O Notation

## 1. Why Big O?

**Big O** describes how an algorithm’s cost **grows** as the input size \(n\) grows. We care about the **dominant term** and ignore constant factors and lower-order terms.

Example: \(3n^2 + 10n + 7\) is **\(O(n^2)\)** — when \(n\) is large, the \(n^2\) part dominates.

## 2. Common classes (fast → slow growth)

| Notation | Name | Typical intuition |
|----------|------|---------------------|
| \(O(1)\) | constant | Hash map get (average), index into array |
| \(O(\log n)\) | logarithmic | Binary search in sorted array, balanced BST operations |
| \(O(n)\) | linear | Scan array or linked list once |
| \(O(n \log n)\) | linearithmic | Efficient comparison sorts (merge sort, heapsort) |
| \(O(n^2)\) | quadratic | Naive pairwise work, simple bubble/selection on all pairs |
| \(O(2^n)\) | exponential | Enumerate all subsets |

## 3. Time vs space

- **Time complexity** — how runtime grows with \(n\).
- **Space complexity** — extra memory besides the input (arrays you allocate, recursion stack, auxiliary data structures).

## 4. Best, average, worst

One algorithm can have different bounds:

- **Worst case** — guarantees for any input of size \(n\) (most common for hard analysis).
- **Average case** — expected behavior over random inputs (e.g. quicksort **\(O(n \log n)\)** average, **\(O(n^2)\)** worst without good pivot rules).
- **Amortized** — average cost per operation over a **sequence** (e.g. dynamic array append is **\(O(1)\)** amortized).

## 5. Linked list vs array (reminder)

| Operation | Array (by index) | Linked list |
|-----------|------------------|-------------|
| Access \(i\) | \(O(1)\) | \(O(n)\) |
| Insert/delete at known node | shift \(O(n)\) | \(O(1)\) if you already have the reference |

See the runnable example for tiny **step counts** that illustrate \(O(1)\), \(O(n)\), and \(O(n^2)\) growth.
