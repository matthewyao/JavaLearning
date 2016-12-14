package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2016/12/13.
 */
public class L463_IslandPerimeter {
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
            {0,1,0,0},
            {1,1,1,0},
            {0,1,0,0},
            {1,1,0,0}
        }));
    }
    public static int islandPerimeter(int[][] grid) {
        int xLength = grid.length-1;
        int yLength = grid[0].length-1;
        int res = 0;
        for (int i = 0; i<= xLength; i++){
            for (int j = 0; j<= yLength; j++){
                if (grid[i][j] == 1){
                    if (i == 0 || grid[i-1][j] == 0) res++;
                    if (j == 0 || grid[i][j-1] == 0) res++;
                    if (i == xLength || grid[i+1][j] == 0) res++;
                    if (j == yLength || grid[i][j+1] == 0) res++;
                }
            }
        }
        return res;
    }
}
