# **Hash Tables**

## Overview

Hashing is a technique or process of mapping keys, values into the hash table by using a hash function. It is done for faster access to elements. The efficiency of mapping depends on the efficiency of the hash function used.

Before going into Hashing let’s understand what is **mapping**

**Mapping** is the way of linking 2 things together, referred to as “Key” and “Value”. Key – An Identifier to uniquely identify the Data(Entity).Value – The Actual Entity(and its details) which we want to store.

Hashing is a way where we can get an value from any Key. This Key may or may not be an integer, but after hashing is performed, it will return an Integer value for any Key.

**Hashing**

is a method of storing and retrieving data from a database efficiently.

Suppose that we want to design a system for storing employee records keyed using phone numbers. And we want the following queries to be performed efficiently:

1. Insert a phone number and the corresponding information.
2. Search a phone number and fetch the information.
3. Delete a phone number and the related information.

We can think of using the following data structures to maintain information about different phone numbers.

1. An array of phone numbers and records.
2. A linked list of phone numbers and records.
3. A balanced binary search tree with phone numbers as keys.
4. A direct access table.

For A**rrays and Linked lists,** we need to search in a linear fashion, which can be costly in practice. If we use arrays and keep the data sorted, then a phone number can be searched in O(Logn) time using Binary Search, but insert and delete operations become costly as we have to maintain sorted order.

With a **balanced binary search tree**, we get a moderate search, insert and delete time. All of these operations can be guaranteed to be in O(Logn) time.

Another solution that one can think of is to use a **direct access table** where we make a big array and use phone numbers as indexes in the array. An entry in the array is NIL if the phone number is not present, else the array entry stores pointer to records corresponding to the phone number. Time complexity wise this solution is the best of all, we can do all operations in O(1) time. For example, to insert a phone number, we create a record with details of the given phone number, use the phone number as an index and store the pointer to the record created in the table.

This solution has many practical limitations. The first problem with this solution is that the extra space required is huge. For example, if the phone number is of n digits, we need 

O(m * 10^n) space for the table where m is the size of a pointer to the record. Another problem is an integer in a programming language may not store n digits.

Due to the above limitations, the Direct Access Table cannot always be used.

### **Hashing:**
Hashing is the solution that can be used in almost all such situations and performs extremely well as compared to above data structures like Array, Linked List, Balanced BST in practice. With hashing, we get O(1) search time on average (under reasonable assumptions) and O(n) in the worst case.

Hashing is an important method designed to solve the problem of efficiently finding and storing data in an array.

A hash table (commonly referred to as hash map) is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function on an element to compute an index, also called a hash code, into an array of buckets or slots, from which the desired value can be found. During lookup, the key is hashed and the resulting hash indicates where the corresponding value is stored.

Hashing is the most common example of a space-time tradeoff. Instead of linearly searching an array every time to determine if an element is present, which takes O(n) time, we can traverse the array once and hash all the elements into a hash table. Determining if the element is present is a simple matter of hashing the element and seeing if it exists in the hash table, which is O(1) on average.

### **Hash Function:**

A function that converts a given big phone number to a small practical integer value. The mapped integer value is used as an index in the hash table. In simple terms, a hash function maps a big number or string to a small integer that can be used as an index in the hash table.

A good hash function should have following properties:

1. It should be efficiently computable.
2. It should uniformly distribute the keys (Each table position be equally likely for each key).

For example, for phone numbers, a bad hash function is to take the first three digits. A better function will consider the last three digits. Please note that this may not be the best hash function. There may be better ways.

#### **Hash Table:**
An array that stores pointers to records corresponding to a given phone number. An entry in hash table is NIL if no existing phone number has hash function value equal to the index for the entry.

### **Collision Handling:**

Since a hash function gets us a small number for a big key, there is a possibility that two keys result in the same value. The situation where a newly inserted key maps to an already occupied slot in the hash table is called collision and must be handled using some collision handling technique. Following are the ways to handle collisions:

- **Chaining:** The idea is to make each cell of the hash table point to a linked list of records that have the same hash function value. Chaining is simple, but it requires additional memory outside the table.
- **Open Addressing:** In open addressing, all elements are stored in the hash table itself. Each table entry contains either a record or NIL. When searching for an element, we one by one examine the table slots until the desired element is found or it is clear that the element is not present in the table.

**Open Addressing**
Like separate chaining, open addressing is a method for handling collisions. In Open Addressing, all elements are stored in the hash table itself. So at any point, the size of the table must be greater than or equal to the total number of keys (Note that we can increase table size by copying old data if needed).

**Important Operations**:

