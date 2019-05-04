package io.github.wangyuxiang0829.algorithms.chap11;

import io.github.wangyuxiang0829.algorithms.chap10.MyLinkedList;
import io.github.wangyuxiang0829.util.tuple.TwoTuple;

public class MyHashMap<K, V> {
    private MyLinkedList<TwoTuple<K, V>>[] hashTable;


    @SuppressWarnings("unchecked")
    public MyHashMap() {
        hashTable = (MyLinkedList<TwoTuple<K,V>>[]) new MyLinkedList[13];
        for (int i = 0; i < 13; i++)
            hashTable[i] = new MyLinkedList<>();
    }


    public void insert(K key, V value) throws KeyAlreadyExistException {
        if (search(key) != null)
            throw new KeyAlreadyExistException();
        hashTable[key.hashCode() % 13].insert(new TwoTuple<>(key, value));
    }


    public V search(K key) {
        for (TwoTuple<K, V> keyValue : hashTable[key.hashCode() % 13]) {
            if (keyValue.first.equals(key)) {
                return keyValue.second;
            }
        }
        return null;
    }


    public void delete(K key) throws NoSuchKeyException {
        int i = 0;
        boolean flag = false;
        for (TwoTuple<K, V> keyValue : hashTable[key.hashCode() % 13]) {
            if (keyValue.first.equals(key)) {
                flag = true;
                break;
            }
            else
                i++;
        }
        if (flag)
            hashTable[key.hashCode() % 13].delete(i);
        else
            throw new NoSuchKeyException();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (MyLinkedList<TwoTuple<K, V>> linkedList : hashTable)
            stringBuilder.append(linkedList).append("\n");

        return stringBuilder.toString();
    }


    /*
    public static void main(String[] args) {
        MyHashMap<String, Integer> hashTable = new MyHashMap<>();
        try {
            hashTable.insert("Jack", 78);
        } catch (KeyAlreadyExistException e) {
            System.out.println("key \"Jack\" already exist");
        }
        try {
            hashTable.insert("Ming", 84);
        } catch (KeyAlreadyExistException e) {
            System.out.println("key \"Ming\" already exist");
        }
        try {
            hashTable.insert("Jack", 56);
        } catch (KeyAlreadyExistException e) {
            System.out.println("Key \"Jack\" already exist");
        }
        System.out.println(hashTable.search("Jack"));
        try {
            hashTable.delete("Jac");
        } catch (NoSuchKeyException e) {
            System.out.println("no such key \"Jac\"");
        }
        System.out.println(hashTable);
    }*/

}
