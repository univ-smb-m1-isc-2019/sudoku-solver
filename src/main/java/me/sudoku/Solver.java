package me.sudoku;

import java.util.Arrays;

public class Solver {
    void solve(int[][] board){
        Arrays.stream(board).forEach(e -> System.out.println(e[0]));

    }
}
