# Part 2 - Recursion

## 1. What is recursion?

A **recursive** method is one that calls itself (directly or indirectly) to solve a smaller instance of the same problem. You always need:

- **Base case** — a condition where the method stops calling itself and returns a concrete answer (no more recursion).
- **Recursive step** — the method calls itself with arguments that move closer to the base case.

Without a proper base case (or if the recursive step never approaches it), you get infinite recursion until the **call stack** overflows (`StackOverflowError`).

## 2. Call stack (mental model)

Each call waits for the inner call to return:

```
items([2→5→7→9])
  → 1 + items([5→7→9])
        → 1 + items([7→9])
              → 1 + items([9])
                    → 1 + items(null)  ← base case returns 0
```

The runtime keeps a **stack** of “who is waiting for whom.” Recursion depth equals how many active calls sit on that stack at once.

## 3. Recursion on linked lists

The list is either **empty** (`null`) or **one node plus a shorter list** (`head.next`). Many list problems fit this pattern:

| Idea            | Base case     | Recursive step                          |
|-----------------|---------------|-----------------------------------------|
| Length / count  | `head == null` | `1 + f(head.next)`                     |
| Sum of values   | `head == null` | `head.data + f(head.next)`             |
| Search for value| `head == null` | compare `head.data`, else `f(head.next)` |

## 4. When to prefer iteration?

Recursion and loops are often interchangeable. Recursion is often clearer for **trees** and **divide-and-conquer** structures; iteration avoids deep stacks on very long chains. Tail-call optimization is **not** guaranteed in Java, so deep linear recursion on huge lists can be risky compared to a `while` loop.

## 5. Complexity intuition

For a linear chain of \(n\) nodes, one pass recursion is typically **\(O(n)\)** time and **\(O(n)\)** extra stack space in the worst case. For a balanced binary tree, height is **\(O(\log n)\)**, so recursive tree walks are often **\(O(n)\)** time and **\(O(\log n)\)** stack depth.
