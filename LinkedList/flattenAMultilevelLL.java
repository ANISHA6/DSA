public class Solution {

    public static void flattenListCorrect(Node hp) {
     // Write your code here
        //hp- head pointer
        //flatten the LL level wise
        //every node has two pointer next and child
        if(hp==null){
            return ;
        }
        Node tail=hp;
        Node temp=hp;
        
        while(temp.next!=null){
            temp=temp.next;
        }
        
        tail=temp;//last node of first level
        
        while(hp!=null){//hp will traverse linearly
            if(hp.down!=null){
                tail.next=hp.down;//connecting last node of first level to first child and repeat
                
                hp.down=null;//after connecting, disconnect the vertical line
                while(tail.next!=null){// updating tail for next level
                    tail=tail.next;
                }
               
            }
            hp=hp.next;
        }
    }
}
