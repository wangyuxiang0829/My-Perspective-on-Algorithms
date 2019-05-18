# Hash Table

## Introduction

In computing, a **hash table** or **hash map** is a data structure that implements associative array abstract data type, a structure that can map **keys** to **values**. A hash table uses a **hash function** to compute an *index* into an array of *buckets* or *slots*, from which the desired value can be found.

Ideally, the **hash function** will assign each key to a unique slot, but most hash table designs employ an imperfect hash function, which might cause hash *collisions* where the hash function generates the same index for more than one key. Such collisions must be accommodated in some way.

In a well-dimensioned hash table, the average cost (number of instructions) for each lookup is independent of the number of elements stored in the table. In other words T(n) = O(1). Many hash table designs also allow arbitrary insertions and deletions of key-value pairs, at constant average cost per operation.



![hash_table](D:\10673\Documents\My-Perspective-on-Algorithms\src\io\github\wangyuxiang0829\algorithms\chap11\overview\hash_table.png)