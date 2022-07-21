Hash Tables

Hash table stores elements in key value pairs
Hash table gives us super fast lookups, and used to optimise lot of algorithms

	Hash table are used in real world applications like - Spell checkers, dictionaries, compilers - to quickly lookup value of address of func and variables, used in code editors

	HashTable has different implementations(names),
		 JAVA - Hashmap, Javascript - Objects, Python and
                          C# - dictionaries

	Eg:
		Key -  employeeNumber is stored in key
		Value - employee object is stored in value

Working:
Now we want to store employee object in a hash table, so our hashtable takes employee number and passes it towards a hash function and this hash func will tell where the employee object should be stored in memory, our hashtable will then store employee object at that location.

Now after storing, if we want to look up an employee object using hashtable, our employee num is passed to hash func and it will tell where the object is stored in memory, so it will grab and return it.

Hashtable is deterministic - Everytime we pass an input, it will return the same value. This is why a hash table is used for both storing and retrieving value.

Operations - Insert, lookup, Delete - all run in O(1)


Sets - Sets are similar like hashtables, but they only allow keys to store.
Another important characteristic of sets is, they don't allow duplicate keys.
In Java, for map interface we have hashmap implementation, similar to that for set interface we have hashset implementation.

Operations - add, addAll, remove, removeAll, isEmpty

While implementing a hashtable we internally use an array, and store the key,value pair at a specific index, using hash function(key % arr.length). But we have a collision problem here, we may have to store two or more key,value pairs at a particular index, but we have already stored a pair at that index, this is the problem we have, this can be solved using different techniques.
Chaining(using LinkedList)
Open Addressing - Linear probing,
Open Addressing - Quadratic probing
Open Addressing - Double Hashing

We will implement the code using chaining technique with array of linkedlist

We have an array of LL and we store a key,value pair as a node and point the index of an array to LL node(we don't store directly in array cell), at some point if we want to store at the same index we simply point or chain to the next node in LL at that array index, this solves the problem of collision.

HashTable Implementation (Link)- github link soon

Summary and TimeComplexity:
To store key,value pairs
Insert, lookup, remove in O(1)
Hash function - hashtable use a hash func to map a key to index value in an  array
Collision problem can be solved using array cells with linked list,(use array index to point to LL node) - not stored directly in array cell
Or we can store directly in array cells using open addressing technique, for this technique there are 3 probing algorithm-
i. Linear - (hash + i) % table_size - This forms clusters together and slows down future insertions or lookups. This is drawback with this approach
ii. Quadratic - (hash + i ^ 2) % table_size - This solves problem of clustering, This makes big jump from one index to another, causing an infinite loop with same indices
iii. Double hashing- (hash1 + i ^ hash2) % table_size, we use second hash function to calculate the index, this solve both of the problems,

Time Complexity - all operations in hashtable runs in O(1)
