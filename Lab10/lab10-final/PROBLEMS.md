# Lab 10: Hash Tables

In this lab, you will complete and use a Hash Table.

Feel free to put whatever you want in App#main for experimentation.

## Problems

**Problem 1. HashMap**

Complete the code in HashMap.java to implement a Map using a Hash Table,
with chaining via ConsList as the collision resolution mechanism.

The put, get, hasKey, and del operations should be O(1) on average assuming
random looking hashCodes.

A hash table with chaining should stay below 2.0 load factor.

**Problem 2. HashSet**

Complete the code in HashSet.java to build a Set data structure using your
HashMap.

The add, remove, and contains operations should be O(1) on average
assuming random looking hashCodes.

**Problem 3. hashCode**

Write a reasonable hashCode method for the Address class. It should
tend to minimize collisions for reasonable instances of the class and
the hash value should change if any field changes.

Remember that all the fields of Address are of types that have
reasonable hashCode methods provided.

