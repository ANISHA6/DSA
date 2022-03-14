public class Stack {

	/********************************
	
		STRUCTURE OF NODE CLASS

		class Node {
    		int data;
    		Node next;
    		Node prev;
    		Node(int data) {
        		this.data = data;
        		this.next = null;
        		this.prev = null;
    		}
		}

	*******************************/
    //for TC:O(1), We have to use doubly LL
    public Node head;

    public Node middle;
    int size;

	Stack() {

        head=null;
        middle=null;
        size=0;
	}

	public void push(int element) {
        Node new_node=new Node(element);
        if(head==null){
            head=new_node;
            middle=new_node;
            size++;
            return;
        }
        new_node.prev=head;
       head.next=new_node;//Adding new node right side,for FIFO function
        head=new_node;//Updating new node as a head
        size++;
        if(size%2==1){//In case of odd no. of element
            middle=middle.next;//Move middle to its next
        }
        
        

	}

	public int pop() {
		// Return 0 if the stack is empty
        if(head==null){
		return 0;  } 
        
        int del_data=head.data;
        head=head.prev;
        size--;
        if(size%2==0)
            middle=middle.prev;
        return del_data;
	}
	
	public int getmiddle() {
		// Return 0 if the stack is empty
        if(middle==null){
		return 0;   }
        int mid_data=middle.data;
        return mid_data;
        
	}
		
	public int removeMiddle() {
		// Return 0 if the stack is empty
        if(middle==null){
        return 0; }
        
        int mid_data=middle.data;
        Node previous=middle.prev;
        Node foll=middle.next;
        size--;
        if(size%2==1){
            middle=middle.next;
            
        }
        else{
            middle=middle.prev;
        }
        if(previous!=null){
            previous.next=foll;//connecting middle previous to middle next or deleting middle element
        }
        if(foll!=null){
            foll.prev=previous;
        }
        return mid_data;
	}
		
	public void print() {
        
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.prev;//Printing right to left (back to front)to follow FIFO sequence of stack
        }
			
	} 
}
    
