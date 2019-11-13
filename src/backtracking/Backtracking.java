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
public class Backtracking {

    static int size = 4;
    static Board board;

    public static void main(String[] args) {
        board = new Board(size, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        System.out.println(" " + solve());
        board.print();
    }

    static boolean placeNumber(int row, int col, int n) {
        board.put(row, col, n);
        return board.checkCol(col) && board.checkRow(row);
    }

    static boolean solve() {
        int[] rowcol = findEmptySpot();
        if (rowcol == null) {
            return true;
        }
        int row = rowcol[0];
        int col = rowcol[1];

        // try to put numbers 1 through size here
        for (int n = 1; n <= size; n++) {
            // try number
            if (placeNumber(row, col, n)) {
                if (solve()) {
                    // if one succeeded, we are done
                    return true;
                }
            }
        }
        // no number succeed here, restore board and report failure
        board.put(row, col, 0);
        return false;
    }

    static int[] findEmptySpot() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board.get(row, col) == 0) {
                    return new int[]{row, col};
                }
            }

        }
        return null;
    }
}
