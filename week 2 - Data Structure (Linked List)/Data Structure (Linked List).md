# **Lab Session: Introduction to Data Structures and Linked Lists**

## **Session Overview**

**Duration**: 90 minutes  
**Audience**: $2^{nd}$ year, $1^{st}$ semester students, Intermediate level  
**Session Type**: Practical lab  
**Session Number**: 2  
**Focus**: Introduction to Data Structures and Linked Lists  
**Lecturer**: Nabil Ghosn

---

## **Learning Objectives**

By the end of this session, students should be able to:

- Understand the structure and implementation of singly, doubly, and circular linked lists.
- Compare and contrast the performance characteristics of linked lists with arrays and ArrayLists.
- Implement common linked list operations and analyze their time complexity.

---

## **Session Outline**

### **1. Introduction to Data Structures (20-25 Minutes)**

#### Introduction to Data Structures in General

- **Definition**: Data structures are organized formats to store and manage data efficiently, making algorithms perform faster and use memory effectively.
- **Types of Data Structures**:
  - **Linear Data Structures**: e.g., Arrays, Linked Lists (elements are sequentially arranged).
  - **Non-Linear Data Structures**: e.g., Trees, Graphs (elements are hierarchical or interconnected).

- **Why Data Structures Matter**:
  - **Efficiency**: Selecting an optimal data structure enhances the algorithm’s performance and scalability.
  - **Memory Management**: They help in managing memory by reducing waste and organizing data appropriately.

- **Basic Operations**: Data structures perform key operations such as insertion, deletion, access, and traversal of elements.  
Choosing the right data structure depends on the specific problem requirements, as it’s important to select one that efficiently supports the necessary operations at an optimal time and space complexity.

#### Array and ArrayList

- **Arrays**:
  - A linear data structure where elements are stored in contiguous memory.
  - **Language-Specific Differences**:
    - **C++**: Multidimensional arrays are represented as single-dimensional arrays in the heap.
    - **Java**: Supports "jagged arrays," where multi-dimensional arrays are actually arrays of references to other arrays.
    - **C#**: Supports both true multidimensional arrays and jagged arrays.

- **Static Array vs Dynamic Array**:
  - **Static Array**: Fixed size; declared with a set number of elements.
  - **Dynamic Array (e.g., `ArrayList`)**: Can resize itself; provides `capacity()` (total allocated size) and `size()` (number of elements stored).
  - **How ArrayList Works**: Dynamically grows by creating a new array and copying over elements when it reaches its capacity.  
  - **Time Complexity for inserting n elements in an ArrayList**:  
  $T(n)=∑_{i=0}^{log_2(n)}2^𝑖=2^{(log𝑛+1)}−1=2^𝑛−1=𝑂(2𝑛)$

#### Intro to LinkedList

- **Definition**: A LinkedList is a data structure consisting of nodes, where each node contains a value and a reference to the next (and sometimes previous) node.
- **LinkedList Types**:
  - **Single Linked List**: Each node has a single reference to the next node.
  - **Doubly Linked List**: Each node has references to both the previous and next nodes.
  - **Circular Singly Linked List**: The last node points back to the first node.
  - **Circular Doubly Linked List**: Doubly linked nodes where the last node connects back to the first node.

#### Advantages and Disadvantages of Linked Lists

- **Pros**:
  - Dynamic size; no need to predefine capacity.
  - Efficient insertion and deletion, especially at the beginning and end.
- **Cons**:
  - No direct access by index, requiring traversal.
  - Extra memory is required for pointers.

---

### **2. Linked List Essential Implementation (40-45 Minutes)**

For each operation, we'll provide a simple algorithm and code in a Java-like pseudocode style.

#### Node and LinkedList classes

Node class is an inner class to encapsulate the node structure, closely tying it to the linked list operations and preventing external exposure. Node class is a POJO because it lacks framework dependencies, contains simple fields and a constructor, and represents data straightforwardly.

Insert at the beginning:

