//Method 1, using List
/*
    Time Complexity: O(N)
    Space Compexity: O(N)

    Where 'N' is the total nodes in Linked List.
*/

import java.util.ArrayList;

public class Solution {
    public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {

        if (head == null || K == 0) {
            return head;
        }

        // It stores all the node of Linked List.
        ArrayList<LinkedListNode<Integer>> nodeList = new ArrayList<>();

        // Creating temporory node.
        LinkedListNode<Integer> temp = head;

        // Iterating the Linked List.
        while (temp != null) {

            // Add current node to list.
            nodeList.add(temp);

            temp = temp.next;
        }

        // If head of Linked List is the Kth node.
        if (K == nodeList.size()) {

            LinkedListNode<Integer> next = head.next;
            head.next = null;
            head = next;

        } else {
            
            // Remove the Kth node from end.
            nodeList.get(nodeList.size() - K - 1).next = nodeList.get(nodeList.size() - K).next;
        }
        return head;
    }
}

//Method 2, by finding length of LL

/*
    Time Complexity: O(N)
    Space Compexity: O(1)

    Where 'N' is the total nodes in Linked List.
*/

public class Solution {
    public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {

        if (head == null || K == 0) {
            return head;
        }

        // It stores the Length of Linked List.
        int L = 0;

        // Creating temporory node.
        LinkedListNode<Integer> temp = head;

        while (temp != null) {
            L++;
            temp = temp.next;
        }

        // If head of Linked List is the Kth node from end.
        if (K == L) {
            
            LinkedListNode<Integer> next = head.next;
            head.next = null;
            head = next;
        } else {

            int countNode = 0;
            temp = head;
            while (temp != null) {

                countNode++;

                // Remove the Kth node from end of Linked List.
                if (L - K == countNode) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }
        return head;
    }
}

//Method 3, using slow and fast pointer
/*
    Time Complexity: O(N)
    Space Compexity: O(1)

    Where 'N' is the total nodes in Linked List.
*/

public class Solution {
    public static LinkedListNode<Integer> removeKthNode(LinkedListNode<Integer> head, int K) {

        if (head == null || K == 0) {
            return head;
        }

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;

        for (int i = 0; i < K; i++) {

            // If head is the Kth node from end of Linked List.
            if (fast.next == null) {
                LinkedListNode<Integer> next = head.next;
                head.next = null;
                head = next;

                return head;
            } else {
                fast = fast.next;
            }

        }

        // Moving both slow and fast pointer with same speed.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Removing the Kth node from end of Linked List.
        slow.next = slow.next.next;

        return head;
    }
}

