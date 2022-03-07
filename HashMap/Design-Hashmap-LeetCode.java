class MyHashMap {
    LinkedList<Entry>[] map;
    public static int SIZE=769;

    public MyHashMap() {
        map=new LinkedList[SIZE];
        
    }
    
    public void put(int key, int value) {
       int bucket=key%SIZE;
        if(map[bucket]==null){
            map[bucket]=new LinkedList<Entry>();
            map[bucket].add(new Entry(key, value));
        }
        else{
            for(Entry entry:map[bucket]){
                if(entry.key==key){
                    entry.value=value;
                    return;
                }
            }
            map[bucket].add(new Entry(key, value));
        }

       
        
    }
    
    public int get(int key) {
         int bucket=key%SIZE;
        LinkedList<Entry> entries=map[bucket];
        if(entries==null) return -1;
        for(Entry entry:entries){
            if(entry.key==key){
                return entry.value;
            }
        }
        return -1;
        
    }
    
    public void remove(int key) {
        int bucket=key%SIZE;
        Entry toRemove=null;
        if(map[bucket]== null) return;
        else{
            for(Entry entry:map[bucket]){
                if(entry.key==key){
                    toRemove=entry;
                }
            }
            if(toRemove==null) return;
            map[bucket].remove(toRemove);
        }
        
    }
}
class Entry{
    public int key;
    public int value;
    public Entry(int key, int value){
        this.key=key;
        this.value=value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
