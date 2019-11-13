/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

/**
 *
 * @author tosur
 */
public class Board {

    private int[][] board;
    private int[] hints;
    private int size;

    Board(int size, int[] hints) {
        board = new int[size][size];
        this.hints = hints;
        this.size = size;
    }

    public int getTopConstraint(int col) {
        return hints[col];
    }

    public int getBottomConstraint(int col) {
        return hints[size * 3 - col - 1];
    }

    public int getRightConstraint(int row) {
        return hints[size + row];
    }

    public int getLeftConstraint(int row) {
        return hints[size * 4 - row - 1];
    }

    public void put(int row, int col, int value) {
        board[row][col] = value;
    }

    public int get(int row, int col) {
        return board[row][col];
    }

    public boolean checkRow(int row) {
        return false;
    }

    public boolean checkCol() {
        return false;
    }
}