- Insert(k): Keep probing until an empty slot is found. Once an empty slot is found, insert k.
- Search(k): Keep probing until the slot's key doesn't become equal to k or an empty slot is reached.
- Delete(k): ***Delete operation is interesting***. If we simply delete a key, then the search may fail. So slots of the deleted keys are marked specially as "deleted".

**Open Addressing is done in the following ways**:

1. ***Linear Probing:*** In linear probing, we linearly probe for the next slot. For example, the typical gap between the two probes is 1 as taken in the below example also.let **hash(x)** be the slot index computed using a hash function and **S** be the table size.

```jsx
If slot hash(x) % S is full, then we try (hash(x) + 1) % S
If (hash(x) + 1) % S is also full, then we try (hash(x) + 2) % S
If (hash(x) + 2) % S is also full, then we try (hash(x) + 3) % S 
..................................................
..................................................
```

Let us consider a simple hash function as “key mod 7” and a sequence of keys as 50, 700, 76, 85, 92, 73, 101.

![Hashtable](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/8cd0920f-0eba-4985-9a26-0e15e43da0e1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220726%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220726T155930Z&X-Amz-Expires=86400&X-Amz-Signature=8c9b5450bbb8ec7e458599d9e2679e25eeb63e309da66277d61eb7ca03e7b794&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

**Clustering:** The main problem with linear probing is clustering, many consecutive elements form groups and it starts taking time to find a free slot or to search an element.

1. ***Quadratic Probing*** We look for i^2 ‘th slot in i'th iteration.
    
    ```jsx
    let hash(x) be the slot index computed using hash function.
    If slot hash(x) % S is full, then we try (hash(x) + 1*1) % S
    If (hash(x) + 1*1) % S is also full, then we try (hash(x) + 2*2) % S
    If (hash(x) + 2*2) % S is also full, then we try (hash(x) + 3*3) % S
    ..................................................
    ..................................................
    ```
    
2. **Double Hashing** We use another hash function hash2(x) and look for i*hash2(x) slot in i'th rotation.
    
    ```jsx
    let hash(x) be the slot index computed using hash function.
    If slot hash(x) % S is full, then we try (hash(x) + 1*hash2(x)) % S
    If (hash(x) + 1*hash2(x)) % S is also full, then we try (hash(x) + 2*hash2(x)) % S
    If (hash(x) + 2*hash2(x)) % S is also full, then we try (hash(x) + 3*hash2(x)) % S
    ..................................................
    ..................................................
    ```
    

**Comparison of above three:**

- Linear probing has the best cache performance but it suffers from clustering. One more advantage of Linear probing that it is easy to compute.
- Quadratic probing lies between the two in terms of cache performance and clustering.
- Double hashing has poor cache performance but no clustering. Double hashing requires more computation time as two hash functions need to be computed.

## **Diff b/w Chaining and Open Addressing** 

| Seperate Chaining | Open Addressing |
| --- | --- |
| Chaining is Simpler to implement. | Open Addressing requires more computation. |
| In chaining, Hash table never fills up, we can always add more elements to chain. | In open addressing, table may become full. |
| Chaining is Less sensitive to the hash function or load factors. | Open addressing requires extra care for to avoid clustering and load factor. |
| Chaining is mostly used when it is unknown how many and how frequently keys may be inserted or deleted. | Open addressing is used when the frequency and number of keys is known. |
| Cache performance of chaining is not good as keys are stored using linked list. | Open addressing provides better cache performance as everything is stored in the same table. |
| Wastage of Space (Some Parts of hash table in chaining are never used). | In Open addressing, a slot can be used even if an input doesn't map to it. |
| Chaining uses extra space for links. | No links in Open addressing |

#### **Performance of Open Addressing:**
 Like Chaining, the performance of hashing can be evaluated under the assumption that each key is equally likely to be hashed to any slot of the table (simple uniform hashing).

```jsx
m = Number of slots in the hash table
n = Number of keys to be inserted in the hash table
 
Load factor α = n/m  ( < 1 )

Expected time to search/insert/delete < 1/(1 - α) 

So Search, Insert and Delete take (1/(1 - α)) time
```

### **Advantages of Hashing**
As we have seen, hashing improves the insertion and lookup significantly.
To insert and lookup large data elements will be a costly operation.
E.g. Consider the simple example of the Address table, where we store the address of people in the Database(or Arrays/hash tables e.g.).
Here each row will contain big Strings containing Addresses.
To search if a particular address exists in the table, we would need to compare each row and then each character of the address contained in each row.
Now compare this with using Hashing:
While inserting, we can take a hash to find the index to store this address too.

When we need to look up, we can again calculate the hash and can go to the index we got to fetch the data from there. Hence if you compare it takes constant time to calculate the Hash(as it’s just a mathematical formula) and the lookups and insertions are hence reduced to constant time i.e. O(1).

Being able to look up and insert data on the order of O(1), independent of the size of the data structure is the biggest advantage of Hashing.

However, nothing is perfect.

Hashing also suffers from O(N) worst-case time complexity.

If too many elements were hashed into the same Index: looking at the chained elements at this index may take O(n) time, n being the number of elements in that chain. And in the worst case all elements can get linked to the same Index, hence giving the Worst Case Time Complexity of O(N), N being total elements in the HashTable.
Note that in such a case, the HashTable will just be a chain of elements, or just be a LinkedList, and search in LinkedList = O(N).

To understand with an example, say if chaining is used, and say 10 elements were chained to 1 single Index. Then to search back we need to linearly search in these 10 elements chained together.

So it becomes very important to choose a hash function that is able to distribute the elements as evenly as possible, to get the average Constant time for its operations.


### ***Quick Recap (conclusion)***
Hashing is a technique to find a small Number from some Data provided as an input. This number can be used to find the location to store this data at. This could be an index in Arrays or the Memory location on the disk in case of Database storage.

Hashing method is used to index and retrieve items as it is faster to search that specific item using the shorter hashed key instead of using its original value.
Data bucket, Key, Hash function, Linear Probing, Quadratic probing, Hash index,Collisions are important terminologies used in hashing.
In case the resultant index for 2 different inputs comes to be the same, it’s called a collision.
Rehashing and chaining are two methods that help you to avoid hashing collisions.
Rehashing is where we keep on hashing until we find the vacant index, and chaining is where we let both these values be placed at the same index with these values chained to each other.
Using hashing we can get the Insertion and Search done in Constant Time i.e. O(1) in Average/ cases.
A good hash function must be chosen, which can bring the complexity close to O(1) if it is able to distribute the elements as evenly as possible.

1. Hash table stores elements in key value pairs
2. Hash table gives us super fast lookups, and used to optimize lot of algorithms
3. Hash table are used in real world applications like,
4. Spell checkers, dictionaries, compilers - to quickly lookup value of address of func and variables, used in code editors
5. HashTable has different implementations(names),
6. hashtable have differeny names, in JAVA - Hashmap, Javascript - Objects, Python and C# - dictionaries

Example:
Key -  employeeNumber is stored in key
Value - employee object is stored in value

#### Working:
Now we want to store employee object in a hash table, so our hashtable takes employee number and passes it towards a hash function and this hash func will tell where the employee object should be stored in memory, our hashtable will then store employee object at that location. Now after storing, if we want to look up an employee object using hashtable, our employee num is passed to hash func and it will tell where the object is stored in memory, so it will grab and return it.

Hashtable is deterministic - Everytime we pass an input, it will return the same value. This is why a hash table is used for both storing and retrieving value.

#### Operations - Insert, lookup, Delete - all run in O(1)

#### Sets -
1. Sets are similar like hashtables, but they only allow keys to store.
2. Another important characteristic of sets is, they don't allow duplicate keys.
3. In Java, for map interface we have hashmap implementation, similar to that for set interface we have hashset implementation.
4. Operations - add, addAll, remove, removeAll, isEmpty

#### Implementation of HashTable:
While implementing a hashtable we internally use an array, and store the key,value pair at a specific index, using hash function(key % arr.length). But we have a collision problem here, we may have to store two or more key,value pairs at a particular index, but we have already stored a pair at that index, this is the problem we have, this can be solved using different techniques.

1. Chaining(using LinkedList)
2. Open Addressing - Linear probing,
3. Open Addressing - Quadratic probing
4. Open Addressing - Double Hashing

#### TimeComplexity - Open Addressing:
**i. Linear - (hash + i) % table_size** - This forms clusters together and slows down future insertions or lookups. This is drawback with this approach

**ii. Quadratic - (hash + i ^ 2) % table_size** - This solves problem of clustering, This makes big jump from one index to another, causing an infinite loop with same indices

**iii. Double hashing- (hash1 + i ^ hash2) % table_size**, we use second hash function to calculate the index, this solve both of the problems,

Time Complexity - all operations in hashtable runs in O(1)

### ***Reference Materials***
1. Hashing - Scaler Topics - https://www.scaler.com/topics/data-structures/hashing-in-data-structure/
2. Hashing - Hackerearth - https://www.hackerearth.com/practice/data-structures/hash-tables/basics-of-hash-tables/tutorial/
3. Programiz - https://www.programiz.com/dsa/hash-table
4. Tech Interview Handbook - https://www.techinterviewhandbook.org/algorithms/hash-table/
5. GFG - https://www.geeksforgeeks.org/hashing-data-structure/
