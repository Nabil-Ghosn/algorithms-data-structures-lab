# **Lab Session: Backtracking**

## **Session Overview**

**Duration**: 90 minutes  
**Audience**: $2^{nd}$ year, $1^{st}$ semester students, Intermediate level  
**Session Type**: Practical lab  
**Session Number**: 5  
**Focus**: Backtracking as a problem-solving strategy and its connection to Dynamic Programming  
**Lecturer**: Nabil Ghosn

---

## **Learning Objectives**

By the end of this session, students should be able to:

- Understand the concept and working principle of **Backtracking**.
- Implement recursive solutions using backtracking.
- Compare backtracking with dynamic programming (top-down and bottom-up approaches).
- Solve exercises involving backtracking and dynamic programming.

---

## **Session Outline**

### **1. Introduction to Backtracking (15 minutes)**

#### **Backtracking Definition**

Backtracking is a problem-solving algorithmic technique that involves finding a solution incrementally by trying different options and undoing them if they lead to a dead end. It is commonly used in situations where multiple possibilities need to be explored to solve a problem, such as solving puzzles like Sudoku.

Backtracking uses recursion to explore possibilities by breaking down problems into smaller subproblems and systematically trying out different choices.

#### **Algorithm Template:**

```java
void FIND_SOLUTIONS(parameters):
    if (valid solution):
        store the solution
        return
    for (all choices):
        if (valid choice):
            APPLY(choice)
            FIND_SOLUTIONS(parameters)
            BACKTRACK(remove choice)
    return
```

#### **Problem Categories in Backtracking:**

1. **Decision Problems**: Finding a feasible solution (e.g., Does a solution exist?).
2. **Optimization Problems**: Finding the best solution (e.g., What is the optimal solution?).
3. **Enumeration Problems**: Generating all feasible solutions (e.g., How many solutions exist?).

#### **Time Complexity:**

Let's say there are n steps (decisions to make), and at each step, you have k choices.

To find the total number of possible combinations, you multiply the choices at each step:

Total Possibilities = k \* k \* k \* ... (n times) = $k^n$

Exponential Growth: The time complexity of backtracking is typically $O(k^n)$ because you have to explore all possible combinations of choices.

---

### **2. Backtracking vs. Dynamic Programming (15 minutes)**

**Dynamic Programming (DP)** solves complex problems by breaking them down into simpler subproblems and storing the results to avoid redundant computations.

- **Top-Down Approach (Memorization):** Solves the problem recursively and stores results in a memorization table to avoid recalculating the same subproblem multiple times.

- **Bottom-Up Approach (Tabulation):** Starts with solving the smallest subproblems first and uses their results to iteratively build up solutions for larger subproblems.

### When to Choose Backtracking vs Dynamic Programming

- **Backtracking** is ideal when the problem requires exploring all possible solutions (e.g., decision or enumeration problems) and doesn't have overlapping subproblems (when solving subproblems separately doesn’t necessarily help solve the larger problem optimally).
- **Dynamic Programming** is more efficient for problems with overlapping subproblems and optimal substructure, such as optimization problems (e.g., shortest path, LIS).

**Example Analogy:**
Think of backtracking as exploring a maze where you systematically try every path and backtrack if you hit a dead end. Dynamic programming, on the other hand, is like using a map of the maze to avoid revisiting the same sections unnecessarily, thus saving time and effort. Solves smaller subproblems first and combines their results.

**Comparison Table:**

| Property     | Backtracking               | Dynamic Programming                       |
| ------------ | -------------------------- | ----------------------------------------- |
| Nature       | Recursive, tries all paths | Recursive/Iterative, avoids recomputation |
| Memory Usage | Stack frames (recursion)   | Array/table (memoization/tabulation)      |
| Efficiency   | Exponential (worst-case)   | Polynomial (if overlapping subproblems)   |
| Example      | N-Queens, Sudoku           | Longest Increasing Subsequence (LIS)      |

---

### **3. Exercises (50 minutes)**

#### **Exercise 1: Generate n-bit Gray Codes (Backtracking)**

**Problem:** Generate all possible n-bit Gray Codes using backtracking.

