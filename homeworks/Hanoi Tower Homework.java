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