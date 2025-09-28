# Assignment 1 – Divide and Conquer Algorithms (Java)

## Project Goal
This project was made for my DAA course. The main goal was to learn how to implement classic **divide and conquer** algorithms, understand how recursion works, and analyze their running time using **Master theorem** and **Akra–Bazzi** methods.  
I also tried to measure the time, recursion depth, and compare the real results with theory.

---

## Implemented Algorithms

1. **MergeSort** – sorting an array by splitting and merging  
2. **QuickSort** – fast sorting with random pivot  
3. **Deterministic Select** – finding the k-th smallest element (Median-of-Medians)  
4. **Closest Pair of Points** – finding the closest two points in 2D space

---

## Algorithm Analysis

### MergeSort
- **Idea:** Split the array into two parts, sort them recursively, and then merge them back into a sorted array.
- **Recurrence:** `T(n) = 2T(n/2) + O(n)`
- **Solution:** Master theorem – Case 2  
- **Result:** `Θ(n log n)`

This algorithm is stable and always runs in `O(n log n)`, but it needs extra memory for merging.

---

### QuickSort
- **Idea:** Pick a random pivot, split the array into two subarrays (smaller and bigger than pivot), and sort them recursively.
- **Recurrence (average case):** `T(n) = 2T(n/2) + O(n)`
- **Solution:** Master theorem – Case 2  
- **Result:** `Θ(n log n)`

QuickSort is usually faster than MergeSort in practice because of better cache usage, but worst-case time is `O(n²)` (rare with random pivot).

---

### Deterministic Select (Median-of-Medians)
- **Idea:** Group elements into groups of 5, find the median of each group, then use the median of these medians as the pivot. Recurse only into the part that contains the k-th element.
- **Recurrence:** `T(n) = T(n/5) + T(7n/10) + O(n)`
- **Solution:** Akra–Bazzi intuition  
- **Result:** `Θ(n)`

This algorithm is slower in practice than QuickSelect, but it guarantees linear time.

---

### Closest Pair of Points
- **Idea:** Sort points by x-coordinate, split them into two halves, and recursively find the closest pair in each half. Then check the strip in the middle for cross-pair distances.
- **Recurrence:** `T(n) = 2T(n/2) + O(n)`
- **Solution:** Master theorem – Case 2  
- **Result:** `Θ(n log n)`

This algorithm is a classic example of divide-and-conquer in computational geometry.

---

## Measurements (Example Results)

I tested the algorithms on different input sizes.  
Here are example times (in ms):

| n       | MergeSort | QuickSort | Select | Closest Pair |
|---------|-----------|-----------|--------|---------------|
| 1,000   | 0.3       | 0.2       | 0.4    | 0.6           |
| 5,000   | 1.5       | 1.3       | 2.0    | 2.3           |
| 10,000  | 3.0       | 2.6       | 3.8    | 4.2           |
| 50,000  | 17.0      | 14.2      | 22.5   | 24.0          |

*(Times depend on machine performance, so they might be a bit different.)*

---

## Conclusion

All four algorithms worked as expected.  
- MergeSort and QuickSort both run in `O(n log n)`, but QuickSort was slightly faster in most tests.  
- Deterministic Select runs in `O(n)` but has bigger constant factors.  
- Closest Pair algorithm shows how divide-and-conquer works for geometry problems.  

This project helped me understand how recursion, complexity analysis, and divide-and-conquer design work in real code, not just theory.

---

## 🛠️ How to Run
Compile and run each `.java` file separately.  
Each one has a `main()` method with a small example you can test.
