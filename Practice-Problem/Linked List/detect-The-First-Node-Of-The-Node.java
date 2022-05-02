//Method 1, Look up table approach
/*
    Time Complexity: O(N)
    Space Complexity: O(N)
    Where 'N' is the number of nodes in the linked list.

*/

import java.io.*;
import java.util.*;

public class Solution 
{
	public static Node firstNode(Node head) 
    {
		// To keep track of visited nodes.
		HashSet<Node> nodesSeen = new HashSet();

		while (head != null) 
        {
			if (nodesSeen.contains(head)) 
            {
				// We reached some earlier node again thus we found a cycle and the current node is starting point.
				return head;
			} 
            else 
            {
				// Add the node to hashset of already seen nodes.
				nodesSeen.add(head);
			}
			head = head.next;
		}

		// We didn't find any Cycle.
		return null;
	}
}

 