**Link**: [Generate n-bit Gray Codes](https://www.geeksforgeeks.org/backtracking-approach-generate-n-bit-gray-codes/)

**Explanation**:

- **Exploration**: The function tries adding both `"0"` and `"1"` to build all possible combinations.
- **Undoing (Backtracking)**: After exploring one path (e.g., adding `"0"`), the function **backtracks** (returns) and explores the other path (adding `"1"`).

1. **Base Case**:
   - If `n` is `0`, print the result and stop the recursion.
2. **Recursive Case**:
   - The function makes two recursive calls:

   - One call adds `"0"` to the current result.

   - Another call adds `"1"` to the current result.

- **Code Implementation:**

```java
void generateGrayCode(int n, String result) {
    if (n == 0) {
        System.out.println(result);
        return;
    }
    generateGrayCode(n - 1, result + "0");
    generateGrayCode(n - 1, result + "1");
}
```

---

#### **Exercise 2: Solve Sudoku Using Backtracking**

**Problem:** Solve a 9x9 Sudoku puzzle using backtracking.

**Link**: [Solve Sudoku](https://www.geeksforgeeks.org/sudoku-backtracking-7/)

**Explanation:**

1. **Recursive Exploration:**
   - It moves cell by cell across the board.
   - If a cell is empty (`'?'`), it tries every number from `'1'` to `'9'`.
2. **Validation and Backtracking:**
   - For each number, it places the number and recursively attempts to solve the rest of the board.
   - If a solution is not found, it resets (backtracks) and tries the next number.
3. **Base Case:**
   - When it reaches the end of a row (`j == 9`), it moves to the next row.
   - When it reaches the end of the board (`i == 9`), it checks if the board is valid and prints it if so.

**Code Implementation:**

```java
public class Main
{
    void solveSudoku(char[][] board, int i, int j) {
        if (j == 9) {
            solveSudoku(board, i+1, 0);
            return;
        }
        if (i == 9) {
            if (check(board))
                printBoard(board);
            return;
        }
        if (board[i][j] != '?') {
            solveSudoku(board, i, j+1);
            return;
        }
        for (char k = '1'; k <= '9'; k++) {
            board[i][j] = k;
            solveSudoku(board, i, j+1);
        }
        board[i][j] = '?';
    }

    static boolean check(char[][] board) {
        // Create arrays to check rows, columns, and subgrids
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][][] subgrids = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '?') {
                    int num = board[i][j] - '1'; // convert char to index (0-8)

                    // Check the row
                    if (rows[i][num]) {
                        return false;
                    }
                    rows[i][num] = true;

                    // Check the column
                    if (cols[j][num]) {
                        return false;
                    }
                    cols[j][num] = true;

                    // Check the subgrid
                    int subgridRow = i / 3;
                    int subgridCol = j / 3;
                    if (subgrids[subgridRow][subgridCol][num]) {
                        return false;
                    }
                    subgrids[subgridRow][subgridCol][num] = true;
                }
            }
        }
        return true;
    }

    static void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
                if (j%3 == 2)
                    System.out.print("  ");
            }
            System.out.println();
            if (i%3 == 2)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {
            {'?', '3', '4', '6', '7', '8', '9', '1', '2'},
            {'6', '7', '2', '1', '9', '5', '3', '4', '8'},
            {'1', '9', '8', '3', '4', '2', '5', '6', '7'},
            {'8', '5', '9', '7', '6', '1', '4', '2', '3'},
            {'4', '2', '6', '8', '5', '3', '7', '9', '1'},
            {'7', '1', '3', '9', '2', '4', '8', '5', '6'},
            {'9', '6', '1', '5', '3', '7', '2', '8', '4'},
            {'2', '8', '7', '4', '1', '9', '6', '3', '5'},
            {'3', '4', '5', '2', '8', '6', '1', '7', '9'}
        };
        solveSudoku(board, 0, 0);
    }
}
```

---

#### **Exercise 3: Longest Increasing Subsequence (LIS)**

Solve the **Longest Increasing Subsequence** problem in three different ways:

**1. Backtracking Approach:**

**Explanation:**

1. **Base Case**:
   - When `i` reaches the end of the array (`i == arr.length`), it returns 0, signifying no more elements to consider.

2. **Exclude the Current Element**:
   - `exclude` stores the result of recursively calling `backtrackLIS` by moving to the next element (`i+1`) without including the current element `arr[i]`.

3. **Include the Current Element**:
   - `include` stores the result of recursively calling `backtrackLIS` by moving to the next element (`i+1`) and including the current element `arr[i]` if it is greater or equal to the previous element `arr[j]`. This adds 1 to the result, indicating inclusion.

4. **Backtracking**:
   - The function returns the maximum of `include` and `exclude`, ensuring all paths are explored and the longest subsequence is found.

**Code Implementation:**

```java
int backtrackLIS(int[] arr, int i, int j) {
    if (i == arr.length) return 0;
    int exclude = backtrackLIS(arr, i+1, j);
    int include = 0;
    if (arr[i] >= arr[j]) {
        include = backtrackLIS(arr, i+1, i) + 1;
    }
    return Math.max(include, exclude);
}
```

**2. Top-Down DP (Memoization):**

Optimizes backtracking by storing and reusing results of subproblems, reducing redundant work and improving efficiency.

**Explanation:**

- **Memoization Table**:
  - Uses a table `dp` to store results of subproblems to avoid redundant calculations. initialized to `-1`.
- **Memoized Results**:
  - If the result for `(i, j)` is already computed (`dp[i][j] != -1`), it returns the stored value.
- **Update Memoization Table**:
  - Stores the result of `Math.max(include, exclude)` in `dp[i][j]` to use later.

**Code Implementation:**

```java
int topDownLIS(int[] arr, int i, int j) {
    if (dp[i][j] != -1) return dp[i][j];
    if (i == arr.length) return 0;
    int exclude = topDownLIS(arr, i+1, j);
    int include = 0;
    if (arr[i] >= arr[j]) {
        include = topDownLIS(arr, i+1, i) + 1;
    }
    dp[i][j] = Math.max(include, exclude);
    return dp[i][j];
}
```

**3. Bottom-Up DP (Tabulation):**

Builds the solution from the ground up by solving smaller subproblems and combining their solutions to solve larger subproblems.

See this video to understand the solution: [Longest Increasing Subsequence](https://www.youtube.com/watch?v=CE2b_-XfVDk)

**Explanation:**

1. **Initialization**:
   - Create a `dp` array where each element starts as 1, representing the longest increasing subsequence ending at each element.

2. **Iterate Through Elements**:
   - For each element `arr[i]` (starting from the second element), look back at all previous elements `arr[j]` (where `j < i`).
   - If `arr[i] > arr[j]`, it means `arr[i]` can extend the subsequence ending at `arr[j]`.

3. **Update DP Array**:
   - For each valid pair (`arr[i] > arr[j]`), update `dp[i]` to be `Math.max(dp[i], dp[j] + 1)`. This accounts for including `arr[j]` in the subsequence ending at `arr[i]`.

4. **Find Maximum Length**:
   - After filling the `dp` array, traverse it to find the maximum value, which represents the length of the LIS.

**Code Implementation:**

```java
int bottomUpLIS(int[] arr) {
    int n = arr.length;
    int[] dp = new int[n];
    Arrays.fill(dp, 1);

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
    }

    int maxLength = 0;
    for (int val : dp) 
        maxLength = Math.max(maxLength, val);
    return maxLength;
}
```

This method ensures an optimal solution with a time complexity of $O(n^2)$, where `n` is the length of the array.

---

### **4. Summary and Q&A (5 minutes)**

- **Key Points:**
  - Backtracking systematically explores solutions.
  - Dynamic Programming avoids recomputation using memoization/tabulation.

---

### **Additional Resources**

- [Backtracking Overview](https://www.geeksforgeeks.org/backtracking-algorithms/)
- [Gray Code Generation](https://www.geeksforgeeks.org/backtracking-approach-generate-n-bit-gray-codes/)
- [Sudoku Solver](https://www.geeksforgeeks.org/sudoku-backtracking-7/)
- [Longest Increasing Subsequence](https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/)
