# Big-O Complexity (time & space)

## What Big-O really means

Big-O expresses growth rate — how runtime or memory scales with input size n, ignoring constants and lower-order terms.

| Example                          | Big-O      | Explanation                  |
| -------------------------------- | ---------- | ---------------------------- |
| `for (int i=0; i<n; i++)`        | O(n)       | Linear — one pass            |
| Nested loops `for(i<n) for(j<n)` | O(n²)      | Quadratic — double iteration |
| Divide-and-conquer (`mergeSort`) | O(n log n) | Log factor for splitting     |
| Binary search                    | O(log n)   | Each step halves range       |
| Constant-time operation          | O(1)       | Doesn’t depend on `n`        |

## Space complexity
Measures extra memory used.

Example: int[] arr = new int[n] → O(n)

Recursive calls: add O(depth)

Key rule: If you copy or store all input data, that’s O(n).
If you only use a few counters, it’s O(1).

# Data Structures 

## 1. Arrays
* Access: O(1) (indexing)
* Search unsorted: O(n)
* Sort: O(n log n)
* Use for: fixed-size, fast lookups by index, memory efficiency.
* Pitfall: resizing (→ use ArrayList if dynamic).

## 2. Strings
Strings in Java are immutable → every modification creates a new object.
So building in a loop with + = O(n²) worst case. Instead if we want to add chars to a 
String we use StringBuilder.

``` java 
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        sb.append(Character.toUpperCase(c));
    }
    return sb.toString();  // O(n)
```

## 3. HashMap & HashSet

HashMap<K,V>
* Insert / lookup / delete: Average O(1)
* Collision handling: chaining (linked lists) or trees since Java 8
* Worst case: O(n) if all keys collide (rare)

```java
    Map<Character, Integer> freq = new HashMap<>();
    for (char c : "banana".toCharArray()) {
        freq.put(c, freq.getOrDefault(c, 0) + 1);
    }
```

Result : {b=1, a=3, n=2}

HashSet<E>
* Stores only unique items.
* Perfect for membership tests: “have we seen this before?”

```java
    Set<Integer> seen = new HashSet<>();
    for (int x : nums) {
        if (seen.contains(x)) return true; // duplicate
        seen.add(x);
    }
```
