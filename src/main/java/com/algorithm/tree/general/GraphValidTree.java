package com.algorithm.tree.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges
where edges[i] = [ai,bi] indicates that there is an undirected edge between nodes ai and bi in the graph.

Return true if the edges of the given graph make up a valid tree, and false otherwise.
*
Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true
*
Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false
 */
public class GraphValidTree {

    public static void main(String[] s) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int n = 5;
        System.out.println(validTree(n, edges));
    }

    public static boolean validTree(int n, int[][] edges) {
        if (n <= 1) {
            return true;
        }
        if (edges.length != n - 1) {
            return false;
        }
        List<List<Integer>> adjacencyList = new ArrayList();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> q = new LinkedList();
        q.addLast(0);
        while (!q.isEmpty()) {
            int current = q.removeFirst();
            List<Integer> next = adjacencyList.get(current);
            for (int i : next) {
                if (visited.contains(i)) {
                    continue;
                }
                q.addLast(i);
            }
            visited.add(current);
        }
        if (visited.size() == n) {
            return true;
        }
        return false;
    }
}
