# **Lab Session: Introduction to Algorithms and Time Complexity**

## **Session Overview**

**Duration**: 90 minutes  
**Audience**: $2^{nd}$ year, $1^{st}$ semester students, Intermediate level  
**Session Type**: Practical lab  
**Session Nunmer**: 1  
**Focus**: Introduction to Algorithms with a focus on time complexity  
**Lecturer**: Nabil Ghosn  

---

## **Learning Objectives**

By the end of this session, students should be able to:

- Define an algorithm and understand its key characteristics.
- Explain the purpose of algorithm analysis and time complexity.
- Identify and calculate time complexity using Big O notation.
- Compare different algorithms for solving the same problem and understand why optimization is important.
- Apply time complexity analysis to simple pseudocode examples.
- Recognize real-world applications of time complexity in computer science and engineering.

---

## **Session Outline**

### **1. Introduction to Algorithms (15 Minutes)**

#### **Definition and Characteristics**

<!-- https://media.geeksforgeeks.org/wp-content/cdn-uploads/20191016135223/What-is-Algorithm_-1024x631.jpg -->

<!-- https://media.geeksforgeeks.org/wp-content/cdn-uploads/20191016135220/Characteristics-of-an-Algorithm-1024x630.jpg -->

<!-- https://media.geeksforgeeks.org/wp-content/uploads/20240902185521/Linear-search-algorithm-1.webp -->

