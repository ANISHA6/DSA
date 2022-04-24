import java.util.*;
/***************************************************************************

  Class for graph node is as follows:

  class graphNode {
      public int data;
      public ArrayList<graphNode> neighbours;

      graphNode() {
          data = 0;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val) {
          data = val;
          neighbours = new ArrayList<graphNode>();
      }

      graphNode(int val, ArrayList<graphNode> neighbours) {
          data = val;
          this.neighbours = neighbours;
      }
    }

******************************************************************************/
//Method1 using dfs
TC:O(N+M), N is the no. of nodes and M is the no. edges
SC:O(N)

public class Solution {
	
	public static graphNode dfs(graphNode curr, HashMap<graphNode, graphNode> map){
		ArrayList<graphNode> neighbours=new ArrayList<graphNode>();
			graphNode clone=new graphNode(curr.data);
		map.put(curr, clone);
    
		for(graphNode it: curr.neighbours){
			if(map.containsKey(it)){
				neighbours.add(map.get(it));
			}else{
				dfs(it, map);
			}
			
		}
		clone.neighbours=neighbours;
			return clone;
		
		
	}
    public static graphNode cloneGraph(graphNode node) {
        // Write your code here.
      //Base case
		if(node==null){
			return null;
		}
		if(node.neighbours.size()==0){
			graphNode clone=new graphNode(node.data);//for single node , create its clone and return
			return clone;
		}
		HashMap<graphNode, graphNode> map=new HashMap<>();
		return dfs(node, map);
		
		}
}

//Method 2 , using bfs

/*
    Time Complexity: O(N + M)
    Space Complexity: O(N)

    Where N is the number of nodes
    and M is the number of edges in the given graph.
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class Solution {
	public static graphNode cloneGraphHelper(graphNode node, HashMap<graphNode, graphNode> copies) {

		if (node == null) {
			return null;
		}

		// Create a graph node which denotes the node of the cloned graph.
		graphNode copy = new graphNode(node.data);

		// Update the HashMap.
		copies.put(node, copy);

		// Queue used for the BFS.
		Queue<graphNode> level = new LinkedList<>();

		// Push source node.
		level.add(node);

		while (!level.isEmpty()) {
			// Take the the front element from the queue.
			graphNode cur = level.poll();

			// Get corresponding Cloned Graph Node.
			graphNode cloneNodeU = copies.get(cur);
			if (cur.neighbours != null) {
				ArrayList<graphNode> v = cur.neighbours;
				for (graphNode GraphNode : v) {
          
					/*
					  Get the corresponding cloned node 
            if the node is not cloned then we will
					  simply get a null.
					 */
					graphNode cloneNodeG = copies.get(GraphNode);

					// Check if this node has already been created.
					if (cloneNodeG == null) {
						level.add(GraphNode);

						
						/*
              If not then create a new Node 
              and put into the HashMap.
						*/
            cloneNodeG = new graphNode(GraphNode.data);
						copies.put(GraphNode, cloneNodeG);
					}

					/*
					  Add the 'cloneNodeG' to neighbour 
            array List of the cloneNodeG.
					*/
					cloneNodeU.neighbours.add(cloneNodeG);
				}
			}
		}

		return copies.get(node);
	}

	public static graphNode cloneGraph(graphNode node) {
		// Create a HashMap.
		HashMap<graphNode, graphNode> copies = new HashMap<>();

		// Return the source node of cloned graph.
		return cloneGraphHelper(node, copies);
	}
}
