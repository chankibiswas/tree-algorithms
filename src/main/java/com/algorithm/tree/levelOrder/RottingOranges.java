package com.algorithm.tree.levelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
*
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
*
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
*
Input: grid = [[0,2]]
Output: 0
 */
public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        LinkedList<Pair> q = new LinkedList<>();
        q.addAll(getSpecificTypeOfOranges(grid, 2));
        int row = grid.length;
        int column = grid[0].length;
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair c = q.removeFirst();
                if (c.x + 1 < row && grid[c.x + 1][c.y] == 1) {
                    q.addLast(new Pair(c.x + 1, c.y));
                    grid[c.x + 1][c.y] = 2;
                }
                if (c.x - 1 >= 0 && grid[c.x - 1][c.y] == 1) {
                    q.addLast(new Pair(c.x - 1, c.y));
                    grid[c.x - 1][c.y] = 2;
                }
                if (c.y + 1 < column && grid[c.x][c.y + 1] == 1) {
                    q.addLast(new Pair(c.x, c.y + 1));
                    grid[c.x][c.y + 1] = 2;
                }
                if (c.y - 1 >= 0 && grid[c.x][c.y - 1] == 1) {
                    q.addLast(new Pair(c.x, c.y - 1));
                    grid[c.x][c.y - 1] = 2;
                }
            }
            count++;
        }
        List<Pair> freshOranges = getSpecificTypeOfOranges(grid, 1);
        if (freshOranges.size() > 0) {
            return -1;
        } else {
            if (count > 0) {
                return count - 1;
            }
            return 0;
        }
    }

    private List<Pair> getSpecificTypeOfOranges(int[][] grid, int type) {
        List<Pair> oranges = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == type) {
                    oranges.add(new Pair(i, j));
                }
            }
        }
        return oranges;
    }

    public class Pair {

        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
