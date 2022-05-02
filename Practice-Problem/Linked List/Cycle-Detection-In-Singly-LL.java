//Method 1, Look up table approach

/*  
    Time Complexity : O(N)
    Space Complexity : O(N)
    
    Where N is number of Nodes in Linked-List.
*/

import java.util.Set;
import java.util.HashSet;

public class Solution {
    
    public static boolean detectCycle(Node<Integer> head) {

        // Set to store the visited nodes.
        Set<Node> nodesSeen = new HashSet<>();

        while (head != null) {

            if (nodesSeen.contains(head)) {

                //  We reached some earlier node again thus we found a cycle.
                return true;
            } else {

                //  Add the node to hastset of already seen nodes.
                nodesSeen.add(head);
            }

            head = head.next;
        }

        //  We didn't found any Cycle.
        return false;
    }
}

//Method 2, Slow ans fast pointer approach
/*  
    Time Complexity : O(N)
    Space Complexity : O(1)
    
    Where N is number of Nodes in Linked-List.
*/

public class Solution {
    
    public static boolean detectCycle(Node<Integer> head) {

        if (head == null || head.next == null) {
            return false;
        }

        //  Slow Pointer - This will be incremented by 1 Nodes.
        Node<Integer> slow = head;
        //  Fast Pointer  - This will be incremented by 2 Nodes.
        Node<Integer> fast = head.next;
        
        while (slow != fast) {

            //  We reached the end of the List and haven't found any Cycle.
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        //  We found a Cycle.
        return true;
    
    }
}
