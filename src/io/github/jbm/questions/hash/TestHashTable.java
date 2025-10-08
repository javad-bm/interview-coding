package io.github.jbm.questions.hash;

public class TestHashTable {
    public static void main(String[] args) {

        var hashTable = new HashTable<String, String>(3);

        hashTable.add("Key1", "Value1");
        hashTable.add("Key2", "Value2");
        hashTable.add("Key3", "Value3");
        hashTable.add("Key4", "Value4");

        System.out.println(hashTable.get("Key1"));
        System.out.println(hashTable.get("Key2"));
        System.out.println(hashTable.get("Key3"));
        System.out.println(hashTable.get("Key4"));

        System.out.println(hashTable.remove("Key4"));

        System.out.println(hashTable);
    }
}
