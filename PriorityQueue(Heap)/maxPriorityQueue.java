import java.util.*;
// TC for insert and remove function, O(logN)
// and for rest O(1)
// SC:O(1)

public class PQ {
	// Complete this class
    private ArrayList<Integer> heap;

	public PQ() {
		heap = new ArrayList<Integer>();
	}
    
	boolean isEmpty() {
		// Implement the isEmpty() function here
        return heap.size()==0;
	}

	int getSize() {
		// Implement the getSize() function here
        return heap.size();
	}

	int getMax() {
        //throws PriorityQueueException{
		// Implement the getMax() function here
        if (isEmpty()) {
			// Throw an exception
			//throw new PriorityQueueException();
		}
		return heap.get(0);
        
	}

	void insert(int element) {
		// Implement the insert() function here
        heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) > heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
        
	}

	int removeMax(){
        //throws PriorityQueueException{
		// Implement the removeMax() function here
        if (isEmpty()) {
			// Throw an exception
			//throw new PriorityQueueException();
		}
        
        int elem=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        
        int p=0;
        int lc=2*p+1;
        int rc=2*p+2;
        while(lc<heap.size()){
            int mi=p;
            if(heap.get(lc)>heap.get(mi)){
                mi=lc;
            }
         if(rc<heap.size() && heap.get(rc)>heap.get(mi)){
                mi=rc;
            }
            if(mi==p){
                break;
            }
            else{
            int temp=heap.get(mi);
            heap.set(mi,heap.get(p));
            heap.set(p,temp);
            p=mi;
            lc=2*p+1;
            rc=2*p+2;
        }
            
            
        }
        return elem;
        

	}
}


class PriorityQueueException extends Exception {

}
