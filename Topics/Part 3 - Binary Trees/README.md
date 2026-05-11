# Part 3 - Binary Trees

## 1. What is a binary tree?

A **binary tree** is a hierarchy of **nodes**. Each node stores a value (often called **key** or **data**) and at most two children:

- **left** — root of the left subtree (or `null`)
- **right** — root of the right subtree (or `null`)

```
        (4)
       /   \
     (2)   (7)
    /  \      \
  (1)  (3)    (9)
```

There is exactly one **root** (the node with no parent). Nodes with no children are **leaves**.

## 2. Binary search tree (BST)

A **BST** keeps an **ordering** invariant: for every node, all values in its **left** subtree are **smaller** (or equal, if duplicates allowed), and all values in its **right** subtree are **greater**. In-order traversal of a BST visits keys in sorted order.

## 3. Important measures

| Term | Meaning |
|------|---------|
| **Height** | Longest path from root down to a leaf (edges or nodes — define consistently). |
| **Depth** of a node | Distance from the root to that node. |
| **Balanced** tree | Height is **\(O(\log n)\)** for \(n\) nodes (e.g. AVL, red-black). |

## 4. Traversals (recursive)

- **Preorder** — node, left, right (good for copying structure).
- **Inorder** — left, node, right (BST → sorted order).
- **Postorder** — left, right, node (good for deleting subtrees bottom-up).

## 5. Complexity (typical)

For \(n\) nodes:

| Operation | balanced BST | skewed chain |
|-----------|--------------|--------------|
| Search / insert / delete | \(O(\log n)\) | \(O(n)\) worst |

Recursion depth follows **tree height**, so balanced trees keep the call stack shallow.
