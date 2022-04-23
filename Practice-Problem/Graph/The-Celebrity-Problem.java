//Method 1, using graph

/*
    Time complexity: O(N*N)
    Space complexity: O(N)
	
    Where 'N' is the number of people at the party.
*/
	
public class Solution {
	public static int findCelebrity(int n) {

        // Calculating indegree and outdegree of each nodes.
	    int[] indegree = new int[n];
	    int[] outdegree = new int[n];

	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < n; j++) {
	            if(Runner.knows(i, j)) {
	                indegree[j]++;
	                outdegree[i]++;
	            }
	        }
	    }

	    // Finding Celebrity.
	    int celebrity = -1;

	    for(int i = 0; i < n; i++) {
	        if(indegree[i] == n - 1 && outdegree[i] == 0) {
	            celebrity = i;
	            break;
	        }
	    }

	    return celebrity;
    }
}

//Method 2, using brute force approach

/*
    Time complexity: O(N*N)
    Space complexity: O(1)
    
    Where 'N' is the number of people at the party.
*/
	
public class Solution {
	public static int findCelebrity(int n) {

        int celebrity = -1;

	    // Check one by one whether the person is a celebrity or not.
	    for(int i = 0; i < n; i++) {
	        boolean knowAny = false, knownToAll = true;

	        // Check whether perosn with id 'i' knows any other person.
	        for(int j = 0; j < n; j++) {
	            if(Runner.knows(i, j)) {
	                knowAny = true;
	                break;
	            }
	        }

	        // Check whether perosn with id 'i' is known to all the other person.
	        for(int j = 0; j < n; j++) {
	            if(i != j && !Runner.knows(j, i)) {
	                knownToAll = false;
	                break;
	            }
	        }

	        if(!knowAny && knownToAll) {
	            celebrity = i;
	            break;
	        }
	    }

	    return celebrity;
    }
}

//Method3, using two pointer approach

/*
    Time complexity: O(N)
    Space complexity: O(1)
    
    Where 'N' is the number of people at the party.
*/

public class Solution {
	public static int findCelebrity(int n) {

        // Two pointers pointing at start and end of search space.
	    int p = 0, q = n - 1; 

	    // Finding celebrity.
	    while(p < q) {
	        if(Runner.knows(p, q)) {
	            // This means p cannot be celebrity.
	            p++;  
	        }
	        else {
	            // This means q cannot be celebrity.
	            q--; 
	        }
	    }

	    int celebrity = p;
	    boolean knowAny = false, knownToAll = true;

	    // Verify whether the celebrity knows any other person.
	    for(int i = 0; i < n; i++) {
	        if(Runner.knows(celebrity, i)) {
	            knowAny = true;
	            break;
	        }
	    }

	    // Verify whether the celebrity is known to all the other person.
	    for(int i = 0; i < n; i++) {
	        if(i != celebrity && !Runner.knows(i, celebrity)) {
	            knownToAll = false;
	            break;
	        }
	    }

	    if(knowAny || !knownToAll) {
	        // If verificatin failed, then it means there is no celebrity at the party.
	        celebrity = -1;
	    }

	    return celebrity;
    }
}
