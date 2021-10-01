package com.algorithm.tree.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there
is an edge between ai and bi in the graph.
Return the number of connected components in the graph.
*
Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
*
Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 */
public class NumberOfConnectedComponentsInUndirectedGraph {

    public static void main(String[] s) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(new NumberOfConnectedComponentsInUndirectedGraph().countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {
        if (edges.length == 0) {
            return n;
        }
        List[] adjacencyList = new List[n];
        Set<Integer> visited = new HashSet();

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int first = edge[0];
            int second = edge[1];
            if (adjacencyList[first] == null) {
                List<Integer> lst = new ArrayList();
                adjacencyList[first] = lst;
            }
            adjacencyList[first].add(second);
            if (adjacencyList[second] == null) {
                List<Integer> lst = new ArrayList();
                adjacencyList[second] = lst;
            }
            adjacencyList[second].add(first);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                count++;
                dfs(i, adjacencyList, visited);
            }
        }

        return count;
    }

    private void dfs(int i, List[] adjacencyList, Set<Integer> visited) {
        if (visited.contains(i)) {
            return;
        }
        List<Integer> lst = adjacencyList[i];
        visited.add(i);
        if (lst == null) {
            return;
        } else {
            for (int j : lst) {
                dfs(j, adjacencyList, visited);
            }
        }
    }
}
