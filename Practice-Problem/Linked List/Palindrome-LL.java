//Method 1, using stack
/*
    Time Complexity: O(N)
    Space Compexity: O(N)

    Where N is the total nodes in Linked List.
*/

import java.util.Stack;

public class Solution {

    public static boolean isPalindrome(LinkedListNode<Integer> head) {

        // It stores the Linked List node value.
        Stack<Integer> st = new Stack<>();

        // Creating temprary Node.
        LinkedListNode<Integer> temp = head;

        while (temp != null) {

            // Add the current node value to stack.
            st.push(temp.data);

            // Move current pointer to next node.
            temp = temp.next;
        }

        while (head != null) {

            // Get the top most element of stack.
            Integer top = st.pop();

            if (!top.equals(head.data)) {
                return false;
            }

            head = head.next;
        }

        return true;

    }

}
//Method 2, clone LL

/* 
    Time Complexity: O(N)
    Space Compexity: O(N)

    Where N is the total nodes in Linked List.
*/

public class Solution {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {

        // Creating a temporary node.
        LinkedListNode<Integer> temp = head;

        // Creating Node for storing head of clone LinkedList.
        LinkedListNode<Integer> cloneHead = null;

        while (temp != null) {

            LinkedListNode<Integer> newNode = new LinkedListNode(temp.data);

            newNode.next = cloneHead;

            cloneHead = newNode;

            temp = temp.next;
        }

        // Iterating clone and given Linked List.
        while (head != null) {

            // Check if both node value is same or not.
            if (!head.data.equals(cloneHead.data)) {

                return false;
            }

            head = head.next;
            cloneHead = cloneHead.next;
        }

        return true;
    }

}
// Method 3, using recursion
/*
    Time Complexity: O(N)
    Space Compexity: O(N)

    Where N is the total nodes in Linked List.
*/

public class Solution {

    static LinkedListNode<Integer> left;

    public static boolean isPalindrome(LinkedListNode<Integer> head) {

        // Assign left node as start of LinkedList.
        left = head;

        // Check if LinkedList is palindrome or not.
        boolean isPal = isPalindromeUtil(head);

        return isPal;
    }

    private static boolean isPalindromeUtil(LinkedListNode<Integer> right) {

        // Stop recursion when right reach end of LinkedList.
        if (right == null) {
            return true;
        }

        boolean isPal = isPalindromeUtil(right.next);

        /*
            If sub-list is not palindrome then no need to check for current left and
            right, return false.
        */

        if (!isPal) {
            return false;
        }

        // Check if both left and right node value are same.
        boolean isSame = (left.data.equals(right.data)) ? true : false;

        // Move left pointer to next node.
        left = left.next;
        return isSame;
    }
}//Method 4, Reversing the second half
/*
    Time Complexity: O(N)
    Space Complexity: O(1)

    Where N is the total Nodes in Linked List.
*/

public class Solution {
    public static boolean isPalindrome(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> prev = head;

        // Find the middle node using TORTOISE-HARE-APPROACH.
        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }

        /*
            Fast pointer would become NULL when there are even elements in the list and
            not NULL for odd elements. We need to skip the middle node for odd case.
        */

        if (fast != null) {
            slow = slow.next;
        }

        // When there is only one node in given Linked List.
        if (slow == null) {

            return true;
        }

        // Dividing Linked LIst in two part by pointing prev next to null.
        prev.next = null;

        // Now reverse the second half.
        LinkedListNode<Integer> reverseHead = reverse(slow);

        // Iterate through both LinkedList and then compare it.
        while (head != null) {

            if (!head.data.equals(reverseHead.data)) {
                return false;
            }
            reverseHead = reverseHead.next;
            head = head.next;

        }
        return true;

    }

    // Reverse the LinkedList.
    private static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {

        LinkedListNode<Integer> current = head;
        LinkedListNode<Integer> reverseHead = null;

        while (current != null) {

            LinkedListNode<Integer> currentNext = current.next;
            current.next = reverseHead;
            reverseHead = current;
            current = currentNext;

        }
        return reverseHead;

    }
}