1. Create a new node.
2. Set the new node's next pointer to the current head.
3. Update the head to the new node.

```java
class LinkedList{
    Node head;
    
    public void insert(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
}
```

#### a. Print All Elements of the LinkedList (Traversal)

- **Algorithm**: Start at the head, print each node’s data, and move to the next node until the end.

```java
public void print(){
    Node current = head;
    while(current != null){
        System.out.print(current.data + " ");
        current = current.next;
    }
}
```

#### b. Linear Search in LinkedList

- **Algorithm**: Traverse nodes from the head, comparing each node’s data with the target value until found or end reached.

```java
public boolean search(int data){
    Node current = head;
    while(current != null){
        if(current.data==data){
            return true;
        }
        current = current.next;
    }
    return false;
}
```

#### c. Delete an Element from a LinkedList

- **Algorithm**: Find the target node, adjust the previous node’s `next` pointer to skip it.

1. If the list is empty, return.
2. If the target node is the head, update the head to the next node.
3. Iterate through the list with `current` and `prev` pointers:
   - If `current` is the target node, set `prev.next = current.next`.

```java
public boolean delete(int data){
    if (head == null){
        return false;
    }
    if (head.data == data){
        head = head.next;
        return true;
    }
    Node current = head.next, prev = head;
    while(current != null){
        if(current.data == data){
            prev.next = current.next;
            return true;
        }
        prev = current;
        current = current.next;
    }
    return false;
}
```

#### d. Delete All Occurrences of an Element from a LinkedList

- **Algorithm**: Traverse and delete nodes containing the target value.

```java
void deleteAllOccurrences(int data){
    if (head == null){
        return;
    }
    // while instead of if
    while (head != null && head.data == data){
        head = head.next;
        // remove return
    }
    Node current = head.next, prev = head;
    while(current != null){
        if(current.data == data){
            prev.next = current.next;

            // delete the node and use continue instead of return
            current = prev.next;
            continue;
        }
        prev = current;
        current = current.next;
    }
    return;
}
```

#### e. Reverse the LinkedList

- **Algorithm**: Traverse nodes and reverse the direction of each pointer.

1. Initialize `current`, `prev`, and `next`.
2. Iterate through the list:
   - Update `next` to the next node.
   - Set `current.next` to `prev`.
   - Move `prev` to `current`.
   - Move `current` to `next`.
3. Update the head to `prev`.

```java
public void reverse() {
    Node current = head, prev = null, next = null;
    while(current != null){
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }
    head = prev;
}
```

---

**Doubly Linked List**: The Node consists of `prev` and `next`.

### **Insert at Beginning:**

1. Create a new node with the given data.
2. If the list is empty:
   - Set `head` and `tail` to the new node.
3. If the list is not empty:
   - Set the current head's `prev` to the new node.
   - Set the new node's `next` to the current head.
   - Update the head to the new node.

### **Insert at End:**

1. Create a new node with the given data.
2. If the list is empty:
   - Set `head` and `tail` to the new node.
3. If the list is not empty:
   - Set the current tail's `next` to the new node.
   - Set the new node's `prev` to the current tail.
   - Update the tail to the new node.

```java
class DoublyLinkedList {
    Node head, tail;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
        }
    }
}
```

---

#### f. Delete an Element from a Doubly Linked List

- **Algorithm**: Find the target node, adjust `prev` and `next` pointers of surrounding nodes.

1. Initialize `current` to the head.
2. Iterate through the list to find the target node.
3. If the target node is found:
   - Adjust the `prev` node's `next` pointer.
   - If the target node is the head, update the head to the next node.
   - Adjust the `next` node's `prev` pointer.
   - If the target node is the tail, update the tail to the previous node.

