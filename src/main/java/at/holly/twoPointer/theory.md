# Two Pointer

## Detecting cycles in a linked list

1. Using HashSet (easy but extra memory)
   
Keep a set of visited nodes.
If you ever visit the same node twice → cycle detected.

```java
public boolean hasCycle(ListNode head) {
    Set<ListNode> visited = new HashSet<>();
    ListNode current = head;
    while (current != null) {
        if (visited.contains(current)) {
            return true; // cycle detected
        }
        visited.add(current);
        current = current.next;
    }
    return false;
}
```

2. Floyd’s Cycle Detection (Tortoise and Hare)
   
This is the optimal and most famous solution.
Uses two pointers, runs in O(n) time, O(1) space.

1. Start both at the head
2. Move them:
   3. slow = slow.next 
   4. fast = fast.next.next

At some point:
- If there is no cycle, fast (or fast.next) will hit null → return false
- If there is a cycle, fast will eventually “lap” slow and they’ll meet → return true

```java
public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;          // move 1 step
        fast = fast.next.next;     // move 2 steps

        if (slow == fast) {
            return true;           // pointers meet → cycle
        }
    }

    return false; // fast reached null → no cycle
}
```
