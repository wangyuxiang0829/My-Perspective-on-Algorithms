package io.github.wangyuxiang0829.algorithms.chap11;

import static io.github.wangyuxiang0829.algorithms.chap11.HashFunctions.*;
import io.github.wangyuxiang0829.algorithms.chap10.MyLinkedList;
import io.github.wangyuxiang0829.util.tuple.TwoTuple;
import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @param <K>
 * @param <V>
 */
public class MyChainingHashTable<K, V> implements MyHashTable<K, V> {
    private static final int RANDOM_INT = new Random().nextInt();
    private MyLinkedList<TwoTuple<K, V>>[] slots;



    public MyChainingHashTable() {

        this(BigInteger.probablePrime(5, new Random()).intValueExact());

    }


    @SuppressWarnings("unchecked")
    public MyChainingHashTable(int m) {

        slots = (MyLinkedList<TwoTuple<K,V>>[]) new MyLinkedList<?>[m];

        for (int i = 0; i < slots.length; i++)
            slots[i] = new MyLinkedList<>();

    }


    @Override
    public void insert(K KEY, V VALUE) throws KeyAlreadyExistException {

        if (search(KEY) != null)
            throw new KeyAlreadyExistException();

        slots[universalHashing(KEY.hashCode(), slots.length, new Random(RANDOM_INT))].insert(new TwoTuple<>(KEY, VALUE));

    }


    @Override
    public V search(K KEY) {

        for (TwoTuple<K, V> keyValue : slots[universalHashing(KEY.hashCode(), slots.length, new Random(RANDOM_INT))]) {

            if (keyValue.first.equals(KEY)) {
                return keyValue.second;
            }

        }

        return null;

    }


    @Override
    @SuppressWarnings("unchecked")
    public void delete(K KEY) throws NoSuchKeyException {

        MyLinkedList<TwoTuple<K, V>> slot = slots[universalHashing(KEY.hashCode(), slots.length, new Random(RANDOM_INT))];

        MyLinkedList.Node node = slot.sentinel.getNext();

        for (TwoTuple<K, V> keyValue : slot) {

            if (keyValue.first.equals(KEY)) {
                break;
            }
            else {
                node = node.getNext();
            }

        }

        if (node == slot.sentinel) {
            throw new NoSuchKeyException();
        }
        else {
            slot.delete(node);
        }

    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (MyLinkedList<TwoTuple<K, V>> linkedList : slots)
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
