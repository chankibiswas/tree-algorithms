package com.algorithm.tree.trie;

class TrieNode {

    boolean isWord;

    TrieNode[] children;

    TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

}
