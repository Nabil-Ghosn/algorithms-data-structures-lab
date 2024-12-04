# **Stack Lab Homework: Tower of Hanoi Recursive Solution**

## **Objective:**

Implement a recursive solution to the Tower of Hanoi problem using stacks to simulate the movement of disks between the rods. The objective is to move \( n \) disks from the source rod to the target rod, following the rules of the Tower of Hanoi.

---

## **Problem Statement:**

The Tower of Hanoi is a classic problem that involves moving \( n \) disks from a source rod (`A`) to a destination rod (`C`) following these rules:

1. Only one disk can be moved at a time.
2. A disk can only be placed on top of a larger disk.
3. Each move involves taking the top disk from one rod and placing it on another.

watch this youtube video to understand the game visually: [Tower of Hanoi: Five Rings Solution 5.](https://youtu.be/BalWjeY2O9g?si=afl8_toXNS8PLLLW)

---

## **Method Signatures:**

In this assignment, you will implement two key methods of the **Tower of Hanoi** algorithm:

1. `moveDisk(int from, int to)`: This method handles moving the top disk from the `from` rod to the `to` rod.
2. `towerOfHanoi(int n, int src, int aux, int dest)`: This is the recursive method to solve the Tower of Hanoi problem.

You will use the given `TowerOfHanoi` class framework and complete the missing implementations.

---

## **Instructions:**

1. Implement `moveDisk(int from, int to)` and `towerOfHanoi(int n, int src, int aux, int dest)` methods.
2. Don't alter anything in the code unless the required methods
3. Test your solution for \( n = 3 \) and verify that the output matches the expected sequence of moves.
4. Understand how the recursive method breaks the problem into smaller sub-problems.
5. Get the code ready on your laptop for the next session.
6. Be ready to explain the base case and recursive steps.

---

## **Example:**

### Input  

```text
Number of Disks: 3
```

### Expected Output  

```text
Move disk 1 from A to C
Move disk 2 from A to B
Move disk 1 from C to B
Move disk 3 from A to C
Move disk 1 from B to A
Move disk 2 from B to C
Move disk 1 from A to C
```

---

## **Starter Code:**

```java
import java.util.Stack;

class TowerOfHanoi {
    private int n;
    private Stack<Integer>[] rods;
    
    public TowerOfHanoi(int n) {
        this.n = n;
        Stack<Integer> A = new Stack<>();
        Stack<Integer> B = new Stack<>();
        Stack<Integer> C = new Stack<>();
        for (int i = n; i >= 1; i--) {
            A.push(i);
        }
        rods = new Stack[]{A, B, C};
    }
    
    public void solve() {
        towerOfHanoi(this.n, 0, 1, 2);
    }
    
    private String getRodName(int index) { 
        switch (index) { 
            case 0: return "A"; 
            case 1: return "B"; 
            case 2: return "C"; 
            default: return "unknown"; 
        } 
    }
    
    private void moveDisk(int from, int to) {
        System.out.println("Move disk " + rods[from].peek() + " from " + getRodName(from) + " to " + getRodName(to)); 
        // Implement your code here
    } 

    private void towerOfHanoi(int n, int src, int aux, int dest) {
        // Implement your code here
    }
}

public class HanoiTowerHomework {
    public static void main(String[] args) {
        int n = 3;
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi(n);
        towerOfHanoi.solve();
    }
}
```

---

## **Hints for Solving the Problem**

1. The recursive function always works on \( n-1 \) disks before and after moving the largest disk.
2. Think of the rods as playing different roles (`src`, `aux`, and `dest`) depending on the step in the recursion.
3. Focus on one recursive step at a time—don’t try to understand the full process at once.

- Base Case: If \( n = 0 \), return (no disks to move).  
- Recursive Case:  
    1. Move \( n-1 \) disks from the `src` rod to the `aux` rod, using `dest` as the auxiliary.  
    2. Move the \( n \)-th (largest) disk directly from the `src` rod to the `dest` rod.  
    3. Move the \( n-1 \) disks from the `aux` rod to the `dest` rod, using `src` as the auxiliary.  

---

## **Bonus Question (Optional):**

Can you calculate the total number of moves required to solve the Tower of Hanoi problem for \( n \) disks? Explain your reasoning.
