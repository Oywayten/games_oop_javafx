package ru.job4j.puzzle;

public class Win {
    public static boolean monoHorizontal(int[][] board, int row) {
        for (int i = 0; i < board[row].length; i++) {
            if (board[row][i] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean monoVertical(int[][] board, int column) {
        for (int[] row : board) {
            if (row[column] != 1) {
                return false;
            }
        }
        return true;
    }

    public static int[] extractDiagonal(int[][] board) {
        int[] newArr = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            newArr[i] = board[i][i];
        }
        return newArr;
    }

    public static boolean check(int[][] board) {
        int[] newArr = extractDiagonal(board);
        for (int i = 0; i < newArr.length; i++) {
            if ((newArr[i] == 1) && (monoHorizontal(board, i) || monoVertical(board, i))) {
                return true;
            }
        }
        return false;
    }
}
