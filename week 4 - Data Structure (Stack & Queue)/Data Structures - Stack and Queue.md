# **Lab Session: Data Structures - Stack and Queue**

## **Session Overview**

**Duration**: 90 minutes  
**Audience**: $2^{nd}$ year, $1^{st}$ semester students, Intermediate level  
**Session Type**: Practical lab  
**Session Number**: 4  
**Focus**: Exploring the concepts, properties, and applications of **Stack** and **Queue**  
**Lecturer**: Nabil Ghosn

---

## **Learning Objectives**

By the end of this session, students should be able to:

- Define and explain **Stack** and **Queue**, including their real-world applications.  
- Understand the **LIFO** (Last-In-First-Out) and **FIFO** (First-In-First-Out) principles.  
- Distinguish between the **concepts** of these data structures and their **implementations**.  
- Solve exercises requiring Stack and Queue usage.

---

## **Session Outline**

### **1. Introduction (10 minutes)**  

#### **Concepts: Stack and Queue**

- **Stack**:  
  A **Stack** is a collection of elements (linear data structure) that follows the **LIFO** principle: the last element added to the stack is the first one to be removed.  
  - **Real-World Examples**:  
    1. A stack of plates in a cafeteria.  
    2. Undo operations in text editors.  
  - **Key Operations**:  
    - `push()`: Add an element to the top.  
    - `pop()`: Remove and return the top element.  
    - `peek()`: View the top element without removing it.  
    - `isEmpty()`: Checks if the stack is empty.  

- **Queue**:  
  A **Queue** is a collection of elements (linear data structure) that follows the **FIFO** principle: the first element added to the queue is the first one to be removed.  
  - **Real-World Examples**:  
    1. People standing in line for a ticket counter.  
    2. Task scheduling in operating systems.  
  - **Key Operations**:  
    - `enqueue()`: Add an element to the back.  
    - `dequeue()`: Remove and return the front element.  
    - `peek()`: View the front element without removing it.  
    - `isEmpty()`: Checks if the queue is empty.  

- **Dequeue (Double-Ended Queue)**: (Bonus)
  - Elements can be added and removed from both the front and the rear.
  - Can function as both a FIFO and a LIFO structure.

