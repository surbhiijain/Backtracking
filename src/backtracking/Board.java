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

    private boolean checkSet(int[] set, int leftHint, int rightHint) {
        // check for uniqueness
        boolean[] seen = new boolean[size];
        for (int i = 0; i < seen.length; i++) {
            if (set[i] == 0) {
                continue;
            }
            if (seen[set[i] - 1]) {
                return false;
            }
            seen[set[i] - 1] = true;
        }
        if (leftHint != 0) {
            // count from left
            int maxSeen = 0;
            int count = 0;
            for (int i = 0; i < set.length; i++) {
                if (set[i] == 0) {
                    return true; // all partial sets are set as true
                }
                if (set[i] > maxSeen) {
                    count++;
                    maxSeen = set[i];
                }
            }
            if (count != leftHint) {
                return false;
            }
        }
        if (rightHint != 0) {
            int maxSeen = 0;
            int count = 0;
            for (int i = set.length - 1; i >= 0; i--) {
                if (set[i] == 0) {
                    return true; // all partial sets are set as true
                }
                if (set[i] > maxSeen) {
                    count++;
                    maxSeen = set[i];
                }
            }
            if (count != rightHint) {
                return false;
            }
            // count from right
        }
        return true;
    }

    public boolean checkRow(int row) {
        return checkSet(board[row], this.getLeftConstraint(row), this.getRightConstraint(row));
    }

    public boolean checkCol(int col) {
        int[] set = new int[size];
        for (int i = 0; i < set.length; i++) {
            set[i] = board[i][col];
        }
        return checkSet(set, this.getLeftConstraint(col), this.getRightConstraint(col));

    }
}
