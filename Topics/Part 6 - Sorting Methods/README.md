# Part 6 - Sorting Methods

Search algorithms, comparison sorts, and a linked list recap.

**Big O** (see Part 4) describes how time or space grows with input size \(n\): we keep the dominant term and drop constants.


## 1. Algorithms overview

| Algorithm | Type | Description | Worst case | Average / good case |
|-----------|------|-------------|------------|---------------------|
| **Binary search** | Divide and conquer | Search a **sorted** array by comparing to the middle element and halving the range each step. | \(O(\log n)\) | \(O(1)\)* |
| **Linear search** | Search | Walk element by element until the target is found or the end is reached. | \(O(n)\) | \(O(n)\) |
| **Merge sort** | Divide and conquer | Split in half, sort each half recursively, then **merge** into one sorted array. | \(O(n \log n)\) | \(O(n \log n)\) |
| **Heap sort** | Selection sort | Build a **heap**, then repeatedly extract max/min to fill the sorted array. | \(O(n \log n)\) | \(O(n \log n)\) |
| **Bubble sort** | Exchange sort | Compare **adjacent** pairs, swap when out of order; repeat until sorted. | \(O(n^2)\) | \(O(n)\)** |
| **Selection sort** | Selection sort | Each pass finds the **minimum** in the unsorted part and swaps it into place. | \(O(n^2)\) | \(O(n^2)\) |
| **Insertion Sort** | Insertion sort | Insert each element into the sorted prefix by shifting larger values right. | \(O(n)\)*** | \(O(n^2)\) |
| **Linked list** | Linear structure | Elements linked by `next` pointers; order is not stored in contiguous memory. | \(O(n)\) access | \(O(1)\) insert at head |

**Footnotes**

- \* \(O(1)\) when the target is at the middle on the first comparison.
- \** \(O(n)\) when already sorted and the loop exits early (no swaps).
- \*** Per course table; textbook worst is often \(O(n^2)\), best \(O(n)\) when nearly sorted.


### Big O notation (quick reference)

| Notation | Name | Used in this part |
|----------|------|-------------------|
| \(O(1)\) | Constant | Linked list prepend; binary search best hit |
| \(O(\log n)\) | Logarithmic | Binary search |
| \(O(n)\) | Linear | Linear search; bubble sort (best); list access by index |
| \(O(n \log n)\) | Linearithmic | Merge sort, heap sort |
| \(O(n^2)\) | Quadratic | Bubble, selection, insertion |


### Extra space (typical)

| Algorithm | Extra space |
|-----------|-------------|
| Binary search | \(O(1)\) |
| Linear search | \(O(1)\) |
| Merge sort | \(O(n)\) auxiliary array |
| Heap sort | \(O(1)\) |
| Bubble / selection / insertion sort | \(O(1)\) |
| Linked list | \(O(1)\) per new node |


## 2. Folder structure

Each algorithm lives in its own folder with a Java source file and a standalone Mermaid chart:

```
Part 6 - Sorting Methods/
├── BinarySearch/
│   ├── 01_BinarySearch.java
│   └── BinarySearch.md
├── LinearSearch/
│   ├── 02_LinearSearch.java
│   └── LinearSearch.md
├── MergeSort/
│   ├── 03_MergeSort.java
│   └── MergeSort.md
├── HeapSort/
│   ├── 04_HeapSort.java
│   └── HeapSort.md
├── BubbleSort/
│   ├── 05_BubbleSort.java
│   └── BubbleSort.md
├── SelectionSort/
│   ├── 06_SelectionSort.java
│   └── SelectionSort.md
├── InsertionSort/
│   ├── 07_InsertionSort.java
│   └── InsertionSort.md
└── LinkedList/
    ├── 08_LinkedList.java
    └── LinkedList.md
```

Compile and run from the algorithm's folder, for example:

```bash
cd BinarySearch && javac 01_BinarySearch.java && java BinarySearch
```

Each `.java` file includes **Big O** comments at the top (and on key methods where helpful).
