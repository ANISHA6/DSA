* Internal hashmap is implemented through hash table


There are many DS to implement the Hashmap, but we have to implement in sach a way that, all operation can be done in O(1) TC.
  1.  If we use LinkedList , it takes TC:O(1) for insertion and for rest operations O(N).
  2.  Another DS for implementing Hashmap is balance search tree (BST), In BST, height is always log n, so TC for all operation will be O(log n).
  
  3.  Here, i have implemented hashmap using ArrayList because of its direct access  and internally also used LL.
    . every index of ArrayList will contain head of the LL.
    .we will get the index of arrayList throgh Hash function(Hashcode and compression)




/*
    Time complexity : O(1) [for all operations]
    Space complexity : O(N)

    where 'N' is the number of elements in the HashMap.
*/

import java.util.ArrayList;

class Entry 
{
    String key;
    int value;
    Entry next;

    public Entry(String key, int value) 
    {
        this.key = key;
        this.value = value;
    }

    public Entry() 
    {
        this.key = new String();
        this.value = 0;
    }
}

public class myHashMap 
{
    private ArrayList<Entry> buckets;
    private int size;

    public myHashMap() 
    {
        this.buckets = new ArrayList<>();
        this.size = 0;

        // Initialise bucket list with 3 elements.
        for (int i = 0; i < 3; i++) 
        {
            this.buckets.add(null);
        }
    }

    // This function find the bucket index for the string key.
    private int getBucketIndex(String key) 
    {  
        int hashcode = key.hashCode();
        int bucketIndex = ((hashcode % this.buckets.size()) + this.buckets.size()) % this.buckets.size();
        return bucketIndex;
    }
    
    // This function doubles the size of HashMap.
    private void rehash() 
    {
        ArrayList<Entry> temp = this.buckets;
        this.buckets = new ArrayList<>();
        
        // Increasing the size of buckets.
        for (int i = 0; i < temp.size() * 2; i++) 
        {
            this.buckets.add(null);
        }

        this.size = 0;
        
        // Insert all key from temp into buckets.
        for (int i = 0; i < temp.size(); i++) 
        {
            Entry head = temp.get(i);
            Entry current = head;

            while (current != null) 
            {
                this.insert(current.key, current.value);
                current = current.next;
            }
        }
    }

    public int get(String key) 
    {   
        // Finding the bucket index for the key.
        int bucketIndex = this.getBucketIndex(key);
        
        Entry head = this.buckets.get(bucketIndex);
        Entry temp = head;
        
        // Traverse through the buckets[bucketIndex].
        while (temp != null) 
        {
            if (temp.key.equals(key)) 
            {   
                // Returns the integer value stored against the given key.
                return temp.value;
            }

            temp = temp.next;
        }

        return -1;
    }

    public void insert(String key, int value) 
    {
        // Finding the bucket index for the key.
        int bucketIndex = this.getBucketIndex(key);
        
        Entry head = this.buckets.get(bucketIndex);
        Entry newNode = new Entry();

        newNode.key = key;
        newNode.value = value;

        if (head == null) 
        {
            this.buckets.set(bucketIndex, newNode);
            this.size += 1;
        } 
        else 
        {
            Entry temp = head;
            Entry prev = null;
            
            // Check if key is already present in HashMap by traversing through the buckets[bucketIndex].
            while (temp != null) 
            {
                if (temp.key.equals(key)) 
                {
                    temp.value = value;
                    return;
                }

                prev = temp;
                temp = temp.next;
            }

            prev.next = newNode;
            this.size += 1;
        }
        
        // Find the load factor of the HashMap.
        double loadFactor = (size * 1.0) / buckets.size();
        
        // Check if loadFactor is greater than 0.75.
        if (loadFactor >= 0.75) 
        {
            this.rehash();
        }
    }

    public void remove(String key) 
    {   
        // Finding the bucket index for the key.
        int bucketIndex = this.getBucketIndex(key);
        Entry head = this.buckets.get(bucketIndex);

        if (head == null) 
        {
            return;
        }

        Entry temp = head;
        Entry prev = null;
        
        // Traverse through the buckets[bucketIndex].
        while (temp != null) 
        {
            if (temp.key.equals(key)) 
            {   
                // Delete the key from the HashMap and decrement size by 1.
                if (prev == null) 
                {
                    this.buckets.set(bucketIndex, head.next);
                } 
                else 
                {
                    prev.next = temp.next;
                }

                this.size -= 1;

                return;
            }

            prev = temp;
            temp = temp.next;
        }
    }

    public boolean search(String key) 
    {    
        // Check if key is not present in the HashMap.
        if (this.get(key) == -1) 
        {
            return false;
        }

        return true;
    }

    public int getSize() 
    {
        // Return the size of HashMap.
        return this.size;
    }

    public boolean isEmpty()
    {
        // Check if the size of HashMap is equal to 0.
        return this.getSize() == 0;
    }
}
