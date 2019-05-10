package io.github.wangyuxiang0829.algorithms.chap11;

public interface MyHashTable<K, V> {
    void insert(K KEY, V VALUE);

    V search(K KEY);

    void delete(K KEY);
}