```java
public void delete(int data) {
    Node current = head;
    while (current != null && current.data != data) {
        current = current.next;
    }
    if (current == null) return;
    if (current.prev != null)
        current.prev.next = current.next;
    else 
        head = current.next;
    if (current.next != null) 
        current.next.prev = current.prev;
    else 
        tail = current.prev;
}

// Other way
public void delete(int data) {
    Node current = head, prev = null, next = null;
    while(current != null) {
        next = current.next;
        if (current.data == data) {
            if (prev != null) {
                prev.next = next;
            }
            else {
                head = next;
            }
            if(next != null) {
                next.prev = prev;
            }
            else {
                tail = prev;
            }
        }
        prev = current;
        current = next;
    }
}
```

#### g. Add Element to a Sorted Linked List

- **Algorithm**: Traverse and find the correct position, insert node.

```java
public void insertSorted(int data) {
    Node newNode = new Node(data);
    if (head == null || head.data >= newNode.data) {
        newNode.next = head;
        head = newNode;
        return;
    }
    Node current = head;
    while (current.next != null && current.next.data < newNode.data) {
        current = current.next;
    }
    newNode.next = current.next;
    current.next = newNode;
    return;
}
```

#### h. Add Element to a Sorted Doubly Linked List

- **Algorithm**: Traverse and find the correct position, insert node.

```java

```

---

### **3. Real-World Applications of Linked List (5 Minutes)**

- **Single Linked List Examples**:

1. To-do lists
2. Navigation systems
3. Undo functionality in software
4. Hash table collision handling
5. File system directories

- **Double Linked List Examples**:

1. Browser history
2. Music playlists with next and previous functionality
3. MRU (Most Recently Used) cache
4. Text editors for undo/redo operations
5. Data structures in databases

- **Circular Linked List Examples**:

1. Round-robin scheduling
2. Network token passing
3. Traffic light systems
4. Music playlists
5. Computer memory management

---

### **4. Summary and Q&A (5 Minutes)**

Summarize key points: linked list types, operations, real-world applications, and pros/cons. Answer any questions.

---

### **Additional Resources**

- Textbook chapter on Linked Lists.
- Recommended coding practice on linked list problems at LeetCode or HackerRank.

---

## Appendix

| Operation                         | Array   | ArrayList | Singly Linked List | Doubly Linked List | Circular Singly Linked List | Circular Doubly Linked List |
|-----------------------------------|---------|-----------|---------------------|--------------------|-----------------------------|-----------------------------|
| **Access**                        | O(1)    | O(1)      | O(n)                | O(n)               | O(n)                        | O(n)                        |
| **Linear Search**                 | O(n)    | O(n)      | O(n)                | O(n)               | O(n)                        | O(n)                        |
| **Binary Search**                 | O(log n)| O(log n)  | N/A                 | N/A                | N/A                         | N/A                         |
| **Insertion at Beginning**        | O(n)    | O(n)      | O(1)                | O(1)               | O(1)                        | O(1)                        |
| **Insertion at End**              | O(1)    | O(1)      | O(n)                | O(1)               | O(n)                        | O(1)                        |
| **Insertion at Specific Index**   | O(n)    | O(n)      | O(n)                | O(n)               | O(n)                        | O(n)                        |
| **Deletion at Beginning**         | O(n)    | O(n)      | O(1)                | O(1)               | O(1)                        | O(1)                        |
| **Deletion at End**               | O(1)    | O(1)      | O(n)                | O(1)               | O(n)                        | O(1)                        |
| **Deletion at Specific Index**    | O(n)    | O(n)      | O(n)                | O(n)               | O(n)                        | O(n)                        |
| **Update**                        | O(1)    | O(1)      | O(n)                | O(n)               | O(n)                        | O(n)                        |
| **Traversal**                     | O(n)    | O(n)      | O(n)                | O(n)               | O(n)                        | O(n)                        |
| **Sorting**                       | O(n log n) | O(n log n) | O(n log n)       | O(n log n)         | O(n log n)                  | O(n log n)                  |
| **Reverse**                       | O(n)    | O(n)      | O(n)                | O(n)               | O(n)                        | O(n)                        |
