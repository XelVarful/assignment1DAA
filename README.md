Assignment 1 Report: Divide and Conquer Algorithms
📌 Project Goal

This project implements four classical algorithms using the Divide and Conquer paradigm. The main goals are to understand their architecture, control recursion depth, analyze time complexity, and compare theoretical expectations with real-world performance.

🧠 Implemented Algorithms
1. MergeSort — Merge Sorting (Master Theorem — Case 2)

The algorithm recursively splits the array, sorts both halves, and merges them.

Uses insertion sort for small subarrays (cut-off optimization).

Reuses a buffer to reduce memory allocations.

Complexity: Θ(n log n)
Recursion depth: O(log n)

2. QuickSort — Optimized Quick Sort

A randomized pivot minimizes the risk of worst-case scenarios.

Recursion always processes the smaller partition first; the larger part is handled iteratively to keep the call stack shallow.

Complexity: Θ(n log n)
Recursion depth: ≲ 2·log₂(n)

3. Deterministic Select — k-th Order Statistic (Median of Medians)

Finds the k-th smallest element in linear time.

Uses groups of 5 and selects the median of medians as the pivot.

Recurses only into the relevant partition.

Complexity: Θ(n)
Recursion depth: O(log n)

4. Closest Pair of Points — 2D Closest Pair

Points are sorted by x-coordinate, split recursively, and a “strip” region is checked for nearby points.

Only 7–8 neighbors need to be examined in the y-sorted list.

Complexity: Θ(n log n)
Recursion depth: O(log n)

📊 Recurrence Analysis (Master Theorem / Akra–Bazzi)
Algorithm	Recurrence	Method	Complexity
MergeSort	T(n) = 2T(n/2) + Θ(n)	Master Case 2	Θ(n log n)
QuickSort	T(n) = T(n/2) + T(n/2) + Θ(n)	Master Case 2	Θ(n log n)
Select	T(n) = T(n/5) + T(7n/10) + Θ(n)	Akra–Bazzi	Θ(n)
Closest Pair	T(n) = 2T(n/2) + Θ(n)	Master Case 2	Θ(n log n)
📈 Measurement Results

Execution time and recursion depth grow logarithmically, as expected.

Constant factors affect performance: insertion sort improves MergeSort, and random pivot selection speeds up QuickSort.

Differences between theory and practice become negligible for large inputs.

📜 Conclusion

All four algorithms match their theoretical complexity. With careful handling of recursion depth and memory allocation, the implementations are efficient, stable, and performant.
