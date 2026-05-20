# Part 3 — Binary Trees

---

## 1. Binary Tree (BT)

A **binary tree** is a hierarchical data structure where each node has **at most two children** — a left subtree and a right subtree.

```
        (4)  ← root
       /   \
     (2)   (7)
    /  \      \
  (1)  (3)    (9)  ← leaves
```

| Term | Meaning |
|------|---------|
| **Root** | The top node — has no parent |
| **Leaf** | A node with no children |
| **Height** | Longest path (in edges) from root to any leaf |
| **Depth** | Distance from root to a specific node |

### Mermaid Chart
- [`01_BinaryTree/BinaryTree.mmd`](01_BinaryTree/BinaryTree.mmd) — structure, root, leaf, height

### Java Example
- [`01_BinaryTree/01_BinaryTreeNodeExample.java`](01_BinaryTree/01_BinaryTreeNodeExample.java) — countNodes · height · sumValues

---

## 2. Binary Search Tree (BST)

A **BST** is a binary tree with an ordering invariant:

> For every node: all keys in the **left subtree are smaller**, all keys in the **right subtree are larger**.

This allows efficient **Search**, **Insert**, and **Delete** in O(log n) on a balanced tree.

### Delete — 3 Cases

| Case | Action |
|------|--------|
| **0 children** (leaf) | Remove the node directly |
| **1 child** | Replace the node with its only child |
| **2 children** | Find the **in-order successor** (smallest in right subtree), copy its value here, then delete the successor |

| Operation | Balanced BST | Skewed (worst case) |
|-----------|-------------|---------------------|
| Search | O(log n) | O(n) |
| Insert | O(log n) | O(n) |
| Delete | O(log n) | O(n) |

### Mermaid Chart
- [`03_BST/BST.mmd`](03_BST/BST.mmd) — search · insert · delete (all 3 cases)

### Java Example
- [`03_BST/03_BSTExample.java`](03_BST/03_BSTExample.java) — insert · search · delete (all 3 cases)

---

## 3. Tree Traversals

Three recursive methods to visit every node exactly once:

| Traversal | Order | Use case |
|-----------|-------|----------|
| **Pre-order** | Root → Left → Right | Copying a tree, serialization |
| **In-order** | Left → Root → Right | **BST → visits nodes in sorted ascending order** |
| **Post-order** | Left → Right → Root | Deleting a tree bottom-up, evaluating expressions |

```
Tree:           (4)
               /   \
             (2)   (7)
            /  \      \
          (1)  (3)    (9)

Pre-order:   4  2  1  3  7  9
In-order:    1  2  3  4  7  9   ← sorted!
Post-order:  1  3  2  9  7  4
```

### Mermaid Chart
- [`02_Traversals/Traversals.mmd`](02_Traversals/Traversals.mmd) — pre-order · in-order · post-order

### Java Example
- [`02_Traversals/02_BinaryTreeTraversalExample.java`](02_Traversals/02_BinaryTreeTraversalExample.java) — all three traversals

---

## 4. AVL Trees

An **AVL tree** is a self-balancing BST that guarantees height **O(log n)** — ensuring fast operations even after many insertions and deletions.

### Balance Factor

Every node tracks: `balanceFactor = height(left) - height(right)`

The invariant: **balanceFactor must always be -1, 0, or 1**.

If an insert or delete breaks this, the tree **rotates** to restore balance.

### 4 Rotation Cases

| Imbalance | Detected by | Fix |
|-----------|-------------|-----|
| Left-Left (LL) | balanceFactor > 1, left child ≥ 0 | Right Rotation |
| Left-Right (LR) | balanceFactor > 1, left child < 0 | Left Rotation on child → Right Rotation |
| Right-Right (RR) | balanceFactor < -1, right child ≤ 0 | Left Rotation |
| Right-Left (RL) | balanceFactor < -1, right child > 0 | Right Rotation on child → Left Rotation |

### Mermaid Chart
- [`04_AVL/AVL.mmd`](04_AVL/AVL.mmd) — balance check · all 4 rotation cases

### Java Example
- [`04_AVL/04_AVLExample.java`](04_AVL/04_AVLExample.java) — insert with auto-rotation · balance factor tracking

---

## 5. Almost Complete Binary Trees & Heaps

An **almost complete binary tree** is filled **level by level, from left to right** — every level is full except possibly the last, which is filled from the left.

### Array Representation — No Pointers Needed

Because the shape is predictable, a heap is stored as a flat array:

```
Tree:                Array (1-indexed):
    (1)              index:  1   2   3   4   5   6
   /   \             value:  1   3   6   5   9   8
 (3)   (6)
 / \   /
(5)(9)(8)
```

| Relationship | Formula (1-indexed) |
|---|---|
| Parent of node at `i` | `i / 2` |
| Left child of node at `i` | `2 * i` |
| Right child of node at `i` | `2 * i + 1` |

### Min-Heap Property

Every parent is **smaller than or equal to** its children.
- **Insert**: place at next free slot, then **bubble up** (swap with parent while smaller)
- **Extract min**: remove root, move last element to root, then **bubble down** (swap with smaller child while larger)

| Operation | Complexity |
|-----------|------------|
| Insert | O(log n) |
| Extract min/max | O(log n) |
| Peek min/max | O(1) |
| Build heap from array | O(n) |

### Mermaid Chart
- [`05_Heap/Heap.mmd`](05_Heap/Heap.mmd) — tree structure · array mapping · index formulas · min-heap insert

### Java Example
- [`05_Heap/05_HeapExample.java`](05_Heap/05_HeapExample.java) — insert · bubbleUp · extractMin · bubbleDown

---

## Summary

| Structure | Ordering | Height guarantee | Key strength |
|-----------|----------|-----------------|--------------|
| Binary Tree | None | O(n) worst | General hierarchy |
| BST | Left < Root < Right | O(n) worst | Fast search when balanced |
| AVL Tree | Left < Root < Right | O(log n) always | Guaranteed fast operations |
| Heap | Parent ≤ children (min) | O(log n) | Fast min/max access |
