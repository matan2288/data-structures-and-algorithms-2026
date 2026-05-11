# Sorting Methods

## 1. Comparison sorts

Algorithms that decide order by **comparing** pairs of elements. Any general comparison sort needs **\(\Omega(n \log n)\)** comparisons in the worst case.

## 2. Classic algorithms (overview)

| Algorithm | Best | Average | Worst | Space | Stable? |
|-----------|------|---------|-------|-------|---------|
| Bubble sort | \(O(n)\)* | \(O(n^2)\) | \(O(n^2)\) | \(O(1)\) | Yes |
| Selection sort | \(O(n^2)\) | \(O(n^2)\) | \(O(n^2)\) | \(O(1)\) | No |
| Insertion sort | \(O(n)\) | \(O(n^2)\) | \(O(n^2)\) | \(O(1)\) | Yes |
| Merge sort | \(O(n \log n)\) | \(O(n \log n)\) | \(O(n \log n)\) | \(O(n)\) | Yes |
| Quicksort | \(O(n \log n)\) | \(O(n \log n)\) | \(O(n^2)\)** | \(O(\log n)\) stack | No*** |

\* Bubble sort can be \(O(n)\) with an “already sorted” early exit.  
\** Worst case when bad pivots (e.g. already sorted with naive pivot).  
\*** Can be stable with extra effort; standard in-place quicksort is not.

**Stable** = equal keys keep their original relative order (important when sorting by secondary keys).

## 3. When to use which

- **Small \(n\)** or nearly sorted: **insertion sort** is simple and fast in practice.
- **Guaranteed \(O(n \log n)\)** and merges: **merge sort** (needs \(O(n)\) extra space).
- **General-purpose fast in-memory sort**: **quicksort** (or library `Arrays.sort` / `Collections.sort`, which use tuned hybrids).

## 4. Non-comparison sorts

**Counting sort**, **radix sort**, **bucket sort** beat \(O(n \log n)\) when keys are integers in a bounded range or satisfy special structure — not universal comparison sorts.

Run the examples: simple **bubble** and **selection** in one file, **merge sort** in the second.
