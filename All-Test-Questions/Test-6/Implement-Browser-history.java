/*
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String input = scn.next();

		BrowserHistory obj = new BrowserHistory (input);

		int choice = scn.nextInt();

		int i = scn.nextInt();
		while(true){
			switch(i){
            			case 1: input=scn.next();
                    			obj.visit(input);
                    			break;
            			case 2: k = scn.nextInt();
                    			input=obj.back(k);
                    			System.out.println(input);
                    			break;
            			case 3: k = scn.nextInt();
                    			input=obj.forward(k);
                    			System.out.println(input);
                    			break;
            			default: return;
        		}
        		i = scn.nextInt();
		}
	}
}
*/
import java.util.*;

//Implementing browser history using Arrya
public class BrowserHistory{
    private String[] history;
    private int curr;
    private int max;
    public BrowserHistory(String homepage){
        history=new String[5001];
            history[0]=homepage;
        curr=0;
        max=0;
    }
    public void visit(String url){
        curr++;
        history[curr]=url;
        max=curr;
        
    }
     public String back(int steps) {
        if(curr-steps<0){
            curr=0;
            return history[curr];
        }
         curr=curr-steps;
         return history[curr];
    }
    public String forward(int steps) {
          if(curr+steps>max){
              curr=max;
              return history[curr];
          }
        curr=curr+steps;
        return history[curr];
        
    }
    

    
}

Implementing browser history using LL
public class BrowserHistory {
    
    class Node{
        Node prev, next;
        String url;
        Node(String url){
            prev=null;
            next=null;
            this.url=url;
        }
    }
  
   Node curr;

    public BrowserHistory(String homepage) {
     curr=new Node(homepage);
    }

    public void visit(String url) {
     Node temp=new Node(url);
        curr.next=temp;
        temp.prev=curr;
        curr=curr.next;
         
        

    }

    public String back(int steps) {
        while(curr.prev!=null && steps-->0){
            curr=curr.prev;
        }
   return curr.url;
    }

    public String forward(int steps) {
        while(curr.next!=null && steps-->0){
            curr=curr.next;
        }
   return curr.url;
        
    }
}
