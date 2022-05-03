//Implemented queue using LL
/*
    Time complexity: O(q)
    Space complexity: O(q)

    Where q is the number of queries.
*/

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
};

public class Queue {
    Node head;
    Node tail;
    int size;

    Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Function to check if the queue is empty.
    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int data) {

        // Increase the count of elements present in the List.
        size++;

        // Create a new node.
        Node newNode = new Node(data);

        // Check if the Queue is empty.
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        // Push the element to the last of the queue.
        tail.next = newNode;
        tail = newNode;
        return;
    }

    int dequeue() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        int ans = head.data;

        Node tmp = head;
        head = head.next;

        // If the queue is empty make the tail pointer null.
        if (head == null) {
            tail = null;
        }

        tmp = null;

        size--;

        return ans;
    }

    int front() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        // Return the element at the front.
        return head.data;
    }

}

//Implementd queue using Array

/*
    Time Complexity : O(q)
    Space Complexity : O(q)

    Where q is the number of queries.
*/

public class Queue {
    int qfront, rear, size, queueSize;
    int[] q;

    Queue() {

        // Intialise the queue with 0 elements.
        rear = 0;
        qfront = 0;
        size = 0;
        queueSize = 100010;
        q = new int[100010];
    }

    // Function to check if the queue is empty.
    boolean isEmpty() {
        if (qfront == rear) {
            return true;
        }
        return false;
    }

    void enqueue(int data) {

        // Push the current element in the queue.
        q[rear] = data;
        rear = rear + 1;

        // Increase the value of size.
        size++;
    }

    int dequeue() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        int ans = q[qfront];
        qfront++;
        size--;
        if (qfront == rear) {
            qfront = 0;
            rear = 0;
        }
        return ans;
    }

    int front() {

        // Check if the queue is empty.
        if (isEmpty()) {
            return -1;
        }

        // Return the element at front.
        return q[qfront];
    }

}
