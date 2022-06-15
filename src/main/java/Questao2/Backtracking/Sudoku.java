package Questao2.Backtracking;

import static java.lang.Math.sqrt;

class Sudoku {

    static int BOARD_LENGTH = 9;

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        for (int d = 0; d < BOARD_LENGTH; d++) {

            if (board[row][d] == num) {
                return false;
            }
        }

        for (int r = 0; r < BOARD_LENGTH; r++) {

            if (board[r][col] == num) {
                return false;
            }
        }

        int sqrt = (int) sqrt(BOARD_LENGTH);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solveSudoku(int[][] board) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        for (int i = 0; i < BOARD_LENGTH; i++) {
            for (int j = 0; j < BOARD_LENGTH; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;

                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        if (isEmpty) {
            return true;
        }

        for (int num = 1; num <= BOARD_LENGTH; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board)) {
                    return true;
                }
                else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void print(int[][] board) {
        for (int r = 0; r < BOARD_LENGTH; r++) {

            for (int d = 0; d < BOARD_LENGTH; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int)sqrt(BOARD_LENGTH) == 0) {
                System.out.print("");
            }
        }
    }

}