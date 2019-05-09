package io.github.wangyuxiang0829.algorithms.chap11;

import io.github.wangyuxiang0829.algorithms.chap10.MyLinkedList;
import io.github.wangyuxiang0829.util.tuple.TwoTuple;

public class MyHashMap<K, V> {
    private MyLinkedList<TwoTuple<K, V>>[] hashTable;


    @SuppressWarnings("unchecked")
    public MyHashMap() {
        hashTable = (MyLinkedList<TwoTuple<K, V>>[]) new MyLinkedList<?>[13];
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


    @SuppressWarnings("unchecked")
    public void delete(K key) throws NoSuchKeyException {
        MyLinkedList<TwoTuple<K, V>> slot = hashTable[key.hashCode() % 13];
        MyLinkedList.Node node = slot.getSentinel().getNext();
        for (TwoTuple<K, V> keyValue : slot) {
            if (keyValue.first.equals(key))
                break;
            else
                node = node.getNext();
        }
        if (node == slot.getSentinel())
            throw new NoSuchKeyException();
        else
            slot.delete(node);
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
        hashTable.insert("Jack", 78);
        hashTable.insert("Ming", 84);
        // hashTable.insert("Jack", 56);
        System.out.println(hashTable.search("Jack"));
        // hashTable.delete("Lucy");
        hashTable.insert("Lucy", 93);
        hashTable.delete("Ming");
        System.out.println(hashTable);
    }*/

}
