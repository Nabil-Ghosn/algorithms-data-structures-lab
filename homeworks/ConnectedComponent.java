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
