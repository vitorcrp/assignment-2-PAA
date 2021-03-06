package Questao2.Backtracking;

import java.util.Date;

import static Questao2.Backtracking.Sudoku.print;
import static Questao2.Backtracking.Sudoku.solveSudoku;

public class Main {

    public static void main(String[] args) {
        int[][] board = {
                { 5, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };

        var inicio = new Date().getTime();
        if (solveSudoku(board)) {
            print(board);
        }
        else {
            System.out.println("No solution");
        }
        var fim = new Date().getTime();
        System.out.println("\nTempo para execução: " + (fim-inicio)/1000.0 + " s.");
    }

}
