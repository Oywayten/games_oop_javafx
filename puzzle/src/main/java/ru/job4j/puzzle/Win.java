package ru.job4j.puzzle;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Win {
    public static boolean check(int[][] board) {
        int[] diagonalArray = new int[board.length];
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                diagonalArray[count] = i;
                count++;
            }
        }
        if (count == 0) {
            return false;
        }
        diagonalArray = Arrays.copyOf(diagonalArray, count);
        count = 0;
        for (int i = 0; i < diagonalArray.length; i++) {
            for (int j = 0; j < board[diagonalArray[i]].length; j++) {
                if (board[diagonalArray[i]][j] == 1) {
                    count++;
                }
                if (count == board[i].length) {
                    return true;
                }
            }
            count = 0;
            for (int[] ints : board) {
                if (ints[diagonalArray[i]] == 1) {
                    count++;
                }
                if (count == board.length) {
                    return true;
                }
            }
        }
        return false;
    }
}
