import java.util.* ;
import java.io.*; 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;
	Node child;

	public Node(int data) {
		this.data = data;
		this.next = null;
		this.child = null;
	}
}


tc:O(N)
sc:O(1)

*****************************************************************/
public class Solution {
	public static Node merge(Node a, Node b){
		Node temp=new Node(0);
		Node res=temp;
		
		while(a!=null && b!=null){
			if(a.data>b.data){
				temp.child=b;
				temp=temp.child;
				b=b.child;
			}else{
				temp.child=a;
				temp=temp.child;
				a=a.child;
			}
		}
		
		while(a!=null){
			temp.child=a;
				temp=temp.child;
				a=a.child;
		}
		while(b!=null){
			temp.child=b;
				temp=temp.child;
				b=b.child;
		}
		return res.child;
	}
	
	public static Node flattenLinkedList(Node start) {
		 //Write your code here
		
		if(start==null || start.next==null){
			return start;
		}
		start.next=flattenLinkedList(start.next);
		start=merge(start, start.next);
		return start;
	}
}

//Method 2, brute force approach

/*
    Time Complexity: O((N * K) * (log(N * K)))
    Space complexity: O(N * K)

    Where 'N' denotes the size of the linked list and 'K' is the average number of child nodes for each of the N nodes. 
*/
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	public static Node flattenLinkedList(Node root) {
		ArrayList<Integer> answer = new ArrayList<Integer>();

		// Traverse the linked and add all the nodes to list
		while (root != null) {
			answer.add(root.data);
			Node temp = root;

			// Add all child nodes
			while (temp.child != null) {
				answer.add(temp.child.data);
				temp = temp.child;
			}
			root = root.next;
		}
		Collections.sort(answer);

		Node head = null;
		Node tail = null;

		// Create new linked list
		for (int i = 0; i < answer.size(); ++i) {
			Node newNode = new Node(answer.get(i));

			if (head == null) {
				head = newNode;
			} else {
				tail.child = newNode;
			}
			tail = newNode;
		}
		return head;
	}
}
