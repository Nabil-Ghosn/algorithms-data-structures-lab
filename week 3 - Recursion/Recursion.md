# **Lab Session: Understanding Recursion in Algorithms**

## **Session Overview**

**Duration**: 90 minutes  
**Audience**: $2^{nd}$ year, $1^{st}$ semester students, Intermediate level  
**Session Type**: Practical lab  
**Session Number**: 3  
**Focus**: Introduction to Recursion in Algorithms and Data Structures  
**Lecturer**: Nabil Ghosn

---

## **Learning Objectives**

By the end of this session, students should be able to:

- Define recursion and understand how recursive functions work.
- Distinguish between recursive and iterative approaches and understand when to use each.
- Apply recursion in fundamental problems like calculating powers, Fibonacci sequences, GCD, and factorial.
- Understand and analyze the memory stack behavior during recursion.
- Use recursion techniques such as Divide and Conquer and Decrease and Conquer approaches.
- Recognize when memoization can optimize recursive functions.

---

## **Session Outline**

### **1. Introduction to Recursion (10 Minutes)**

- **Definition of Recursion**:  
  Recursion is a method in which a function calls itself to solve a smaller instance of the same problem until reaching a base case, which terminates the recursive calls. Recursion is commonly used for problems that can be broken down into smaller, similar subproblems.

- **How Recursion Works**:  
  In recursion, each function call is pushed onto the **stack memory**, which stores information for each call until the base case is reached. When a base case is encountered, the calls begin to resolve in a **last-in, first-out** manner, similar to stacking and unstacking plates.

- **Example**: (Factorial)
  - The mathematical definition:
    > $n!=n×(n-1)!$ where $0!=1$.
  - The two main parts of a recursive function:
    - **Base Case**: The condition under which the function stops calling itself. For the factorial function, it's $n=0.$
    - **Recursive Case**: The part where the function calls itself with a simpler problem. For the factorial function, it's $n×factorial(n-1)$.

---

### **2. Recursive vs Iterative Approaches (10 Minutes)**

#### Comparison

- **Recursive Approach**:
  - Often simpler and closer to the problem's natural structure.
  - Can lead to high memory usage due to multiple function calls on the stack.
  - Example: Calculating factorial recursively.
- **Iterative Approach**:
  - Uses loops instead of function calls, leading to lower memory overhead.
  - Can be more efficient in terms of space but may not always be as intuitive.
  - Example: Calculating factorial using a loop.

```java
// Recursive factorial
int factorial(int n) {
    if (n == 0) return 1;
    return n * factorial(n - 1);
}

// Iterative factorial
int factorialIterative(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

---

### **3. Exploring Divide and Conquer & Decrease and Conquer (15 Minutes)**

#### **Divide and Conquer**

- **Definition**: Divide the problem into smaller subproblems, solve each recursively, and then combine results. Useful in sorting and searching algorithms (e.g., Merge Sort).
- **Example**: Calculating the power of a number (e.g., `2^n`)

```java
// Power function using Divide and Conquer
int powerDivideConquer(int base, int exponent) {
    if (exponent == 0) return 1;
    int halfPower = powerDivideConquer(base, exponent / 2);
    if (exponent % 2 == 0) return halfPower * halfPower;
    else return base * halfPower * halfPower;
}
```

- **Complexity**: $O(log_2(n))$

#### **Decrease and Conquer**

- **Definition**: Reduce the problem by a constant amount (often by 1), solve the smaller problem, then extend the solution to the larger problem.
- **Example**: Calculating the power of a number using decremental recursion.

```java
// Power function using Decrease and Conquer
int powerDecreaseConquer(int base, int exponent) {
    if (exponent == 0) return 1;
    return base * powerDecreaseConquer(base, exponent - 1);
}
```

- **Complexity**: $O(n)$

#### **Iterative**

- **Definition**: Solve the problem using loops instead of recursion. This approach typically involves initializing a result and iteratively updating it.

- **Example**: Calculating the power of a number iteratively (e.g., (a^n))

```java
int powerIterative(int base, int exponent) {
    int result = 1;
    while (exponent > 0) {
        result *= base;
        exponent--;
    }
    return result;
}
```

- **Complexity**: $O(n)$

---

### **4. Examples of Recursion (20 Minutes)**

#### General Form for a recursive function with a complexity of $O(K^n)$

- **Explanation**:
  1. **Base Case:** The function checks if $n$ is 0 (or any other base case condition) and returns a constant value.
  2. **Recursive Case:** The function makes $K$ recursive calls to itself with the argument $n-1$. The variable `K` represents the number of recursive calls made at each level.
  3. **Combining Results:** The results of the $K$ recursive calls are combined. In this example, they are summed up, but the combination method can vary based on the specific problem.

- **Complexity**: the function has an exponential time complexity of $O(K^n)$, as each call to `recursiveFunction` generates $K$ additional calls, leading to exponential growth in the number of calls as $n$ increases.

```java
int recursiveFunction(int n) {
    // Base case
    if (n == 0) {
        return 1; // or any constant value depending on the problem
    }
    // Recursive case
    int result = 0;
    for (int i = 0; i < K; i++) {
        result += recursiveFunction(n - 1);
    }
    return result;
  }
