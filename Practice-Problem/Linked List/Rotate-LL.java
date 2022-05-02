import java.util.* ;
import java.io.*; 
/***********************************************
    Following is the class structure of the Node class:

    class Node {
        int data;
        Node next;

        Node(int x) {
            this.data = x;
            this.next = null;
        }
    }

************************************************/

public class Solution {
    public static Node rotate(Node head, int k) {
        // Write your code here.
		if(head==null || head.next==null){
			return head;
		}
		Node temp=head;
		int l=1;
		while(temp.next!=null){
			l++;
			temp=temp.next;
		}

		temp.next=head;//Last node pointing to first node of LL, to make it circular
		k=k%l;//to handle case, if k>l
		int x=l-k;

		while(x>0){
			temp=temp.next;
			x--;
		}
		head=temp.next;
		temp.next=null;
		return head;
    }
}
