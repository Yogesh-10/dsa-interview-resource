package com.yogesh.Hashtables;

import java.util.LinkedList;

//Basically, hashtable stores key, value pairs in index of array, but we may have two or more pairs at same index
//we implement hashtable using array of linkedList(LinkedList[]) to solve collision problem, because
//at a specific index, we may store two or more key,value pairs which results in collision,
//there are lot of techniques to solve this problem.
//Collision problem can be solved using array cells with linked list,(use array index to point to LL node) - not stored directly in array cell
// 1.chaining(using LinkedList), 2.Open Addressing - Linear probing, 3.Open Addressing - Quadratic probing, 4.Open Addressing - Double Hashing
//we will be using chaining technique here
public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value){
        //storing index value from hash function
        int index = hash(key);
        //if that index at entries LL Array is null create new instance of LinkedList
        //eg: array will be like - [null ,null, null, null, null] initially,
        //so if index is 0, we add new LinkedList at index-0, so now array will be like,
        //[LL ,null, null, null, null], and then we can use that LL to store key and value
        //technically we are not storing value directly at that index(cell), but point that cell to LL node
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        //To avoid duplicate keys,-> Iterate through that LL Node, If
        // we find entry with same key, then update or overwrite the value
        for (Entry entry : entries[index]){
            if (entry.key == key){
                entry.value = value;
                return; //we return immediately so below lines are not executed
            }
        }
        //otherwise, add new entry at end of linked list
        //or if there is already a LL at that index, we simply link it to that node
        //for eg: we are adding 'b', and 'a' is already present there
        //so LL will be, a -> b. This is why we call this as chaining approach, where collision problem will be solved
        Entry entry = new Entry(key, value);
        entries[index].addLast(entry);
    }

    //HashTable use a hashFunction to map a key to index value
    //HashFunction will tell where the object should be stored in
    // memory, and our HashTable will store the object at that location
    //Find the index stored in memory
    //Below is simple algorithm for hashFunction method, that returns the index
    //so using that index we can store our value at that index
    //key % entries.length gives us the index, which will be in the limit with in
    //linked list array, so it will not go out of bounds
    private int hash(int key){
        return key % entries.length; //to keep index value with in array, so it will not go out of bounds
    }

    public String get(int key) {
        //first we have to pass the key to hash function, because we have to find
        //at which index we have stored the key,value pair
        int index = hash(key);

        //we iterate through LL at the index returned from hash function,
        //and find if key is present -- if yes, return value, or else return null
        if (entries[index] != null) {
            for (Entry entry : entries[index])
                if (entry.key == key)
                    return entry.value;
        }
        return null;
    }

    public void remove(int key){
        int index = hash(key);

        if (entries[index] == null)
            throw new IllegalStateException(); //for simplicity we throw this exception, we can create custom exception like EntryNotFoundException

        for (Entry entry : entries[index])
            if (entry.key == key) {
                entries[index].remove();
                return;
            }
        throw new IllegalStateException();
    }

}
