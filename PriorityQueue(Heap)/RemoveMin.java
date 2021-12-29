import java.util.ArrayList;
// Code for minimum priority queue
public class PQ {

	private ArrayList<Integer> heap;

	public PQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;//Because, element is inserted in the last of ArrayList
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {//if childIndex becomes zero i.e no parent available
			if (heap.get(childIndex) < heap.get(parentIndex)) {//if priority of parent greater than child then swap
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;// For up-heapify operation
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	int removeMin()throws PriorityQueueException {//TC:O(logN), SC:O(1)
		// Complete this function
		// Throw the exception PriorityQueueException if queue is empty
        
        if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
        
        int elem=heap.get(0);//Min element present at index zero
        heap.set(0,heap.get(heap.size()-1));// Replace first element to last element
        heap.remove(heap.size()-1);// Remove last element
        
        int p=0;//Down heapify for heap order property
        int lc=2*p+1;
        int rc=2*p+2;
        while(lc<heap.size()){
            int mi=p;//Assume, by default min is parent index
            if(heap.get(lc)<heap.get(mi)){// finding minimun among parent, leftchild, and rightchild
                mi=lc;
            }
         if(rc<heap.size() && heap.get(rc)<heap.get(mi)){
                mi=rc;
            }
            if(mi==p){
                break;
            }
            int temp=heap.get(mi);
            heap.set(mi,heap.get(p));
            heap.set(p,temp);
            p=mi;
            lc=2*p+1;
            rc=2*p+2;
            
            
        }
        return elem;
        
	}
}

class PriorityQueueException extends Exception {

}
