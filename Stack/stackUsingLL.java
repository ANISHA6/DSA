
/*
    Following is the structure of the node class for a Singly Linked List

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

*/

public class Stack {

    //Define the data members
    private Node head;
    private int size;


    public Stack() {
        //Implement the Constructor
        head=null;
        size=0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
        
        return size==0;
    }

    public void push(int element) {
        //Implement the push(element) function
        Node newNode=new Node(element);
       //Inserting new node front of the LL
        newNode.next=head;// Here head is pointing to the last element.
        head=newNode;//Now head pointing to the last element or front of the LL
        size++;
        
    }

    public int pop() {
        //Implement the pop() function
        if(head==null){
            return -1;
        }
        int temp=head.data;
        head=head.next;
        size--;
        return temp;
    }

    public int top() {
        //Implement the top() function
        if(head==null){
            return -1;
        }
        return head.data;
    }
}
