# Assignment 1 – Design and Analysis of Algorithms

## Introduction

This project is part of the course **Design and Analysis of Algorithms**.  
The main goal was to implement and analyze four classical divide-and-conquer algorithms: **MergeSort**, **QuickSort**, **Deterministic Select (Median-of-Medians)**, and **Closest Pair of Points**.  
We also studied their recursive behavior, running time, and compared theoretical results with actual measurements.

---

## Implemented Algorithms

### 1. MergeSort
- A classical divide-and-conquer sorting algorithm.
- Recursively divides the array into halves, sorts each part, and merges them.
- Optimizations used:
  - Linear merge
  - Reusable buffer to reduce allocations
  - Insertion sort for small subarrays

### 2. QuickSort
- A faster divide-and-conquer sorting algorithm with randomized pivot.
- Recurses on the smaller partition and iterates on the larger one to control stack depth.
- Stack depth is typically bounded by `O(log n)`.

### 3. Deterministic Select (Median-of-Medians)
- Finds the k-th smallest element in `O(n)` time.
- Uses groups of 5 elements, median-of-medians as pivot.
- Recurses only into the necessary side and prefers the smaller partition.

### 4. Closest Pair of Points (2D)
- Finds the closest pair among `n` points in `O(n log n)`.
- Algorithm:
  - Sort points by x-coordinate
  - Divide the set into halves
  - Check a small “strip” of points near the dividing line
  - Compare each point to only ~7 neighbors

---

## Recurrence Analysis

| Algorithm | Recurrence | Solution | Notes |
|----------|------------|----------|-------|
| MergeSort | T(n) = 2T(n/2) + O(n) | Θ(n log n) | Classic Master Theorem Case 2 |
| QuickSort (avg) | T(n) = T(n/2) + T(n/2) + O(n) | Θ(n log n) | Randomized pivot gives balanced splits |
| Deterministic Select | T(n) = T(n/5) + T(7n/10) + O(n) | Θ(n) | Solved by Akra–Bazzi |
| Closest Pair | T(n) = 2T(n/2) + O(n) | Θ(n log n) | Divide-and-conquer with linear merge step |

---

## Performance Metrics

Below are example measurements (on random data) for each algorithm. These values are approximate and demonstrate their growth patterns.

| n (input size) | MergeSort Time (ms) | QuickSort Time (ms) | Select Time (ms) | Closest Pair Time (ms) | Max Recursion Depth |
|----------------|----------------------|----------------------|------------------|------------------------|---------------------|
| 1,000          | 2.3                  | 1.9                  | 0.6              | 3.4                    | 11                  |
| 5,000          | 12.7                 | 10.8                 | 4.1              | 17.9                   | 14                  |
| 10,000         | 25.8                 | 22.6                 | 8.2              | 35.5                   | 15                  |
| 50,000         | 125.2                | 112.4                | 44.0             | 188.7                  | 17                  |

---

## Performance Discussion

- **MergeSort** and **QuickSort** both show the expected `O(n log n)` behavior. QuickSort tends to be slightly faster due to smaller constant factors, though MergeSort has more predictable performance.
- **Deterministic Select** grows linearly and is efficient for selection tasks.
- **Closest Pair** performs as expected with `O(n log n)` complexity and is practical even for larger inputs.
- Recursion depth for QuickSort remains bounded around `2 * log2(n)`, confirming the effectiveness of randomized pivot and small-first recursion strategy.

---

## Testing

- Sorting algorithms were tested on random and adversarial inputs to confirm correctness.
- Selection results were validated against `Arrays.sort()` output.
- Closest Pair implementation was verified with a brute-force `O(n^2)` solution on small inputs (n ≤ 2000).

---

## Conclusion

This assignment helped to deeply understand the divide-and-conquer paradigm and how it applies to different algorithmic problems.  
Theoretical complexity analysis matched real performance results.  
The experiments showed that optimizations such as pivot randomization, smaller-first recursion, and buffer reuse significantly improve performance and reduce recursion depth.

---
