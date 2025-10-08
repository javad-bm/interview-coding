package io.github.jbm.questions.hash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Stack;

public class HashTable<K,V> {
    ArrayList<V> data;
    int size;

    public HashTable(int size) {
        this.data = new ArrayList<>(Collections.nCopies(size, null));
        this.size = size;
    }

    public void add(K key, V value) {
        int index = hash(key);
        data.add(index,value);
    }

    public V get(K key) {
        int index = hash(key);
        return data.get(index);
    }

    public V remove(K key) {
        int index = hash(key);
        return data.remove(index);
    }

    private Integer hash(K key) {
        return Objects.hashCode(key) % size;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