```

#### Printing in Recursion (Simple Output Example)

- **Task**: Write a recursive function to print numbers from 1 to `n`.

```java
void printNumbers(int n) {
    if (n == 0) return;
    printNumbers(n - 1);
    System.out.print(n + " ");
}
// Expected Output for n = 5: 1 2 3 4 5
```

#### Fibonacci Sequence

- **Definition**: A sequence where each number is the sum of the two preceding ones, starting with 0 and 1.
- **Recursive Approach**:

```java
int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}
// Time Complexity: O(2^n)
```

#### Greatest Common Divisor (GCD)

- **Definition**: The largest integer that divides two numbers without leaving a remainder.
- **Euclidean Algorithm (Recursive)**:

```java
int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
// Time Complexity: O(log(min(a, b)))
```

- **Explaination**:
To understand the mathematical explanation of the `gcd` (Greatest Common Divisor) function and its time complexity, let's break it down step by step:
  1. **Base Case:** If $( b = 0 )$, then $( gcd(a, b) )$ is simply (a) because the GCD of (a) and 0 is (a).
  2. **Recursive Case:** If $(b \neq 0)$, the algorithm recursively calls `gcd(b, a % b)`, where (a % b ) is the remainder of (a) divided by (b).
  
  To see how it works, consider ( gcd(48, 18) ):
    1. $gcd(48, 18)$
    2. Calculate $(48\%18=12)$ ⇒ $gcd(48, 18) = gcd(18, 12)$
    3. $gcd(18, 12)$
    4. Calculate $(18\%12=6)$ ⇒ $gcd(18, 12) = gcd(12, 6)$
    5. $gcd(12, 6)$
    6. Calculate $( 12 \% 6 = 0 )$ ⇒ $gcd(12, 6) = gcd(6, 0)$
    7. Base case reached: $( gcd(6, 0) = 6 )$
  So, $gcd(48, 18)= 6$.

#### **Binary Search**

- **Definition**: A search algorithm that finds the position of a target value within a sorted array. It compares the target value to the middle element of the array and recursively halves the search space until the target value is found or the search space is empty.
- **Binary Search (Recursive)**:

```java
int binarySearch(int[] array, int target, int low, int high) {
    if (low > high) return -1; // Base case: Target not found

    int mid = low + (high - low) / 2; // Find the middle index

    if (array[mid] == target) return mid; // Base case: Target found
    else if (array[mid] > target) return binarySearch(array, target, low, mid - 1); // Search in the left half
    else return binarySearch(array, target, mid + 1, high); // Search in the right half
}
// Time Complexity: O(log n)
```

- **Explanation**:
To understand the binary search function and its time complexity, let's break it down step by step:
  1. **Base Case:** If $(low > high)$, return -1, indicating the target is not found in the array.
  2. **Base Case:** If $(array[mid] == target)$, return the index $(mid)$, indicating the target is found.
  3. **Recursive Case:** If $(array[mid] > target)$, recursively search the left half of the array.
  4. **Recursive Case:** If $(array[mid] < target)$, recursively search the right half of the array.

  To see how it works, consider searching for the target value 7 in the array [1, 3, 5, 7, 9, 11]:
    1. `binarySearch([1, 3, 5, 7, 9, 11], 7, 0, 5)`
    2. Calculate $mid = 0 + (5 - 0) / 2 = 2$ ⇒ `array[2] = 5`
    3. Since 7 > 5, search in the right half: `binarySearch([1, 3, 5, 7, 9, 11], 7, 3, 5)`
    4. Calculate $mid = 3 + (5 - 3) / 2 = 4$ ⇒ `array[4] = 9`
    5. Since 7 < 9, search in the left half: `binarySearch([1, 3, 5, 7, 9, 11], 7, 3, 3)`
    6. Calculate $mid = 3 + (3 - 3) / 2 = 3$ ⇒ `array[3] = 7`
    7. Target found: return index 3

---

### **5. Understanding Memory Stack and Recursion (10 Minutes)**

- **Stack vs Heap Memory**:
  - Stack: Memory where local variables and function calls are stored. Grows with each recursive call, which can lead to **stack overflow** if recursion depth is too large.
  - Heap: Used for dynamic memory allocation, often by data structures like arrays and objects.
  
- **What Happens in Stack During Recursion**:
  - Each recursive call adds a new stack frame containing its variables and return address.
  - On reaching the base case, each stack frame is popped in reverse order of addition, returning values in a **last-in, first-out** manner.

---

### **6. Memoization to Optimize Recursive Functions (10 Minutes)**

- **Definition**: Memoization stores the results of expensive function calls and reuses them when the same inputs occur again, reducing redundant computations.
- **Example**: Optimizing Fibonacci with Memoization.

```java
int[] memo = new int[n + 1];

int fibonacciMemo(int n) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];
    memo[n] = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
    return memo[n];
}
// Time Complexity: O(n)
```

---

### **7. Real-World Applications of Recursion (5 Minutes)**

- **File Systems**: Traversing folders and subfolders uses recursive approaches.
- **Pathfinding Algorithms**: Recursive algorithms help find paths in grid-based games or maps.
- **Graphics**: Recursive algorithms generate fractal images and handle divide-and-conquer graphics rendering.

---

### **8. Summary and Q&A (5 Minutes)**

Summarize key points:

- What recursion is and how it works.
- When to use recursive versus iterative approaches.
- Understanding Divide and Conquer, Decrease and Conquer, and the impact on memory stack.
- Memoization as an optimization.

---

### **Additional Resources**

- Geeks for Geeks [recursion](https://www.geeksforgeeks.org/introduction-to-recursion-2/), [divide and conquer](https://www.geeksforgeeks.org/divide-and-conquer/), [decrease and conquer](https://www.geeksforgeeks.org/decrease-and-conquer/)
- Suggested practice on recursive problems on LeetCode and HackerRank.
