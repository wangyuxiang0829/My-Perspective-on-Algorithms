package io.github.wangyuxiang0829.algorithms.chap11;

import io.github.wangyuxiang0829.algorithms.chap10.MyLinkedList;
import io.github.wangyuxiang0829.util.tuple.TwoTuple;

public class MyChainingHashTable<K, V> implements MyHashTable<K, V> {
    private MyLinkedList<TwoTuple<K, V>>[] hashTable;


    @SuppressWarnings("unchecked")
    public MyChainingHashTable() {

        hashTable = (MyLinkedList<TwoTuple<K, V>>[]) new MyLinkedList<?>[13];

        for (int i = 0; i < 13; i++)
            hashTable[i] = new MyLinkedList<>();

    }


    @Override
    public void insert(K KEY, V VALUE) throws KeyAlreadyExistException {

        if (search(KEY) != null)
            throw new KeyAlreadyExistException();

        hashTable[KEY.hashCode() % 13].insert(new TwoTuple<>(KEY, VALUE));

    }


    @Override
    public V search(K KEY) {

        for (TwoTuple<K, V> keyValue : hashTable[KEY.hashCode() % 13]) {

            if (keyValue.first.equals(KEY)) {
                return keyValue.second;
            }

        }

        return null;

    }


    @Override
    @SuppressWarnings("unchecked")
    public void delete(K KEY) throws NoSuchKeyException {

        MyLinkedList<TwoTuple<K, V>> slot = hashTable[KEY.hashCode() % 13];

        MyLinkedList.Node node = slot.getSentinel().getNext();

        for (TwoTuple<K, V> keyValue : slot) {

            if (keyValue.first.equals(KEY)) {
                break;
            }
            else {
                node = node.getNext();
            }

        }

        if (node == slot.getSentinel()) {
            throw new NoSuchKeyException();
        }
        else {
            slot.delete(node);
        }

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
        MyHashTable<String, Integer> hashTable = new MyChainingHashTable<>();
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
