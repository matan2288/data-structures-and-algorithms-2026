# Part 5 — Stacks & Queues

---

## Stack — Last In, First Out (LIFO)

Think of it like a stack of plates: you always add and remove from the **top**.
The last plate placed is the first one taken off.

### How it works

```
push("A") → push("B") → push("C")

         ┌───┐
   top → │ C │  ← push / pop here
         ├───┤
         │ B │
         ├───┤
         │ A │  ← bottom
         └───┘
```

### Methods

| Method | Description | Complexity |
|--------|-------------|------------|
| `push(value)` | Add value to the **top** | O(1) |
| `pop()` | Remove and return the **top** value | O(1) |
| `peek()` | Read the **top** value without removing | O(1) |
| `isEmpty()` | Check if the stack has no elements | O(1) |

### Mermaid Chart
- [`Stack/Stack.mmd`](Stack/Stack.mmd) — push · pop · peek

### Java Example
```java
Deque<String> stack = new ArrayDeque<>();
stack.push("first");   // bottom
stack.push("second");
stack.push("third");   // top

stack.peek();  // "third"  — stack unchanged
stack.pop();   // "third"  — removed
stack.pop();   // "second" — removed
```

### Real-world uses
- **Undo / Redo** — every action is pushed; Ctrl+Z pops the last one
- **Call Stack** — the JVM tracks method calls with a stack
- **Browser Back button** — each page visit is pushed onto a history stack
- **Matching parentheses / brackets** — classic stack problem

---

## Queue — First In, First Out (FIFO)

Think of it like a line at a ticket counter: the first person to arrive is the first served.

### How it works

```
offer(10) → offer(20) → offer(30)

  front                         rear
    ↓                             ↓
  ┌────┬────┬────┐
  │ 10 │ 20 │ 30 │   poll() removes from front →
  └────┴────┴────┘
```

### Methods

| Method | Description | Complexity |
|--------|-------------|------------|
| `offer(value)` | Add value to the **rear** | O(1) |
| `poll()` | Remove and return the **front** value | O(1) |
| `peek()` | Read the **front** value without removing | O(1) |
| `isEmpty()` | Check if the queue has no elements | O(1) |

### Mermaid Chart
- [`Queue/Queue.mmd`](Queue/Queue.mmd) — offer · poll · peek

### Java Example
```java
Queue<Integer> queue = new ArrayDeque<>();
queue.offer(10);  // front
queue.offer(20);
queue.offer(30);  // rear

queue.peek();  // 10  — queue unchanged
queue.poll();  // 10  — removed (FIFO)
queue.poll();  // 20
queue.poll();  // 30
```

### Real-world uses
- **Print Spooler** — print jobs are queued and processed in order
- **Web Server Requests** — incoming HTTP requests wait in a queue
- **Message Queues** (RabbitMQ, Kafka) — async communication between services
- **BFS (Breadth-First Search)** — frontier nodes are explored level by level via a queue

---

## Stack vs Queue — Side by Side

| | Stack | Queue |
|-|-------|-------|
| Order | LIFO — Last In, First Out | FIFO — First In, First Out |
| Add | `push` → top | `offer` → rear |
| Remove | `pop` ← top | `poll` ← front |
| Peek | top element | front element |
| Java class | `Deque` / `ArrayDeque` | `Queue` / `ArrayDeque` |
| Use case | Undo, recursion, DFS | Scheduling, BFS, messaging |

---

## ArrayDeque vs LinkedList

For most single-threaded stacks and queues, **`ArrayDeque`** is the best choice:
- Faster cache performance (contiguous memory)
- No per-node pointer overhead
- Works as both a **stack** and a **queue**

Use `LinkedList` only when you need **O(1) insertion in the middle** — which is rare for basic stack/queue usage. Avoid the legacy `Stack` class (extends `Vector`, has unnecessary synchronization overhead).
