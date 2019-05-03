package io.github.wangyuxiang0829.algorithms.chap11;

import io.github.wangyuxiang0829.algorithms.chap10.MyLinkedList;
import io.github.wangyuxiang0829.util.tuple.TwoTuple;

public class MyHashTable<K, V> {
    private MyLinkedList<TwoTuple<K, V>>[] hashTable;

    @SuppressWarnings("unchecked")
    public MyHashTable() {
        hashTable = (MyLinkedList<TwoTuple<K,V>>[]) new MyLinkedList[13];
        for (int i = 0; i < 13; i++)
            hashTable[i] = new MyLinkedList<>();
    }

    public void insert(K key, V value) {
        hashTable[key.hashCode() % 13].insert(new TwoTuple<>(key, value));
    }

    public V search(K key) {
        for (TwoTuple<K, V> twoTuple : hashTable[key.hashCode() % 13]) {
            if (twoTuple.first.equals(key)) {
                return twoTuple.second;
            }
        }
        return null;
    }

    /*
    public static void main(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        hashTable.insert("Jack", 78);
        hashTable.insert("Ming", 84);
        System.out.println(hashTable.search("Jack"));
    }*/

}
