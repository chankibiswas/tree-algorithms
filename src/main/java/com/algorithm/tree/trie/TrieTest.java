package com.algorithm.tree.trie;

public class TrieTest {

    public static void main(String[] s) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