| What is Algorithm | Characteristics of an Algorithm | Example |
| ----------------- | ------------------------------- | ------- |
|![What-is-Algorithm](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20191016135223/What-is-Algorithm_-1024x631.jpg) | ![Characteristics-of-an-Algorithm](https://media.geeksforgeeks.org/wp-content/cdn-uploads/20191016135220/Characteristics-of-an-Algorithm-1024x630.jpg)| ![Linear-search-algorithm-1](https://media.geeksforgeeks.org/wp-content/uploads/20240902185521/Linear-search-algorithm-1.webp) |

```java
// Java code for linearly searching x in arr[].

import java.io.*;

class GFG {
    public static int search(int arr[], int N, int x)
    {
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;

        // Function call
        int result = search(arr, arr.length, x);
        if (result == -1)
            System.out.print(
                "Element is not present in array");
        else
            System.out.print("Element is present at index "
                             + result);
    }
}

```

**Definition**: An algorithm is a finite set of instructions or a step-by-step process designed to perform a specific task or solve a problem.

**Characteristics**: For a set of instructions to be considered an algorithm, it should possess the following characteristics:

- Definiteness: Each step of the algorithm is clear and unambiguous.
- Finiteness: The algorithm completes after a finite number of steps.
- Input: Accepts zero or more inputs.
- Output: Produces at least one output.
- Effectiveness: Each operation must be basic enough to be performed exactly within a finite time.

**One problem - Many Solutions**: An algorithm becomes essential when there is more than one possible solution for the same problem. The goal of algorithm design is often to find the most efficient solution, prompting the question: **Can we do better?**

- evaluate the efficiency of the algorithms
- compare them (trade-off)

---

### **2. Introduction to Time Complexity and Big O Notation (10 Minutes)**

#### **Complexity Definition**

- Time Factor: Time is measured by counting the number of key operations such as comparisons in the sorting algorithm.
- Space Factor: Space is measured by counting the maximum memory space required by the algorithm to run/execute.

#### **Why Analyze Algorithms?**

When designing algorithms, we need to understand how well they perform, especially in terms of efficiency. This is often evaluated by analyzing two main cases: (explain from linear search example)

- Worst-case analysis: Assesses the maximum time an algorithm could take. It’s the most common analysis type because it provides a guarantee of performance.
- Average-case analysis: Estimates the time taken on average, which requires domain-specific knowledge and is sometimes less predictable.

The primary focus in algorithm analysis is often on worst-case performance. This is because it ensures that the algorithm will perform within a certain limit, regardless of the input.

#### **Big O Notation**

Big O notation describes an upper bound on the time complexity of an algorithm. If an algorithm has time complexity $ T(n) $, we say $ T(n) = O(f(n)) $ if there exists a constant $ c $ such that:

$$ T(n) \leq c \times f(n) \quad \text{for large enough } n $$

For example:

- If $ T(n) = 4n^2 + \log_2(n) + n $, we find the highest order term (in this case, $n^2$), so $T(n) = O(n^2)$.

In algorithm design, we frequently focus on the "rank" or order of growth of an algorithm, rather than the exact number of operations. This approach is known as asymptotic analysis.

Why Big O Notation?

- **Simplification**: It's much simpler for algorithms to focus on high-level design.
- **High-level focus**: Constants vary based on architecture, compiler, and programmer.
- **Scalability**: It becomes crucial when dealing with large inputs.

For example, if two algorithms both process large inputs but one scales quadratically while the other scales linearly, the linear one will generally perform better on larger inputs, despite specific constant factors.

<!-- https://www.codevivek.com/a-gentle-intro-to-big-oh-notations/biigeoh.png -->

![a-gentle-intro-to-big-oh-notations/biigeoh](https://www.codevivek.com/a-gentle-intro-to-big-oh-notations/biigeoh.png)

---

### **3. Hands-On Exercises (10-15 Minutes): Time Complexity Analysis**

Each exercise below includes pseudocode, followed by questions to analyze time complexity.

#### **Exercise 1: Counting Elements in a List**

- **Pseudocode**:

  ```python
  def print_elements(arr):
      for element in arr:
          print(element)
  ```

- **Questions**:
  1. What is the time complexity of this function? _(Expected answer: `O(n)`)_
  2. Why is it considered linear?

---

#### **Exercise 2: Simple Nested Loops**

- **Pseudocode**:

  ```python
  def has_common_elements(arr1, arr2):
      for element1 in arr1:
          for element2 in arr2:
              if element1 == element2:
                  return True
      return False
  ```

- **Questions**:
  1. What is the time complexity of this function? _(Expected answer: `O(n^2)`)_
  2. Explain why this is quadratic.

---

#### **Exercise 3: Duplicate Check in an Array**

- **Pseudocode**:

  ```python
  def has_duplicates(arr):
      for i in range(len(arr)):
          for j in range(i + 1, len(arr)):
              if arr[i] == arr[j]:
                  return True
      return False
  ```

- **Questions**:
  1. What is the time complexity of this function? _(Expected answer: `O(n^2)`)_
  2. Why is it quadratic, and what might happen as `arr` grows?

---

#### **Exercise 4: Comparing Linear vs. Binary Search**

- **Linear Search**:

  ```python
  def linear_search(arr, target):
      for element in arr:
          if element == target:
              return True
      return False
  ```

- **Binary Search (Assumes Sorted List)**:

  ```python
  def binary_search(arr, target):
      left, right = 0, len(arr) - 1
      while left <= right:
          mid = (left + right) // 2
          if arr[mid] == target:
              return True
          elif arr[mid] < target:
              left = mid + 1
          else:
              right = mid - 1
      return False
  ```

- **Questions**:
  1. What is the time complexity of each algorithm? _(Expected answer: `O(n)` for linear, `O(log n)` for binary)_
  2. Which search would be faster for large, sorted lists and why?

---

#### **Exercise 5: Matrix Multiplication**

- **Pseudocode**:

  ```python
  def matrix_multiply(A, B):
      n = len(A)
      C = [[0] * n for _ in range(n)]
      for i in range(n):
          for j in range(n):
              for k in range(n):
                  C[i][j] += A[i][k] * B[k][j]
      return C
  ```

- **Questions**:
  1. What is the time complexity of matrix multiplication using this algorithm? _(Expected answer: `O(n^3)`)_
  2. Discuss why matrix multiplication is computationally expensive for large matrices.

---

### **4. Other Examples (30-35 Minutes)**

#### **Example 1**
  
  ```c++
  int j=0;
  for(int i=0;i<n;i++)
    for( ;j<=i;j++)
  ```

- **Complexity**: $O(n)$

---

#### **Example 2**
  
  ```c++
  for(int i=0;i<n;i++)
    for(int j=0;j<n;j*=2)
  ```

- **Complexity**: $O(\infty)$
  
---

#### **Example 3**
  
  ```c++
  for(int i=1;i<n;i*=2)
  ```

- **Complexity**: $O(log_2(n))$

- **explaination**:
  
  - $i=1,2,4,..,n,=2^0,2^1,2^2,..,2^k$  
  - $T(n) = k+1$ where $2^𝑘≥𝑛$  
  - To find k:
    - $2^k=n$  
    - $k=log_2(n)$
    - $T(n) = log_2(n) + 1$

---

#### **Example 4**
  
  ```c++
  for(int i=0;i<n;i++)
    for(int j=1;j<n;j*=2)
  ```

- **Complexity**: $O(n*log_2(n))$

---

#### **Example 5**
  
  ```c++
  for(int i=0;i<n;i++){ 
    for(int j=0;j<n;j++) {
      if(rand()% 10==0)
        break;
      }
    }
  ```

- **Complexity**:
  - Best case: $
    O(1)$
  - Worst case: $O(n^2)$

---

#### **Example 6**
  
  ```c++
  int j=0;
  for(int i=0;i<n;i++){ 
    for( ;j<n;j++) {
      if( rand()% 10==0)
        break;
      }
    }
  ```

- **Complexity**: Worst case = Best case = $O(n)$

---

#### **Example 7**
  
  ```c++
  for(int i=0;i<log2(n);i++)
    for(int j=0; j<2^i;j++)
  ```

- **Complexity**: $O(n)$, $T(n) = ∑_{i=0}^{log_2(n)-1} 2^i = 2^{log_2(n)-1+1} − 1 = 2^{log_2(n)} − 1 = n - 1$

  > $∑_{i=0}^x 2^i = 2^{𝑥+1} − 1$

---

#### **Example 8**
  
  ```c++
  for(int i=0;i<n ; i ++)
    for(int j=0;j<m ; j ++)
  ```

- **Complexity**: $O(n.m)$ -> $O(n^2)$ when $ n ⋍m $

---

#### **Example 9**
  
  ```c++
  for(int j=0;j<n ; j++) { 
  } 
  for(int j=0;j<m ; j++){ 
  }
  ```
  
- **Complexity**: $O(n+m)$ -> $O(n)$ when $ n ⋍m $

---

### **5. Real-World Applications of Time Complexity (5 Minutes)**

- **Search Algorithms**: Explain that search algorithms are vital for databases, where efficient querying is essential as databases grow.
- **Data Processing in AI and ML**: Time complexity is crucial in AI algorithms, especially when handling large datasets for training models.
- **E-commerce Platforms**: Sorting and searching algorithms impact recommendation engines and inventory management in large-scale e-commerce.

---

### **6. Summary and Q&A (5-10 Minutes)**

- **Recap Key Points**: Briefly review algorithm definition, the concept of optimization, time complexity, and Big O notation.
- **Invite Questions**: Open the floor for questions to clarify any doubts or expand on topics students found intriguing.

---

### **Additional Resources**

- **Books**: "Introduction to Algorithms" by Cormen, Leiserson, Rivest, and Stein
- **Online Tutorials**: Coursera: Algorithms Specialization by Stanford University
- **Coding Practice Platform**: codeforces

---
