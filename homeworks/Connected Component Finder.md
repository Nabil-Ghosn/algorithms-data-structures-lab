# **Recursion Lab Homework: Connected Component Finder**

## **Objective:**

Implement a recursive algorithm to find all connected cells of the same color in a grid. You will use depth-first search (DFS) to traverse the grid and identify the connected component starting from a given cell.

## **Problem Statement:**

You are given a 2D grid \( G \), where each cell is represented by an object of the `Cell` class:

```java
class Cell {
    int color;
    boolean visited;
    int i, j; // Row and column indices
}
```

- Each cell has:
  - A `color` field representing its color.
  - A `visited` field indicating if the cell has been processed.
  - A `i,j` fields representing the cell indices in the grid \( G \).
- Starting from a given cell `(x, y)`, find all the connected cells (4-directionally: up, down, left, right) that have the same color as the starting cell. These connected cells form a "connected component".
- Mark the cells as visited during the traversal to avoid processing them multiple times.

## **Method Signatures:**

- **`boolean isValid(int i, int j, int col)`**: Check if the cell at position `(i, j)` can be added to the connected component.
- **`void findComponent(int i, int j)`**: Recursively traverse the grid and find all connected cells of the same color.

## **Instructions:**

1. Implement the methods `isValid` and `findComponent` in Java.
2. Use recursion in `findComponent` to explore the grid in all 4 directions.
3. Store the connected cells in a list and return it as the result of the traversal.
4. Don't alter anything in the code unless the required methods `isValid` and `findComponent`.
5. Get the code ready on your laptop for the next session.
6. If the term (DFS) scares you, ignore it and pretend it doesn't exist at all.

## **Examples:**

### **Input Grid:**

```text
Grid:
[
    [1, 1, 0],
    [1, 0, 0],
    [1, 1, 1]
]
Starting Cell: (0, 0)
```

### **Expected Output:**

```text
Connected Component:
[
    (0, 0),
    (0, 1),
    (1, 0),
    (2, 0),
    (2, 1),
    (2, 2)
]
```

### **Explanation:**

Starting from cell `(0, 0)`, the algorithm finds all connected cells with the same color (1). It stops at cells of different color or the boundary of the grid.

## **Starter Code:**

```java
import java.util.ArrayList;
import java.util.List;

class Cell {
    int color;
    boolean visited;
    int i, j; // Row and column indices

    public Cell(int color, int i, int j) {
        this.color = color;
        this.visited = false;
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "(" + i + ", " + j + ")";
    }
}

public class ConnectedComponent {

    static int n; // Number of rows
    static int m; // Number of columns
    static Cell[][] G; // The grid
    static List<Cell> connectedComponent;

    // Check if a cell is valid for inclusion in the connected component
    public static boolean isValid(int i, int j, int col) {
        // Add your implementation
        return false; // Placeholder
    }

    // Recursive method to find the connected component
    public static void findComponent(int i, int j) {
        // Add your implementation
    }

    // Helper method to reset the grid for a new test case
    public static void resetGrid(int[][] colors) {
        n = colors.length;
        m = colors[0].length;
        G = new Cell[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                G[i][j] = new Cell(colors[i][j], i, j);
            }
        }
        connectedComponent = new ArrayList<>();
    }

    // Helper method to get component indices and colors
    public static List<String> getComponentDetails() {
        List<String> result = new ArrayList<>();
        for (Cell cell : connectedComponent) {
            result.add(cell + ": " + cell.color); // Add position and color
        }
        return result;
    }

    // Assert method to check if test passes
    public static void assertTest(String testCaseName, List<String> actual, List<String> expected) {
        if (expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected)) {
            System.out.println(testCaseName + ": PASSED");
        } else {
            System.out.println(testCaseName + ": FAILED");
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + actual);
        }
    }

    // Main method to test the algorithm
    public static void main(String[] args) {
        // Test Case 1
        int[][] colors1 = {
            {1, 1, 0},
            {1, 0, 0},
            {1, 1, 1}
        };
        resetGrid(colors1);
        findComponent(0, 0);
        List<String> expected1 = List.of("(0, 0): 1", "(1, 0): 1", "(2, 0): 1", "(2, 1): 1", "(2, 2): 1", "(0, 1): 1");
        assertTest("Test Case 1", getComponentDetails(), expected1);

        // Test Case 2
        int[][] colors2 = {
            {3, 2, 2},
            {2, 3, 3},
            {2, 3, 3}
        };
        resetGrid(colors2);
        findComponent(1, 1);
        List<String> expected2 = List.of("(1, 1): 3", "(1, 2): 3", "(2, 1): 3", "(2, 2): 3");
        assertTest("Test Case 2", getComponentDetails(), expected2);

        // Test Case 3 (Single Cell Component)
        int[][] colors3 = {
            {4, 5, 6},
            {7, 8, 9},
            {8, 9, 8}
        };
        resetGrid(colors3);
        findComponent(1, 1);
        List<String> expected3 = List.of("(1, 1): 8");
        assertTest("Test Case 3", getComponentDetails(), expected3);
    }
}
```

## **Expected Behavior in Test Cases:**

1. Input Grid:

    ```text
    [
        [1, 1, 0],
        [1, 0, 0],
        [1, 1, 1]
    ]
    ```

    Starting Cell: `(0, 0)`
    - Output: Cells with color `1` connected to `(0, 0)`.

2. Input Grid:

    ```text
    [
        [3, 2, 2],
        [2, 3, 3],
        [2, 3, 3]
    ]
    ```

    Starting Cell: `(1, 1)`
    - Output: Cells with color `3` connected to `(1, 1)`.

## **Hints for Solving the Problem**

1. **Think Recursively**  
   - The function `findComponent(int i, int j)` should explore all four possible directions: up, down, left, and right. For each direction:
     - Check if the next cell is valid using `isValid`.
     - If valid, recursively call `findComponent` on the next cell.

2. **Base Case for Recursion**  
   - Ensure that you mark a cell as visited when you process it. This prevents infinite loops caused by revisiting the same cell.

3. **Validity Checks**  
   - Use the `isValid` function to:
     - Ensure the indices `(i, j)` are within the grid bounds.
     - Check that the cell has not already been visited.
     - Verify that the cell color matches the starting cell’s color.

4. **Data Storage**  
   - Use a `List<Cell>` to store the cells in the connected component. Add a cell to the list when it’s visited.

5. **Edge Cases**  
   - Handle grids with:
     - Only one cell.
     - Cells of different colors.
     - Entirely empty grids.
