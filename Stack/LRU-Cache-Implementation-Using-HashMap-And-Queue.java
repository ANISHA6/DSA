/*
    Time Complexity: O(Q) 
    Space Complexity: O(capacity)
    
    where Q is the number of the given queries and 
    capacity is the maximum number of keys LRU Cache can store.
*/

import java.util.HashMap;

class Node
{
    Node left, right;
    int key, val;

    Node(int key, int val)
    {
        this.key = key;
        this.val = val;
        left = null;
        right = null;
    }
}

public class LRUCache
{
    HashMap<Integer, Node> map;
    Node tail, head;
    int capacity, size;
    
    // Initialize LRUCache
    public LRUCache(int capacity)
    {
        map = new HashMap();
        this.capacity = capacity;
        size = 0;
        head = null;
        tail = null;
    }

    public void deleteNode(Node nod)
    {
        if (nod.left != null)
        {
            nod.left.right = nod.right;
        }
        else
        {
            head = head.right;
        }

        if (nod.right != null)
        {
            nod.right.left = nod.left;
        }
        else
        {
            tail = tail.left;
        }

        nod.right = null;
        nod.left = null;
    }
    
    // Add node at rear of linked list,
    public void addToRear(Node nod)
    {
        if (head == null)
        {
            head = nod;
            tail = nod;
            return;
        }

        tail.right = nod;
        nod.left = tail;
        tail = nod;
    }
    
    // Return the value of the given key
    public int get(int key)
    {
        if (!map.containsKey(key))
        {
            return -1;
        }
        Node nod = map.get(key);

        deleteNode(nod);
        addToRear(nod);

        return nod.val;
    }
    
    // Inserts a key and it's value into the LRUCache
    public void put(int key, int value)
    {
        if (map.containsKey(key))
        {
            Node nod = map.get(key);
            nod.val = value;

            deleteNode(nod);
            addToRear(nod);
        }
        else
        {
            Node nod = new Node(key, value);
            map.put(key, nod);

            if (size == capacity)
            {
                map.remove(head.key);
                deleteNode(head);
                addToRear(nod);
            }
            else
            {
                addToRear(nod);
                size++;
            }
        }
    }
}


