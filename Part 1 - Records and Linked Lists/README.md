# Part 1 - Records And Linked Lists

## 1. Records

A **Record** is a compact way to define an immutable data class in Java. One line gives you a constructor, accessors, `equals()`, `hashCode()`, and `toString()`:

```java
record Point(int x, int y) { }
```

Fields are `final` — once created, they can't change. This makes Records **Immutable**.

> **Immutable** = cannot be changed after creation (e.g. `String`, `record`).
> **Mutable** = can be changed after creation (e.g. `StringBuilder`, regular `class` fields).

## 2. Nodes

A **Node** is the building block of a Linked List. Each node holds two things:

- **data** — the value it stores
- **next** — a reference (pointer) to the next Node, or `null` if it's the last one

> In Java there are no explicit pointers like in C. Instead, **references** serve the same role — a variable that "points to" an object in memory.
>
> ```java
> Node a = new Node(1, null); // 'a' is a reference pointing to a Node object
> Node b = a;                 // 'b' points to the same object as 'a'
> ```

```
[1 | *] -> [2 | *] -> [3 | null]
```

In Java, we can define a node as a record:

```java
record Node(int data, Node next) { }
```

## 3. Linked Lists

A **Linked List** is a chain of Nodes. Unlike arrays, elements aren't stored in contiguous memory — each node just points to the next.

- **Head** — the first node in the list. This is your entry point; all traversal starts here.
- **Tail** — the last node in the list. Its `next` is `null`.

```
 head                        tail
  v                           v
[1 | *] -> [2 | *] -> [3 | null]
```

| Operation       | Array | Linked List |
|-----------------|-------|-------------|
| Access by index | O(1)  | O(n)        |
| Insert at head  | O(n)  | O(1)        |
| Delete at head  | O(n)  | O(1)        |
| Search          | O(n)  | O(n)        |