For an in-depth visual representation of stacks and queues, you can visit this site: [Stacks-and-Queues](https://vonvista.github.io/Stacks-and-Queues/)

---

### **2. Properties and Characteristics (10 minutes)**  

- **Stack Properties**:  
  - Only the top element is accessible directly.  
  - Dynamic or static memory allocation. (Easier with dynamic memory)  

- **Queue Properties**:  
  - Front and rear elements are accessible.  
  - Dynamic or static memory allocation. (Circular queues optimize space)  

- **Comparison Table**:

    | Property            | Stack                  | Queue                   |
    |---------------------|------------------------|-------------------------|
    | Access Principle    | LIFO (Last In, First Out) | FIFO (First In, First Out) |
    | Pointers            | One pointer (top)      | Two pointers (front, rear) |
    | Key Operations      | push, pop, peek        | enqueue, dequeue, peek  |
    | Real-world Analogy  | Stack of plates        | Line at a ticket counter |

---

### **3. Implementation Concepts (20 minutes)**  

#### **Implementation: Stack Using Singly Linked List**  

- For further explanation visit this link: <https://www.geeksforgeeks.org/implement-a-stack-using-singly-linked-list/>  
- The complexity of each of its methods (`push`, `pop`, `peek`) is $O(1)$

```java
class Node {
    int data;
    Node next;
    Node(int new_data) {
        this.data = new_data;
    }
}

class Stack {
    Node head;
    
    boolean isEmpty() {
        return head == null;
    }

    void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void pop() {
        if (head != null) {
            Node temp = head;
            head = head.next;
        }
    }

    int peek() {
        if (head != null)
            return head.data;
        return -1;
    }
}
```

#### **Implementation: Queue Using Singly Linked List**  

- For further explanation visit this link: <https://www.geeksforgeeks.org/implement-a-stack-using-singly-linked-list/>
- The complexity of each of its methods (`enqueue`, `dequeue`, `peek`) is $O(1)$

```java
class Node {
    int data;
    Node next;
    Node(int new_data) {
        this.data = new_data;
    }
}

class Queue {
    Node front, rear;

    boolean isEmpty() {
        return front == null;
    }

    void enqueue(int new_data) {
        Node new_node = new Node(new_data);
        if (rear == null) {
            front = rear = new_node;
            return;
        }
        rear.next = new_node;
        rear = new_node;
    }

    void dequeue() {
        if (front != null) {
            front = front.next;
            if (front == null) {
                rear = null;
            }
        }
    }

    int peek() {
        if (front != null) {
            return front.data;
        }
        return -1;
    }
}
```

---

### **4. Exercises (40 minutes)**  

#### **Exercise 1: Reverse a String Using a Stack**  

Write a Java program to reverse a string using a stack.

```java
import java.util.Stack;

public String reverseStringUsingStack(String input) {
    Stack<Character> stack = new Stack<>();
    for (char ch : input.toCharArray()) {
        stack.push(ch);
    }

    String reversed = "";
    while (!stack.isEmpty()) {
        reversed += stack.pop();
    }

    return reversed;
}
```

#### **Exercise 2: Balanced Parentheses**  

Use a Stack to check if a string of parentheses `(`, `)`, `{`, `}`, `[`, `]` is balanced.

```java
import java.util.Stack;

public class ParenthesesChecker {

    private boolean isOpen(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private boolean match(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (isOpen(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !match(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        ParenthesesChecker checker = new ParenthesesChecker();
        String test = "{[()]}";
        System.out.println("Is the string \"" + test + "\" balanced? " + checker.isValid(test));
        // Is the string "{[()]}" balanced? true
    }
}
```

#### **Exercise 3:**

For a given array, the task is to find the Next Greater Element (NGE) for each element. The NGE for an element in the array is the first element to its right that is greater than the current element. If no such element exists, the NGE is `-1`.

```java
void naiveNGE(int arr[], int n){
  for (int i = 0; i < n; i++) {
      int next = -1;
      for (int j = i + 1; j < n; j++) {
          if (arr[i] < arr[j]) {
              next = arr[j];
              break;
          }
      }
      System.out.println(next);
  }
}
```

- For each element, it iterates through all elements to its right until it finds the NGE or confirms none exists.
- The outer loop runs n times, and the inner loop iterates up to n-1 in the worst case, resulting in O(n²).
- Suggest a method that improves the complexity using a stack to be O(n):

```java
void NGE(int arr[], int n){
  Stack<Integer> st = new Stack<>();
  Stack<Integer> res = new Stack<>();

  for (int i = n - 1; i >= 0; i--) {
    while(!st.isEmpty() && st.peek() < arr[i]){
        st.pop();
    }
    if (st.isEmpty())
        res.push(-1);
    else
        res.push(st.peek());
    st.push(arr[i]);
  }
  while(!res.isEmpty())
    System.out.println(next);
}
```

Explanation:

1. Start from the rightmost element of the array.
2. Use a stack to track Next Greater Elements (NGEs).
3. Remove elements from the stack that are smaller than or equal to the current element.
4. If the stack is empty, the current element has no NGE (-1).
5. Otherwise, the top of the stack is the NGE for the current element.
6. Push the current element onto the stack.
7. Store results in a second stack for correct output order.
8. Print the results from the second stack.

- Each element is pushed and popped from the stack at most once, leading to an O(n) time complexity.
- Instead of iterating through the array multiple times, the stack efficiently keeps track of the next greater elements dynamically.

### **4. Summary and Q&A (5 Minutes)**

- Stacks follow **LIFO**, while Queues follow **FIFO**.

---

### **Additional Resources**

- [Stack Data Structure](https://www.geeksforgeeks.org/stack-data-structure/)
- [Implement a Stack using Singly Linked List](https://www.geeksforgeeks.org/implement-a-stack-using-singly-linked-list/)
- [Queue Data Structure](https://www.geeksforgeeks.org/queue-data-structure/)
- [Basic Operations for Queue in Data Structure](https://www.geeksforgeeks.org/basic-operations-for-queue-in-data-structure/)
- [Reverse String using Stack](https://www.geeksforgeeks.org/stack-set-3-reverse-string-using-stack/)
- [Check for Balanced Parentheses in an Expression](https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/)
- [Next Greater Element](https://www.geeksforgeeks.org/next-greater-element/)

### **Supplementary Section** (NOT REQUIRED)

### Stack Implementation Using Array

```java
class Stack {
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        stackArray = new int[size];
        top = -1;
    }

    public void push(int value) {
        if (top < stackArray.length - 1) {
            stackArray[++top] = value;
        }
    }

    public int pop() {
        return (top >= 0) ? stackArray[top--] : Integer.MIN_VALUE;
    }

    public int peek() {
        return (top >= 0) ? stackArray[top] : Integer.MIN_VALUE;
    }

    public boolean isEmpty() {
        return (top == -1);
    }
}
```

### Queue Implementation Using Array

```java
class Queue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size) {
        queueArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(int value) {
        if (nItems < queueArray.length) {
            rear = (rear + 1) % queueArray.length;
            queueArray[rear] = value;
            nItems++;
        }
    }

    public int dequeue() {
        if (nItems > 0) {
            int value = queueArray[front];
            front = (front + 1) % queueArray.length;
            nItems--;
            return value;
        }
        return Integer.MIN_VALUE;
    }

    public int peek() {
        return (nItems > 0) ? queueArray[front] : Integer.MIN_VALUE;
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }
}
```
