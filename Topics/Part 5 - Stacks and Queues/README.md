# Part 5 - Stacks and Queues

## 1. Stack (LIFO)

A **stack** is **Last In, First Out**: the last element you **push** is the first you **pop**.

Think: stack of plates, undo history, DFS, matching parentheses.

| Operation | Typical complexity |
|-----------|-------------------|
| push | \(O(1)\) |
| pop | \(O(1)\) |
| peek (top) | \(O(1)\) |

In Java, `Deque` implementations such as **`ArrayDeque`** are a good choice (`push`, `pop`, `peek`).

## 2. Queue (FIFO)

A **queue** is **First In, First Out**: the first element **enqueued** is the first **dequeued**.

Think: line at a ticket counter, BFS, scheduling tasks.

| Operation | Typical complexity |
|-----------|-------------------|
| enqueue (add rear) | \(O(1)\) |
| dequeue (remove front) | \(O(1)\) |
| peek front | \(O(1)\) |

Use **`ArrayDeque`** as a queue: `offer`, `poll`, `peek` — avoid the old `Stack` class (legacy, based on `Vector`).

## 3. When stacks and queues show up

- **Recursion** — the JVM uses a **call stack**; iterative DFS can use an explicit stack.
- **BFS on graphs/trees** — queue of frontier nodes.
- **Monotonic stack** — advanced pattern for “next greater element” problems.

## 4. ArrayDeque vs LinkedList

For most single-threaded stacks/queues, **`ArrayDeque`** is faster and more memory-friendly than `LinkedList`. Use `LinkedList` when you truly need **\(O(1)\)** insertion in the **middle** (rare for basic stack/queue usage).
