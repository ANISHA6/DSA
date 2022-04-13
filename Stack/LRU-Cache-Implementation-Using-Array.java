public class LRUCache
{
	class Pair{//Pair class for storing key-value together
		int key;
		int value;
		Pair(int key, int value){
			this.key=key;
			this.value=value;
		}
	}
  //Declaring Array of type Pair class
	Pair cache[];
	int size;//Represent, total no. of elements present in cache
	
    LRUCache(int capacity)
    {
        // Write your code here
      //capacity-Maximum no. of elements a cache can hold at a time
		cache=new Pair[capacity];
		int size=0;
		
    }
	
	//self created method to get the index of the key-value pair
	public int getIndex(int key){

		for(int i=0;i<size;i++){
			Pair p=cache[i];
			if(key==p.key){//getting index, if key is already present
				return i;
				}
			
		}
		return -1;
	}
	
//self created method for leftshift
	public void leftshift(int id){
		if(id==size)
			return;
		
		for(int i=id;i<size;i++){
			cache[i-1]=cache[i];
			
		}
	}
	
	
    public int get(int key)
    {
//         Write your code here
			int id=getIndex(key);
		if(id==-1){
			return id;
		}
		Pair p=cache[id];
		leftshift(id+1);//doing leftshift by 1, to make last index available for current use pair
		cache[size-1]=p;//Adding it at last index of array, to make it most recent use
		return p.value;
    }

    public void put(int key, int value)
    {
        // Write your code here
		int id=getIndex(key);
		if(id!=-1){
			leftshift(id+1);
			Pair p=cache[id];
			p.value=value;
			cache[size-1]=p;

		}else{
			Pair p=new Pair(key, value);
			if(size<cache.length){
				cache[size]=p;
				size++;
			}else{
				leftshift(1);
				cache[size-1]=p;
			}
			
		}
	}
}


