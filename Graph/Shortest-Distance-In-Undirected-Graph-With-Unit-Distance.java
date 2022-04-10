//Here we have to find out shortest distance from the given source node to every node
//We are assuming source node is zero

private void shortestPath(ArrayList<ArrayList<Integer>> adj,int N,int src) 
	{ 
		
		int[] dist = new int[N]; 
    	for(int i = 0; i < N; i++) 
    		dist[i] = 1000000000; //We can also initialze with infinity
    
    	Queue<Integer> q=new LinkedList<>();
    	
    	
    	dist[src] = 0;
    	q.add(src); 
    
    	while(q.isEmpty()==false) 
    	{ 
    		int node = q.poll();  
    		 
        //Exploring all the adjacent node of the current node
    		for(int it:adj.get(u)){
    		    if(dist[node] + 1 < dist[it]){
    		        dist[it] = dist[node] + 1;
    		        q.add(it);
    		    }
    		} 
    	}
    	
  //dist[i], every value representing the shortest distance from the source node
    	for(int i = 0;i < N;i++) {
    	    System.out.print(dist[i] + " "); 
    	}
	} 
