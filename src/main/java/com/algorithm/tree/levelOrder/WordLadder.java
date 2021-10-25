package com.algorithm.tree.levelOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord
 -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
*
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
*
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
public class WordLadder {

    public static void main(String[] st) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord) || endWord.length() != beginWord.length()) {
            return 0;
        }
        LinkedList<String> q = new LinkedList<>();
        int level = 1;
        q.addLast(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.removeFirst();
                if (endWord.equals(current)) {
                    return level;
                }
                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char c = chars[j];
                    for (char letter = 'a'; letter <= 'z'; letter++) {
                        if (c != letter) {
                            chars[j] = letter;
                            String temp = new String(chars);
                            if (wordSet.contains(temp)) {
                                q.addLast(temp);
                                wordSet.remove(temp);
                            }
                            chars[j] = c;
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
