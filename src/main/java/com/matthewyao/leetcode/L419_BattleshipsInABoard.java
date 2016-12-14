package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2016/12/13.
 */
public class L419_BattleshipsInABoard {
    public static void main(String[] args) {
        System.out.println(countBattleships(new char[][]{
            {'X','X','.','X','X','.','X'},
            {'.','.','X','.','.','X','.'},
            {'X','.','X','.','X','.','X'},
            {'X','.','X','.','.','X','.'}
        }));
    }
    public static int countBattleships(char[][] board) {
        int i,j,sum=0;
        int xLength = board.length;
        int yLength = board[0].length;
        for (i = 0; i<xLength; i++){
            for (j = 0; j < yLength; j++){
                if (board[i][j] == 'X'){
                    if (i == 0 && j == 0) {
                        sum++;
                    }
                    else if (i == 0){
                        if (board[i][j-1] == '.'){
                            sum++;
                        }
                    }else if (j == 0){
                        if (board[i-1][j] == '.'){
                            sum++;
                        }
                    }else if(board[i-1][j] == '.' && board[i][j-1] == '.')
                    {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }
}
